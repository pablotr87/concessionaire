<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<spring:message var="msgCarDetail" code="car.detail.title"/>
<spring:message var="msgCarNew" code="car.new.title"/>

<c:set var="carExists" value="${not empty car.id}"/>

<spring:message var="msgMake" code="car.make.name"/>
<spring:message var="msgModel" code="car.model.name"/>
<spring:message var="msgYear" code="car.year"/>
<spring:message var="msgBack" code="button.back"/>
<spring:message var="msgSave" code="button.save"/>

<spring:url var="urlCarsList" value="/cars/list"/>
<spring:url var="urlSaveCar" value="/cars/saveCar"/>

<div class="x_panel">
    <div class="x_title">
        <h2>
            <c:choose>
                <c:when test="${carExists}">${msgCarDetail}</c:when>
                <c:otherwise>${msgCarNew}</c:otherwise>
            </c:choose>
        </h2>
        <div class="clearfix"></div>
        <c:if test="${not empty msg}">
            <p class="alert alert-success">
                <i class="fa fa-check" aria-hidden="true"></i> <spring:message code="${msg}"/>
            </p>
        </c:if>
        <c:if test="${not empty errorMsg}">
            <p class="alert alert-danger">
                <i class="fa fa-times" aria-hidden="true"></i> <spring:message code="${errorMsg}"/>
            </p>
        </c:if>
    </div>

    <div class="x_content">
        <form:form id="carDetailForm" class="form-horizontal" modelAttribute="car" method="POST" action="${urlSaveCar}">
            <form:hidden path="id"/>

            <div class="row">
                <spring:bind path="make">
                    <div class="form-group ${status.error ? 'has-error' : ''}">
                        <div class="col-lg-4 col-md-4 col-sm-4 col-xs-4">
                            <form:label path="make" class="control-label required">${msgMake}</form:label>
                            <form:input path="make" class="form-control"/>
                            <form:errors path="make" class="text-danger"/>
                        </div>
                    </div>
                </spring:bind>
            </div>

            <div class="row">
                <spring:bind path="model">
                    <div class="form-group ${status.error ? 'has-error' : ''}">
                        <div class="col-lg-4 col-md-4 col-sm-4 col-xs-4">
                            <form:label path="model" class="control-label required">${msgModel}</form:label>
                            <form:input path="model" class="form-control"/>
                            <form:errors path="model" class="text-danger"/>
                        </div>
                    </div>
                </spring:bind>
            </div>

            <div class="row">
                <spring:bind path="year">
                    <div class="form-group ${status.error ? 'has-error' : ''}">
                        <div class="col-lg-4 col-md-4 col-sm-4 col-xs-4">
                            <form:label path="year" class="control-label required">${msgYear}</form:label>
                            <input type="number" id="year" name="year" value="${car.year}" class="form-control"
                                   title="${msgYear}"/>
                            <form:errors path="year" class="text-danger"/>
                        </div>
                    </div>
                </spring:bind>
            </div>

            <div class="ln_solid"></div>

            <a type="button" class="btn btn-default" href="${urlCarsList}">
                <i class="fa fa-reply" aria-hidden="true"></i> ${msgBack}
            </a>
            <div class="pull-right">
                <button class="btn btn-success">
                    <i class="fa fa-floppy-o" aria-hidden="true"></i> ${msgSave}
                </button>
            </div>
        </form:form>
    </div>
</div>