$(function () {
    var table = $("#carsListTb");
    registerTableEvents(table);
});

/**
 * Register table events.
 * @param table Table element.
 */
function registerTableEvents(table) {
    table.on("dbl-click-row.bs.table", function (e, row) {
        window.location.href = "cars/detail/" + row.id;
    });
}