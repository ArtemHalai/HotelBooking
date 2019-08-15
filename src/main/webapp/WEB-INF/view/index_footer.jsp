<%@ page pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setLocale value="${language}"/>
<fmt:setBundle basename="nav"/>
<html lang="${language}">

<head>
    <style>
        <%@include file="../../css/index_footer.css" %>
    </style>
    <meta charset="UTF-8" name="viewport" content="width=device-width, initial-scale=1"/>
</head>
<body>
<div class="footerlist">
    <span class="socImg"><fmt:message key="nav.label.contact"/></span>
    <span class="socImg"><fmt:message key="nav.label.mail"/></span>
</div>
</body>
</html>
