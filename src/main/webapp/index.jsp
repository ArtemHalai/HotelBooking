<%@ page import="java.io.InputStream" %>
<%@page import="java.util.Locale"%>
<%@ page import="java.util.Properties" %>
<%@ page import="java.io.IOException" %>
<%@ page pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setLocale value="${language}" />
<fmt:setBundle basename="nav" />
<html lang="${language}">

<head>
   <meta name="viewport" content="width=device-width, initial-scale=1" />
    <style><%@include file="css/index.css"%></style>
    <title><fmt:message key="nav.label.home"/></title>
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
            String login = properties.getProperty("login");
            String booking = properties.getProperty("booking");
            String h = properties.getProperty("home");
    %>
<div class="button_bar" id="but_bar">
    <a href="#home_part" class="but" id="home"><fmt:message key="nav.label.home"/></a>
    <a href="<%=booking%>" class="but" id="booking"><fmt:message key="nav.label.booking"/></a>
    <a href="#about_part" class="but" id="about"><fmt:message key="nav.label.about"/></a>
    <a href="<%=login%>" class="but" id="login">
    <% if(session.getAttribute("GUEST")!=null){
    %><fmt:message key="nav.label.logout"/><%
    }else{%>
    <fmt:message key="nav.label.login"/>
    <%}%></a>

    <form class="sel" action="<%=h%>">
   <select name="locale" onchange="this.form.submit()">
   <% Locale l = Locale.getDefault();
   HttpSession sess = request.getSession();
   String lang = (String)sess.getAttribute("language");
   if(lang == null){
   lang = l.getLanguage();
   sess.setAttribute("language", lang);
   } %>
   <option value="en" ${language == 'en' ? "selected" : ""}>English</option>
    <option value="ru" ${language == 'ru' ? "selected" : ""}>Русский</option>
   <option value="ua" ${language == 'ua' ? "selected" : ""}>Українська</option>
    </select>
    </form>

</div>
<div class="content">
    <div class="container">
        <div class="homeArea" id="home_part">
            <span id="slide-1"></span>
            <span id="slide-2"></span>
            <span id="slide-3"></span>
            <span id="slide-4"></span>
            <span id="slide-5"></span>
            <div class="sliderCont">
                <img src="images/5.jpg" class="image" alt="bed">
                <img src="images/6.jpg" class="image" alt="bar">
                <img src="images/9.jpg" class="image" alt="room">
                <img src="images/1.jpg" class="image" alt="bed">
                <img src="images/3.jpg" class="image" alt="pool">
            </div>
            <div class="buttonCont">
                <a href="#slide-1" class="slideBtn"></a>
                <a href="#slide-2" class="slideBtn"></a>
                <a href="#slide-3" class="slideBtn"></a>
                <a href="#slide-4" class="slideBtn"></a>
                <a href="#slide-5" class="slideBtn"></a>
            </div>
        </div>
        <div class="aboutArea" id="about_part">
        <img class="bird" id="bird1" src="images/bird.gif">
                <img class="bird" id="bird2" src="images/bird.gif">
                <img class="bird" id="bird3" src="images/bird.gif">
                <img class="bird" id="bird4" src="images/bird.gif">
                <img class="bird" id="bird5" src="images/bird.gif">
                <img class="bird" id="bird6" src="images/bird.gif">
                <img class="bird" id="bird7" src="images/bird.gif">
                <img class="bird" id="bird8" src="images/bird.gif">
                <img class="bird" id="bird9" src="images/bird.gif">
                <img class="bird" id="bird10" src="images/bird.gif">
            <section class="gridContainer">
                <nav><img src="images/7.jpg"></nav>
                <main><fmt:message key="nav.about"/>
                </main>

                <audio preload="auto" src="audio/bird_sound.wav" id="audio" type="audio/wav" loop="loop"></audio>

<footer>
<jsp:include page="WEB-INF/view/index_footer.jsp"></jsp:include>
</footer>
            </section>
        </div>
    </div>
</div>
</div>
<script><%@include file="js/index.js"%></script>
</body>
</html>