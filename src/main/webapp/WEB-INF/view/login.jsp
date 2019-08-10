<%@ page import="java.util.Map" %>
<%@ page import="java.io.InputStream" %>
<%@ page import="java.util.Properties" %>
<%@ page import="java.io.IOException" %>
<%@ page pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setLocale value="${language}" />
<fmt:setBundle basename="login" />
<html lang="${language}">

<head>
    <style><%@include file="../../css/login.css"%></style>
    <meta name="viewport" content="width=device-width, initial-scale=1" />
    <title><fmt:message key="login.label.sign_in"/></title>
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
            String reg = properties.getProperty("registration");
    %>
<div class="main">
    <p class="sign" align="center"><fmt:message key="login.label.sign_in"/></p>
    <form class="loginForm" method="post" action="login">
        <label for="uname">
        <% Map<String, String> errors = (Map<String, String>) request.getAttribute("errors");
        String username = null;
        String exist = null;
        String password = null;
         if(errors!=null){
         username = errors.get("username");
         exist = errors.get("user");
         password = errors.get("password");
         }
        if (username!=null){
            %><fmt:message key="login.error.username"/><%
        }
        if(exist!=null){
        %><fmt:message key="login.error.exist"/><%
        }
        %>
        </label>
        <input class="uname" id="uname" required name="username" type="text" align="center" placeholder=<fmt:message key="login.label.username"/>>
        <label for="pass">
        <%
                if (password!=null){
                    %><fmt:message key="login.error.password"/><%
                }
                %>
        </label>
        <input class="pass" id="pass" required name="password" type="password" align="center" placeholder=<fmt:message key="login.label.password"/>>
        <input type = "submit" class="submit" align="center" value=<fmt:message key="login.label.sign_in"/>>
        <a href="<%=reg%>" class="registration" align="center" style="text-decoration: none;"><fmt:message key="login.label.register"/></a>
        <a href="<%=h%>" class="return" align="center" style="text-decoration: none;"><fmt:message key="login.label.return"/></a>
    </form>
</div>

</body>

</html>