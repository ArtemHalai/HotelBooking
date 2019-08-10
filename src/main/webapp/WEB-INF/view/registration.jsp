<%@ page import="java.util.Map" %>
<%@ page import="java.io.InputStream" %>
<%@ page import="java.util.Properties" %>
<%@ page import="java.io.IOException" %>
<%@ page pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setLocale value="${language}" />
<fmt:setBundle basename="reg" />
<html lang="${language}">
<head>
     <style><%@include file="../../css/registration.css"%></style>
    <script src="registration.js" defer></script>
    <meta charset="UTF-8" name="viewport" content="width=device-width, initial-scale=1"/>
    <title><fmt:message key="reg.reg"/></title>
</head>
<body>
<div class="main">
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
        String name = null;
        String surname = null;
        String username = null;
        String password = null;
        String phoneNumber = null;
        String passportId = null;
        String exist = null;
         String age = null;
         if(errors!=null){
         name = errors.get("name");
         surname = errors.get("surname");
         username = errors.get("username");
         password = errors.get("password");
         age = errors.get("age");
         phoneNumber = errors.get("phoneNumber");
         passportId = errors.get("passportId");
         exist = errors.get("user");
         }%>
    <p class="sign" align="center"><fmt:message key="reg.reg"/></p>
    <form class="registrationForm" action="registration" method="post">
        <label for="name">
                        <% if (name!=null){
                                    %><fmt:message key="reg.error.name"/><%
                                }
                                %>
                        </label>
        <input class="uname" required id="name" name="name" type="text" align="center" placeholder=<fmt:message key="reg.name"/>>
        <label for="surname">
                        <% if (surname!=null){
                                    %><fmt:message key="reg.error.surname"/><%
                                }
                                %>
                        </label>
        <input class="uname" required id="surname" name="surname" type="text" align="center" placeholder=<fmt:message key="reg.surname"/>>
        <label for="username">
                        <% if (username!=null){
                                    %><fmt:message key="reg.error.username"/><%
                                }if(exist!=null){
                                %><fmt:message key="reg.error.exist"/><%
                                }
                                %>
                        </label>
        <input class="uname" required id="username" name="username" type="text" align="center" placeholder=<fmt:message key="reg.username"/>>
        <label for="password">
                <% if (password!=null){
                            %><fmt:message key="reg.error.password"/><%
                        }
                        %>
                </label>
        <input class="uname" required id="password" name="password" type="password" align="center" placeholder=<fmt:message key="reg.password"/>>
        <label for="age">
                                <% if (age!=null){
                                            %><fmt:message key="reg.error.age"/><%
                                        }
                                        %>
                                </label>
        <input class="uname" id="age" required name="age" type="text" align="center" placeholder=<fmt:message key="reg.age"/>>
        <label for="phoneNumber">
                        <% if (phoneNumber!=null){
                                    %><fmt:message key="reg.error.phoneNumber"/><%
                                }
                                %>
                        </label>
        <input class="uname" required id="phoneNumber" name="phoneNumber" type="text" align="center" placeholder=<fmt:message key="reg.phoneNumber"/>>
        <label for="passportId">
                        <% if (passportId!=null){
                                    %><fmt:message key="reg.error.passportId"/><%
                                }
                                %>
                        </label>
        <input class="uname" required id="passportId" name="passportId" type="text" align="center" placeholder=<fmt:message key="reg.passportId"/>>
        <input type="submit" class="registration" align="center" value=<fmt:message key="reg.reg"/>>
        <a href="<%=h%>"class="return" align="center" style="text-decoration: none;"><fmt:message key="reg.return"/></a>
    </form>
</div>
</body>
</html>