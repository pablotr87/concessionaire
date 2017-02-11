<!DOCTYPE html>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<html class="error-page">
<head>
    <title><spring:message code="error.pageNotFound"/></title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <!-- Meta, title, CSS, favicons, etc. -->
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <!---- CSS ---->

    <!-- Bootstrap -->
    <link href="<spring:url value="/resources/css/bootstrap/bootstrap.min.css" />" rel="stylesheet">
    <!-- Font Awesome -->
    <link href="<spring:url value="/resources/css/font-awesome/font-awesome.min.css" />" rel="stylesheet">
    <!-- Custom Theme Style -->
    <link href="<spring:url value="/resources/css/concessionaire/concessionaire.css" />" rel="stylesheet">

    <!---- END CSS ---->
</head>
<body>

<!-- content -->
<div class="container-fluid">
    <div class="row-fluid">
        <div class="col-lg-12">
            <div class="centering text-center error-container">
                <div class="text-center">
                    <h2 class="without-margin">
                        <spring:message code="error.pageNotFound.msg1"/> <span class="text-warning big">404</span>
                        <spring:message code="error.pageNotFound.msg2"/></h2>
                    <h4 class="text-warning"><spring:message code="error.pageNotFound"/></h4>
                </div>
                <div class="text-center">
                    <h3>
                        <small><spring:message code="error.chooseOption"/></small>
                    </h3>
                </div>
                <hr>
                <ul class="pager">
                    <li>
                        <a href="#" onclick="window.history.back();return false;">
                            <i class="fa fa-arrow-circle-left" aria-hidden="true"></i>
                            <spring:message code="general.back"/>
                        </a>
                    </li>
                    <li>
                        <a href="${pageContext.request.contextPath}/">
                            <i class="fa fa-home" aria-hidden="true"></i>
                            <spring:message code="general.home"/>
                        </a>
                    </li>
                </ul>
            </div>
        </div>
    </div>
</div>
</body>
</html>