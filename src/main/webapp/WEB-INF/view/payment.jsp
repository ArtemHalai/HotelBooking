<%@ page import="java.util.Map" %>
<%@ page import="java.io.InputStream" %>
<%@ page import="java.util.Properties" %>
<%@ page import="java.io.IOException" %>
<%@ page pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setLocale value="${language}" />
<fmt:setBundle basename="payment" />
<html lang="${language}">
<head>
    <style><%@include file="../../css/payment.css"%></style>
        <meta charset="UTF-8" name="viewport" content="width=device-width, initial-scale=1"/>
        <title><fmt:message key="payment.title"/></title>
</head>
<body>
<div class="bg-image"></div>
<div class="main">
<% Properties properties = new Properties();
               InputStream inputStream = getClass()
                       .getClassLoader().getResourceAsStream("mapping.properties");
               try {
                   properties.load(inputStream);
               } catch (IOException e) {
                   e.printStackTrace();
               }
               String h = properties.getProperty("home");
Map<String, String> errors = (Map<String, String>) session.getAttribute("errors");
        String cardNumber = null;
        String cvCode = null;
        String expiryDate = null;
        if (errors != null) {
            cardNumber = errors.get("cardNumber");
            cvCode = errors.get("cvCode");
            expiryDate = errors.get("expiryDate");
        }%>
    <p class="sign" align="center"><fmt:message key="payment.title"/></p>
    <form class="paymentForm" action="payment" method="post">
    <label for="cardNumber">
    <% if (cardNumber != null) {
                        %><fmt:message key="payment.error.cardNumber"/><%
                        }else{
                    %>
            <fmt:message key="payment.cardNumber"/>
            <%
            }
            %>
                <input class="uname" required id="cardNumber" name="cardNumber" type="text" align="center" placeholder=<fmt:message key="payment.cardNumber.holder"/>>
                </label>
                <div class="cardContainer">
                <label for="expiryDate">
                <% if (expiryDate != null) {
                                                %><fmt:message key="payment.error.valid"/><%
                                                }else{
                                            %>
                                    <fmt:message key="payment.valid"/>
                                    <%
                                    }
                                    %>
                <input class="uname" required id="expiryDate" name="expiryDate" type="date" align="center">
                 </label>
                 <input name="price" type="hidden" value=${price}>
                         <input name="roomId" type="hidden" value=${roomId}>
                         <input name="reservationId" type="hidden" value=${reservationId}>
                         <input name="guest" type="hidden" value=${GUEST}>
                 <label for="cvCode">
                 <% if (cvCode != null) {
                                                 %><fmt:message key="payment.error.cvcode"/><%
                                                 }else{
                                             %>
                                     <fmt:message key="payment.cvcode"/>
                                     <%
                                     }
                                     %>
                <input class="uname" required id="cvCode" name="cvCode" type="text" align="center" placeholder=<fmt:message key="payment.cvcode.holder"/>>
                 </label>
                </div>
                <label for="reservationId"><fmt:message key="payment.reservationId"/>
              <p class="uname" id="id" name="id" align="center">
                              <c:out value="${reservationId}"/></p>
                              </label>
                              <label for="totalPrice"><fmt:message key="payment.total"/>
                              <p class="uname" id="totalPrice" name="totalPrice" type="text" align="center">
                                              <c:out value="${price}$"/></p>
                                              </label>
        <input type="submit" class="information" align="center" value=<fmt:message key="payment.pay"/>>
        <a href="<%=h%>" class="return" align="center" style="text-decoration: none;"><fmt:message key="payment.return"/></a>
    </form>
</div>
</body>
</html>