<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="rec" tagdir="/WEB-INF/tags" %>

<spring:message var="msgLogOut" code="auth.logOut"/>
<spring:message var="msgAdministration" code="administration.title"/>
<spring:message var="msgExit" code="general.exit"/>
<spring:url var="urlLogOut" value="/logout"/>
<spring:url var="urlAdmin" value="/administration"/>
<spring:url var="urlExitAdmin" value="/"/>

<sec:authorize var="isAdmin" access="hasAuthority('ROLE_ADMIN')" />
<sec:authorize var="isUser" access="hasAuthority('ROLE_USER')" />

<div class="navbar-header">
    <a class="navbar-brand" href="#">
        <i class="fa fa-car fa-2x" aria-hidden="true"></i>
    </a>
</div>
<nav class="collapse navbar-collapse">
    <ul class="nav navbar-nav pull-right">
        <c:if test="${isAdmin and menu.typeId eq 1}">
            <li>
                <a href="${urlAdmin}"><i class="fa fa-cog" aria-hidden="true"></i> ${msgAdministration}</a>
            </li>
        </c:if>
        <c:if test="${menu.typeId eq 2}">
            <li>
                <a href="${urlExitAdmin}"><i class="fa fa-sign-out" aria-hidden="true"></i> ${msgExit}</a>
            </li>
        </c:if>

        <li class="dropdown">
            <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                <i class="fa fa-user-circle-o fa-lg" aria-hidden="true"></i>
                ${user.username}
            </a>
            <ul class="dropdown-menu pull-right">
                <li>
                    <form:form action="${urlLogOut}" method="POST">
                        <button type="submit" class="btn btn-danger col-md-12 col-sm-12 col-xs-12">
                            <i class="fa fa-sign-out" aria-hidden="true"></i>
                            <span>${msgLogOut}</span>
                        </button>
                    </form:form>
                </li>
            </ul>
        </li>
    </ul>
</nav>

<script type="text/javascript">
    var msgExport = '<spring:message code="button.export"/>';
</script>