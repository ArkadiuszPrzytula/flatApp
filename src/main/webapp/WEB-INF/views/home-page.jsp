<%--
  Created by IntelliJ IDEA.
  User: akprz
  Date: 05.08.2020
  Time: 01:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<html>
<head>

    <link href="../../static/css/style.css" type="text/css" rel="stylesheet">

</head>
<body>

<section id="container">
    <header class="header black-bg">
        <jsp:include page="header.jsp"/>
    </header>
    <div>
        <div id="leftSideOfWeb">
            <jsp:include page="side-menu.jsp"/>
        </div>
        <section id="main-content">
            <section class="wrapper">

                <div style="height:100%;"><jsp:include page="main-section.jsp"/></div>

            </section>
        </section>
    </div>
    <footer class="site-footer">
        <jsp:include page="footer.jsp"/>
    </footer>
</section>
</body>
</html>


</body>
</html>
