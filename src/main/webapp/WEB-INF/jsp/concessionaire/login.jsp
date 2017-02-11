<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<html>
<head>
    <title>Concessionaire</title>

    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <!-- Meta, title, CSS, favicons, etc. -->
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <!-- CSRF Token -->
    <sec:csrfMetaTags/>

    <!---- CSS ---->

    <!-- Bootstrap -->
    <link href="<spring:url value="/resources/css/bootstrap/bootstrap.min.css" />" rel="stylesheet">
    <!-- Font Awesome -->
    <link href="<spring:url value="/resources/css/font-awesome/font-awesome.min.css" />"
          rel="stylesheet">
    <!-- Custom Theme Style -->
    <link href="<spring:url value="/resources/css/concessionaire/concessionaire.css" />"
          rel="stylesheet">

    <!---- END CSS ---->

    <!---- JavaScript ---->

    <!-- jQuery -->
    <script src="<spring:url value="/resources/js/jquery/jquery.min.js" />"></script>

    <!-- Bootstrap -->
    <script src="<spring:url value="/resources/js/bootstrap/bootstrap.min.js" />"></script>

    <!-- Custom JS -->
    <script src="<spring:url value="/resources/js/concessionaire/login.js" />"></script>

    <!---- END JavaScript ---->
</head>
<body>
<div class="login_wrapper">
    <div class="login_form">
        <div class="row">
            <div class="col-md-12 col-sm-12 col-xs-12">
                <div class="x_panel">
                    <div class="x_title text-center">
                        <h1>Concessionaire</h1>
                        <div class="clearfix"></div>
                    </div>
                    <div class="x_content">
                        <spring:message var="msgUsername" code="user.username"/>
                        <spring:message var="msgPassword" code="user.password"/>
                        <spring:message var="msgSignIn" code="auth.signIn"/>
                        <spring:message var="msgSignInTitle" code="auth.signIn.title"/>
                        <spring:message var="msgSignUp1" code="auth.signIn.doNotHaveAccount.msg1"/>
                        <spring:message var="msgSignUp2" code="auth.signIn.doNotHaveAccount.msg2"/>
                        <spring:message var="msgRememberMe" code="auth.signIn.rememberMe"/>

                        <div class="text-center">
                            <h2>${msgSignInTitle}</h2>
                        </div>

                        <c:if test="${not empty msg}">
                            <spring:message var="msgOk" code="${msg}"/>
                            <p class="alert alert-success">
                                <i class="fa fa-check" aria-hidden="true"></i> ${msgOk}
                            </p>
                        </c:if>
                        <c:if test="${not empty errorMsg}">
                            <spring:message var="msgKo" code="${errorMsg}"/>
                            <p class="alert alert-danger">
                                <i class="fa fa-times" aria-hidden="true"></i> ${msgKo}
                            </p>
                        </c:if>

                        <form:form id="loginForm" class="form-horizontal" modelAttribute="user"
                                   method="POST">

                            <div class="intro">
                                <div class="input-group ${not empty errorMsg ? 'has-error': ''}">
                                    <span class="input-group-addon">
                                        <i class="fa fa-user fa-fw" aria-hidden="true"></i>
                                    </span>
                                    <form:input path="username" class="form-control"
                                                placeholder="${msgUsername}"/>
                                </div>
                            </div>
                            <div class="intro">
                                <div class="input-group ${not empty errorMsg ? 'has-error': ''}">
                                    <span class="input-group-addon">
                                        <i class="fa fa-lock fa-fw" aria-hidden="true"></i>
                                    </span>
                                    <form:password path="password" class="form-control"
                                                   placeholder="${msgPassword}"/>
                                </div>
                            </div>
                            <div>
                                <input type="checkbox" name="remember-me"/>
                                <span>${msgRememberMe}</span>
                            </div>
                            <div class="form-group text-center">
                                <button type="submit"
                                        class="btn btn-primary btn-block">${msgSignIn}</button>
                            </div>
                        </form:form>

                        <hr>
                        <spring:url var="signUpUrl" value="signup"/>
                        <div>
                            <span>${msgSignUp1}</span>
                            <a href="${signUpUrl}">
                                ${msgSignUp2}
                            </a>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>