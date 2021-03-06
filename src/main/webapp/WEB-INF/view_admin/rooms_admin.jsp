<%@ page pageEncoding="UTF-8" %>
<%@ page import="model.entity.RoomType" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setLocale value="${language}"/>
<fmt:setBundle basename="admin"/>
<html lang="${language}">
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1"/>
    <style>
        <%@include file="../../css/admin.css" %>
    </style>
    <style>
        <%@include file="../../css/bootstrap/bs.css" %>
    </style>
    <title>Rooms</title>
</head>
<body>
<% String errors = (String) request.getAttribute("errors");%>
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
            <input name="count" id="count" type="hidden" value=${count}>
        </ul>
    </div>
</nav>
<div class="parent">
    <div class="child1">
        <table class="table">
            <thead>
            <td><fmt:message key="id"/></td>
            <td><fmt:message key="balcony"/></td>
            <td><fmt:message key="smoke"/></td>
            <td><fmt:message key="price"/></td>
            <td><fmt:message key="roomTypeId"/></td>
            </thead>
            <% if (errors == null) {%>
            <c:forEach items="${rooms}" var="r">
                <tr>
                    <td>${r.id}</td>
                    <td><c:choose>
                        <c:when test="${r.balcony=='true'}">
                            &#10004;
                        </c:when>
                        <c:otherwise>
                            &#10008;
                        </c:otherwise>
                    </c:choose>
                    </td>
                    <td><c:choose>
                        <c:when test="${r.smoke=='true'}">
                            &#10004;
                        </c:when>
                        <c:otherwise>
                            &#10008;
                        </c:otherwise>
                    </c:choose></td>
                    <td>${r.price}</td>
                    <td>${r.roomTypeId.id}</td>
                </tr>
            </c:forEach>
            <%} else {%>
            <tr class="error"><fmt:message key="noRooms"/></tr>
            <%}%>
            <tfoot>
            <td><fmt:message key="id"/></td>
            <td><fmt:message key="balcony"/></td>
            <td><fmt:message key="smoke"/></td>
            <td><fmt:message key="price"/></td>
            <td><fmt:message key="roomTypeId"/></td>
            </tfoot>
        </table>
    </div>
    <div class="child2">
        <div class="prevNextContainer">
            <a <c:choose>
                <c:when test="${page=='1'}">
                    style="visibility:hidden;"
                </c:when>
                <c:otherwise>
                    style="visibility:visible;font-size:1.5em; color:white;font-weight:bold;"
                </c:otherwise>
            </c:choose>
                        <%int p = (Integer)request.getAttribute("page")-1;%>href="rooms_admin?page=<%=p%>" class="btn"
                        id="btn_prev"><fmt:message key="prev"/></a>
            <span style="font-size:1.3em; color:white;font-weight:bold;" class="pages" id="page">${page}</span>
            <a  <c:choose>
                <c:when test="${count=='0'}">
                    style="visibility:hidden;"
                </c:when>
                <c:when test="${count<=page*'10'}">
                    style="visibility:hidden;"
                </c:when>
                <c:otherwise>
                    style="visibility:visible;font-size:1.5em; color:white;font-weight:bold;"
                </c:otherwise>
            </c:choose>
                        <% int p1 = (Integer) request.getAttribute("page") + 1;%>href="rooms_admin?page=<%=p1%>"
                        class="btn" id="btn_next"><fmt:message key="next"/></a>
        </div>
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