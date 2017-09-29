<%@ attribute name="list" type="java.util.List" required="true" %>
<%@ taglib prefix="rec" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<c:if test="${not empty list}">
    <c:forEach var="menu" items="${list}">
        <!-- === Menu variables === -->
        <c:set var="menuIcon" value="${menu.icon}"/>
        <spring:url var="menuUrl" value="${menu.url}"/>
        <spring:message var="menuText" code="${menu.text}"/>

        <c:choose>
            <c:when test="${not empty menu.children}">
                <li class="dropdown menu-parent">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                        <i class="${menuIcon}" aria-hidden="true"></i>
                        <span class="link-name">${menuText}</span>
                        <span class="fa fa-chevron-down"></span>
                    </a>
                    <ul class="dropdown-menu" style="display: none">
                        <rec:menuGroups list="${menu.children}"/>
                    </ul>
                </li>
            </c:when>
            <c:otherwise>
                <li>
                    <a href="${menuUrl}">
                        <i class="${menuIcon}" aria-hidden="true"></i>
                        <span class="link-name">${menuText}</span>
                    </a>
                </li>
            </c:otherwise>
        </c:choose>
    </c:forEach>
</c:if>