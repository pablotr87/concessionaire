<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<spring:message var="msgLogOut" code="auth.logOut"/>
<spring:url var="urlLogOut" value="/logout"/>

<nav class="navbar navbar-default navbar-fixed-top" role="navigation">
    <div class="navbar-header">
        <a class="navbar-brand" href="#">
            <i class="fa fa-car fa-2x" aria-hidden="true"></i>
        </a>
    </div>

    <!-- Group navigation links, forms and any other item that can be hidden by minimizing the bar -->
    <div class="collapse navbar-collapse">
        <ul class="nav navbar-nav">
            <li>
                <button type="button" class="navbar-toggle" data-toggle="collapse">
                    <span class="sr-only">Expand navigation</span>
                    <i class="fa fa-bars" aria-hidden="true"></i>
                </button>
            </li>
        </ul>

        <ul class="nav navbar-nav navbar-right">
            <li class="user-panel">
                <i class="fa fa-user-circle-o fa-2x" aria-hidden="true"></i>
                ${user.username}
            </li>
            <li>
                <form:form action="${urlLogOut}" method="POST">
                    <button type="submit" class="btn btn-danger col-md-12 col-sm-12 col-xs-12">
                        <i class="fa fa-power-off" aria-hidden="true"></i>
                        <span>${msgLogOut}</span>
                    </button>
                </form:form>
            </li>
        </ul>
    </div>
</nav>

<script type="text/javascript">
    var msgExport = '<spring:message code="button.export"/>';
</script>