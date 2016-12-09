<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<spring:message var="msgCarsList" code="cars.list.title"/>
<spring:message var="msgMakeName" code="car.make.name"/>

<div class="row">
    <div class="col-md-12 col-sm-12 col-xs-12">
        <div class="x_panel">
            <div class="x_title">
                <h2>${msgCarsList}</h2>
                <div class="clearfix"></div>
            </div>
            <div class="x_content">
                <table id="carsList"
                       class="table table-striped responsive-utilities jambo_table"
                       data-toggle="table"login
                       data-search="true"
                       data-show-columns="true"
                       data-pagination="true"
                       data-id-field="id"
                       data-unique-id="id">
                    <thead>
                    <tr>
                        <th data-field="id" data-visible="false" data-switchable="false"></th>
                        <th data-field="name" data-sortable="true">${msgMakeName}</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${cars[0].makes}" var="make">
                        <tr>
                            <td>${make.id}</td>
                            <td>${make.name}</td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>
    </div>
</div>