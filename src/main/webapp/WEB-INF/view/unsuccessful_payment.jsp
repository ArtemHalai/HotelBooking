<%@ page pageEncoding="UTF-8" %>
<%@ page import="java.io.InputStream" %>
<%@ page import="java.util.Properties" %>
<%@ page import="java.io.IOException" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setLocale value="${language}"/>
<fmt:setBundle basename="payment"/>
<html lang="${language}">
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1"/>
    <style>
        <%@include file="../../css/successful_payment.css" %>
    </style>
    <title><fmt:message key="payment.title"/></title>
</head>
<body>
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
%>
<div class="unsuccessContainer">
    <div class="horizontalContainer">
        <img class="unsuccess" src="../../images/unsuccess.jpg">
        <div class="unsuccessTextContainer"><fmt:message key="payment.unsuccessful"/></div>
    </div>
    <a href="<%=h%>" class="returnUnsuccess" align="center" style="text-decoration: none;"><fmt:message
            key="payment.return"/></a>
</div>
</body>
</html>