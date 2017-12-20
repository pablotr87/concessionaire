$(function () {
    var $table = $("#carsListTb");
    registerTableEvents($table);
    $(".btn-spreadsheet").prop("disabled", true);
});

/**
 * Register table events.
 * @param $table Table element.
 */
function registerTableEvents($table) {
    $table.on("dbl-click-row.bs.table", function (e, row) {
        window.location.href = "detail/" + row.id;
    });

    $table.on('load-success.bs.table', function () {
        $(".btn-spreadsheet").prop("disabled", false);
    });
}