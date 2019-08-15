<%@ page pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setLocale value="${language}"/>
<fmt:setBundle basename="admin"/>
<html lang="${language}">
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1"/>
    <style>
        <%@include file="../../css/home_admin.css" %>
    </style>
    <style>
        <%@include file="../../css/bootstrap/bs.css" %>
    </style>
    <title><fmt:message key="home"/></title>
</head>
<body>
<nav class=" anim adminnav navbar navbar-expand-md bg-dark navbar-dark">
    <a class="navbar-brand" href="home"><fmt:message key="welcome"/></a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#collapsibleNavbar">
        <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="collapsibleNavbar">
        <ul class="navbar-nav">
            <li class="nav-item">
                <a href="home_admin" class="nav-link" id="home"><fmt:message key="home"/></a>
            </li>
            <li class="nav-item">
                <a href="rooms_admin" class="nav-link" id="rooms"><fmt:message key="rooms"/></a>
            </li>
            <li class="nav-item">
                <a href="reservations_admin" class="nav-link" id="reservations"><fmt:message key="reservations"/></a>
            </li>
            <li class="nav-item">
                <a href="guests_admin" class="nav-link" id="guests"><fmt:message key="guests"/></a>
            </li>
            <li class="nav-item">
                <a href="payments_admin" class="nav-link" id="payments"><fmt:message key="payments"/></a>
            </li>
            <li class="nav-item">
                <a href="room_requests_admin" class="nav-link" id="room_requests"><fmt:message key="room_requests"/></a>
            </li>
            <li class="nav-item">
                <a href="login" class="nav-link" id="login">
                    <% if (session.getAttribute("ADMIN") != null) {
                    %><fmt:message key="logout"/><%
                } else {%>
                    <fmt:message key="login"/>
                    <%}%></a>
            </li>
        </ul>
    </div>
</nav>
<div class="content">

</div>
</div>
<script>
    <%@include file="../../js/bootstrap/bootstrap_script_1.js" %>
</script>
<script>
    <%@include file="../../js/bootstrap/bootstrap_script_2.js" %>
</script>
<script>
    <%@include file="../../js/bootstrap/bootstrap_script_3.js" %>
</script>
</body>
</html>