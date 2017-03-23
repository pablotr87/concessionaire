<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<spring:message var="msgCarsList" code="cars.list.title"/>
<spring:message var="msgMakeName" code="car.make.name"/>
<spring:message var="msgModelName" code="car.model.name"/>
<spring:message var="msgYear" code="car.year"/>

<spring:message var="msgWait" code="general.wait"/>
<spring:message var="msgExportToSpreadSheet" code="general.exportToSpreadsheet"/>
<spring:message var="exportButton" code="button.export"/>

<spring:url var="urlCarsList" value="/cars/jsonList"/>

<div class="row">
    <div class="col-md-12 col-sm-12 col-xs-12">
        <div class="x_panel">
            <div class="x_title">
                <h2>${msgCarsList}</h2>
                <div class="clearfix"></div>
            </div>
            <div class="x_content">
                <table id="carsListTb"
                       class="table table-striped jambo_table"
                       data-toggle="table"
                       data-search="true"
                       data-trim-on-search="false"
                       data-pagination="true"
                       data-id-field="id"
                       data-unique-id="id"
                       data-url="${urlCarsList}"
                       data-locale="${localeCode}">
                    <thead>
                    <tr>
                        <th data-field="id" data-visible="false" data-switchable="false"></th>
                        <th data-field="make" data-sortable="true"
                            class="col-md-5 col-sm-5 col-xs-5">${msgMakeName}</th>
                        <th data-field="model" data-sortable="true"
                            class="col-md-5 col-sm-5 col-xs-5">${msgModelName}</th>
                        <th data-field="year" data-sortable="true" class="col-md-2 col-sm-2 col-xs-2">${msgYear}</th>
                    </tr>
                    </thead>
                </table>
                <div class="text-center">
                    <button type="button" class="btn btn-success btn-spreadsheet" title="${msgExportToSpreadSheet}"
                            onclick="exportToSpreadsheet('carsListTb', 'cars/exportToSpreadsheet')"
                            data-loading-text="<i class='fa fa-circle-o-notch fa-spin'></i> ${msgWait}">
                        <span>${exportButton}</span> <i class="fa fa-file-excel-o text-success" aria-hidden="true"></i>
                    </button>
                </div>
            </div>
        </div>
    </div>
</div>