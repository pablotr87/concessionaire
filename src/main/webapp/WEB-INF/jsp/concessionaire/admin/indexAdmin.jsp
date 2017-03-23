<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<spring:message var="msgAppTitle" code="app.title"/>
<spring:message var="msgAdmin" code="administration.title"/>

<div class="x_panel">
    <div class="x_title"></div>
    <div class="initAdmin">
        <h1>${msgAppTitle}</h1>
        <h2>${msgAdmin}</h2>
    </div>
</div>