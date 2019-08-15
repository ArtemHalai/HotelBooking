<%@ page import="java.util.Map" %>
<%@ page import="java.io.InputStream" %>
<%@ page import="java.util.Properties" %>
<%@ page import="java.io.IOException" %>
<%@ page pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setLocale value="${language}"/>
<fmt:setBundle basename="booking"/>
<html lang="${language}">
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1"/>
    <style>
        <%@include file="../../css/booking.css" %>
    </style>
    <script src="booking.js" defer></script>
    <title><fmt:message key="booking.title"/></title>
</head>
<body>
<div class="bg-image"></div>

<div class="main">
    <p class="book" align="center">
        <%
            Properties properties = new Properties();
            InputStream inputStream = getClass()
                    .getClassLoader().getResourceAsStream("mapping.properties");
            try {
                properties.load(inputStream);
            } catch (IOException e) {
                e.printStackTrace();
            }
            String h = properties.getProperty("home");
            Map<String, String> errors = (Map<String, String>) request.getAttribute("errors");
            String date = null;
            String available = null;
            if (errors != null) {
                date = errors.get("date");
                available = errors.get("available");
            }
            if (date != null) {
        %><fmt:message key="booking.error.date"/><%
    } else if (available != null) {
    %><fmt:message key="booking.error.available"/><%
    } else {
    %><fmt:message key="booking.criteria"/><%
        }
    %>
    </p>
    <form id="booking" class="bookingForm" action="booking" method="post">
        <div class="container">
            <div class="checkboxContainer">
                <div>
                    <input class="check" id="balcony" type="checkbox" name="balcony">
                    <label for="balcony"><fmt:message key="booking.balcony"/></label>
                </div>
                <div>
                    <input class="check" id="smoke" type="checkbox" name="smoke">
                    <label for="smoke"><fmt:message key="booking.smoke"/></label>
                </div>
            </div>
            <div class="roomType">
                <label for="roomType"><fmt:message key="booking.roomtype"/></label>
                <select id="roomType" form="booking" name="roomType">
                    <option><fmt:message key="booking.roomtype.single"/></option>
                    <option><fmt:message key="booking.roomtype.double"/></option>
                    <option><fmt:message key="booking.roomtype.lux"/></option>
                </select>
            </div>
        </div>
        <div class="container2">
            <div class="priceRange">
                <label for="priceRange"><fmt:message key="booking.pricerange"/></label>
                <select id="priceRange" form="booking" name="priceRange">
                    <option>0-90</option>
                    <option>0-180</option>
                    <option>0-300</option>
                </select>
            </div>
            <div class="dates">
                <label for="dateIn">
                    <fmt:message key="booking.datein"/></label>
                <input class="date" required type="date" id="dateIn" name="dateIn">
                <label for="dateOut"><fmt:message key="booking.dateout"/></label>
                <input class="date" required type="date" id="dateOut" name="dateOut">
            </div>
            <div class="container">
                <a href="<%=h%>" class="submit" align="center" style="text-decoration: none;"><fmt:message
                        key="booking.return"/></a>
                <input type="submit" class="submit" value=<fmt:message key="booking.book"/>>
            </div>
        </div>
    </form>
</div>
</body>
</html>