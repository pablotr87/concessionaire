<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<spring:message var="msFirstName" code="user.firstName"/>
<spring:message var="msLastName" code="user.lastName"/>

<form:form id="userDetailForm" class="form-horizontal" modelAttribute="user" method="POST">

    <div class="form-group">
        <form:label path="firstName">${msFirstName}</form:label>
        <form:input path="firstName" type="text"/>
        <form:errors path="firstName" class="control-label"/>
    </div>

    <div class="form-group">
        <form:label path="lastName">${msLastName}</form:label>
        <form:input path="lastName" type="text"/>
        <form:errors path="lastName" class="control-label"/>
    </div>

    <div class="form-group">
        <button type="submit" class="btn btn-primary">Confirm</button>
    </div>
</form:form>