<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>

<html>
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <!-- CSRF Token -->
    <sec:csrfMetaTags/>

    <title>Concessionaire</title>

    <!-- Static files importation from tiles -->
    <tiles:importAttribute name="filesCSS"/>
    <tiles:importAttribute name="filesJS"/>
    <tiles:importAttribute name="onLoadJS"/>

    <c:forEach var="item" items="${filesCSS}">
        <link rel="stylesheet" href="<spring:url value="${item}"/>"/>
    </c:forEach>
    <c:forEach var="item" items="${filesJS}">
        <script src="<spring:url value="${item}"/>"></script>
    </c:forEach>

    <c:set var="localeCode" value="${user.language}" scope="request"/>

    <script>
        // Load JS functions defined in tiles
        $(document).ready(function () {
            <c:forEach var="item" items="${onLoadJS}">
            <tiles:insertAttribute value="${item}" flush="true" />
            </c:forEach>
        });
    </script>

</head>
<body class="nav-md">
<div class="container body">
    <div id="main_container" class="main_container">

        <!-- HEADER -->
        <div id="header" class="navbar navbar-default navbar-fixed-top">
            <tiles:insertAttribute name="header"/>
        </div>

        <div id="wrapper">
            <!-- SIDE MENU -->
            <div id="sidebar-wrapper" class="col-md-2 col-sm-2 col-xs-2">
                <tiles:insertAttribute name="sidebar"/>
            </div>
            <!-- CONTENT -->
            <div id="main-wrapper" class="col-md-10 col-sm-10 col-xs-10">
                <div id="main">
                    <tiles:insertAttribute name="content"/>
                </div>
            </div>
        </div>

        <!-- FOOTER -->
        <footer class="col-md-12 col-sm-12 col-xs-12 footer">
            <tiles:insertAttribute name="footer"/>
        </footer>

    </div>
</div>
</body>
</html>