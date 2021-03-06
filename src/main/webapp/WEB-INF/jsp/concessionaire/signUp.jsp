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
    <link href="<spring:url value="/webjars/bootstrap/3.3.7/css/bootstrap.min.css" />" rel="stylesheet">
    <!-- Font Awesome -->
    <link href="<spring:url value="/webjars/font-awesome/4.7.0/css/font-awesome.min.css" />" rel="stylesheet">
    <!-- Custom Theme Style -->
    <link href="<spring:url value="/resources/css/concessionaire/base.css" />" rel="stylesheet">

    <!---- END CSS ---->

    <!---- JavaScript ---->

    <!-- jQuery -->
    <script src="<spring:url value="/webjars/jquery/3.2.1/jquery.min.js" />"></script>

    <!-- Bootstrap -->
    <script src="<spring:url value="/webjars/bootstrap/3.3.7/js/bootstrap.min.js" />"></script>

    <!---- END JavaScript ---->
</head>
<body>
<div class="sign_up_wrapper">
    <div class="sign_up_form">
        <div class="row">
            <div class="col-md-12 col-sm-12 col-xs-12">
                <div class="x_panel">
                    <div class="x_title text-center">
                        <h1>Concessionaire</h1>
                        <div class="clearfix"></div>
                    </div>
                    <div class="x_content">
                        <spring:message var="msgUsername" code="user.username"/>
                        <spring:message var="msgEmail" code="user.email"/>
                        <spring:message var="msgPassword" code="user.password"/>
                        <spring:message var="msgSignUp" code="auth.signUp"/>
                        <spring:message var="msgSignUpTitle" code="auth.signUp.title"/>
                        <spring:message var="msgSignIn1" code="auth.signUp.alreadyHaveAccount.msg1"/>
                        <spring:message var="msgSignIn2" code="auth.signUp.alreadyHaveAccount.msg2"/>

                        <c:if test="${not empty errorMsg}">
                            <spring:message var="msgKo" code="${errorMsg}"/>
                            <p class="alert alert-danger">
                                <i class="fa fa-times" aria-hidden="true"></i> ${msgKo}
                            </p>
                        </c:if>

                        <div class="text-center">
                            <h2>${msgSignUpTitle}</h2>
                        </div>

                        <form:form id="signUpForm" class="form-horizontal" modelAttribute="user"
                                   method="POST">

                            <c:set var="usernameError">
                                <form:errors path="username" class="text-danger"/>
                            </c:set>
                            <c:set var="emailError">
                                <form:errors path="email" class="text-danger"/>
                            </c:set>
                            <c:set var="passwordError">
                                <form:errors path="password" class="text-danger"/>
                            </c:set>

                            <div class="intro">
                                <div class="input-group ${not empty usernameError ? 'has-error': ''}">
                                    <span class="input-group-addon">
                                        <i class="fa fa-user fa-fw" aria-hidden="true"></i>
                                    </span>
                                    <form:input path="username" class="form-control"
                                                placeholder="${msgUsername}"/>
                                </div>
                                    ${usernameError}
                            </div>
                            <div class="intro">
                                <div class="input-group ${not empty emailError ? 'has-error': ''}">
                                            <span class="input-group-addon">
                                                <i class="fa fa-envelope fa-fw" aria-hidden="true"></i>
                                            </span>
                                    <form:input path="email" class="form-control" placeholder="${msgEmail}"/>
                                </div>
                                    ${emailError}
                            </div>
                            <div class="intro">
                                <div class="input-group ${not empty passwordError ? 'has-error': ''}">
                                    <span class="input-group-addon">
                                        <i class="fa fa-lock fa-fw" aria-hidden="true"></i>
                                    </span>
                                    <form:password path="password" class="form-control"
                                                   placeholder="${msgPassword}"/>
                                </div>
                                    ${passwordError}
                            </div>
                            <div class="form-group text-center">
                                <button type="submit"
                                        class="btn btn-primary btn-block">${msgSignUp}</button>
                            </div>
                        </form:form>

                        <hr>
                        <spring:url var="signInUrl" value="login"/>
                        <div>
                            <span>${msgSignIn1}</span>
                            <a href="${signInUrl}">
                                ${msgSignIn2}
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