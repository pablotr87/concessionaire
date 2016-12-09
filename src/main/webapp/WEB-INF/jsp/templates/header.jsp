<%@ taglib prefix="form"    uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" 	uri="http://www.springframework.org/tags"%>

<spring:message var="msgLogOut" code="auth.logOut" />
<spring:url var="urlLogOut" value="/logout" />

<div class="navbar-header">
    <button class="navbar-toggle collapsed" type="button"
            data-toggle="collapse" data-target=".navbar-collapse">
        <i class="icon-reorder"></i>
    </button>
    <a class="navbar-brand" href="#">
        <i class="fa fa-car fa-lg" aria-hidden="true"></i>
    </a>
</div>
<nav class="collapse navbar-collapse">
    <ul class="nav navbar-nav">
        <li>
            <a href="#">Navbar Item 1</a>
        </li>
        <li class="dropdown">
            <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                Navbar Item 2<b class="caret"></b>
            </a>
            <ul class="dropdown-menu">
                <li>
                    <a href="#">Navbar Item2 - Sub Item 1</a>
                </li>
            </ul>
        </li>
    </ul>
    <ul class="nav navbar-nav pull-right">
        <li class="dropdown">
            <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                <i class="fa fa-user-circle-o fa-lg" aria-hidden="true"></i>
                ${user.username}
            </a>
            <ul class="dropdown-menu pull-right">
                <li>
                    <form:form action="${urlLogOut}" method="POST">
                        <button type="submit" class="btn btn-danger col-md-12">
                            <i class="fa fa-sign-out" aria-hidden="true"></i>
                            <span>${msgLogOut}</span>
                        </button>
                    </form:form>
                </li>
            </ul>
        </li>
    </ul>
</nav>