<%@ page import="java.util.Map" %>
<%@ page import="java.io.InputStream" %>
<%@ page import="java.util.Properties" %>
<%@ page import="java.io.IOException" %>
<%@ page pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setLocale value="${language}"/>
<fmt:setBundle basename="guest_info"/>
<html lang="${language}">
<head>
    <style>
        <%@include file="../../css/guest_info.css" %>
    </style>
    <meta charset="UTF-8" name="viewport" content="width=device-width, initial-scale=1"/>
    <title><fmt:message key="info.title"/></title>
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

        String name = null;
        String surname = null;
        String phoneNumber = null;
        String passportId = null;
        String wrong = null;
        String cardNumber = null;
        String cvCode = null;
        String expiryDate = null;
        String age = null;
        if (errors != null) {
            name = errors.get("name");
            surname = errors.get("surname");
            phoneNumber = errors.get("phoneNumber");
            passportId = errors.get("passportId");
            wrong = errors.get("guest");
            age = errors.get("age");
            cardNumber = errors.get("cardNumber");
            cvCode = errors.get("cvCode");
            expiryDate = errors.get("expiryDate");
        }%>
    <p class="sign" align="center">
        <%
            if (wrong != null) {
        %><fmt:message key="info.wrong"/><%
    } else {
    %><fmt:message key="info.title"/><%
        }
    %>
    </p>
    <form class="guestInfoForm" action="guest_info" method="post">
        <label for="name">
            <% if (name != null) {
            %><fmt:message key="info.error.name"/><%
            }
        %>
        </label>
        <input class="uname" required id="name" name="name" type="text" align="center" placeholder=<fmt:message
                key="info.name"/>>
        <label for="surname">
            <% if (surname != null) {
            %><fmt:message key="info.error.surname"/><%
            }
        %>
        </label>
        <input name="price" type="hidden" value=${price}>
        <input name="roomId" type="hidden" value=${roomId}>
        <input name="reservationId" type="hidden" value=${reservationId}>
        <input class="uname" required id="surname" name="surname" type="text" align="center" placeholder=<fmt:message
                key="info.surname"/>>
        <label for="age">
            <% if (age != null) {
            %><fmt:message key="info.error.age"/><%
            }
        %>
        </label>
        <input class="uname" id="age" required name="age" type="text" align="center" placeholder=<fmt:message
                key="info.age"/>>
        <label for="phoneNumber">
            <% if (phoneNumber != null) {
            %><fmt:message key="info.error.phoneNumber"/><%
            }
        %>
        </label>
        <input class="uname" required id="phoneNumber" name="phoneNumber" type="text" align="center" placeholder=
        <fmt:message key="info.phoneNumber"/>>
        <label for="passportId">
            <% if (passportId != null) {
            %><fmt:message key="info.error.passportId"/><%
            }
        %>
        </label>
        <input class="uname" required id="passportId" name="passportId" type="text" align="center" placeholder=
        <fmt:message key="info.passportId"/>>
        <label for="cardNumber">
            <% if (cardNumber != null) {
            %><fmt:message key="info.error.cardNumber"/><%
        } else {
        %>
            <fmt:message key="info.cardNumber"/>
            <%
                }
            %>
            <input class="uname" required id="cardNumber" name="cardNumber" type="text" align="center" placeholder=
            <fmt:message key="info.cardNumber.holder"/>>
        </label>
        <div class="cardContainer">
            <label for="expiryDate">
                <% if (expiryDate != null) {
                %><fmt:message key="info.error.valid"/><%
            } else {
            %>
                <fmt:message key="info.valid"/>
                <%
                    }
                %>
                <input class="uname" required id="expiryDate" name="expiryDate" type="date" align="center">
            </label>
            <label for="cvCode">
                <% if (cvCode != null) {
                %><fmt:message key="info.error.cvcode"/><%
            } else {
            %>
                <fmt:message key="info.cvcode"/>
                <%
                    }
                %>
                <input class="uname" required id="cvCode" name="cvCode" type="text" align="center" placeholder=
                <fmt:message key="info.cvcode.holder"/>>
            </label>
        </div>
        <label for="id"><fmt:message key="info.reservationId"/>
            <p class="uname" id="id" name="id" align="center">
                <c:out value="${reservationId}"/>
            </p></label>
        <label for="totalPrice"><fmt:message key="info.total"/>
            <p class="uname" id="totalPrice" name="totalPrice" type="text" align="center">
                <c:out value="${price}$"/>
            </p>
        </label>
        <input type="submit" class="information" align="center" value=<fmt:message key="info.submit"/>>
        <a href="<%=h%>" class="return" align="center" style="text-decoration: none;"><fmt:message
                key="info.return"/></a>
    </form>
</div>
</body>
</html>