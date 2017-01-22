<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<spring:message var="msgCarsList" code="cars.list.title"/>
<spring:message var="msgMakeName" code="car.make.name"/>

<spring:url var="urlCarsList" value="/cars"/>

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
                       data-toggle="table"
                       data-search="true"
                       data-pagination="true"
                       data-id-field="id"
                       data-unique-id="id"
                       data-url="${urlCarsList}"
                       data-locale="${localeCode}">
                    <thead>
                    <tr>
                        <th data-field="id" data-visible="false" data-switchable="false"></th>
                        <th data-field="makes[0].name" data-sortable="true">${msgMakeName}</th>
                    </tr>
                    </thead>
                </table>
            </div>
        </div>
    </div>
</div>