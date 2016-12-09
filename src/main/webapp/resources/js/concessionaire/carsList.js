(function() {
	var table = $("#carsList");
	registerTableEvents(table);
});

/**
 * @param table
 * @returns
 */
function registerTableEvents(table) {
	table.on("dbl-click-row.bs.table", function(e, row) {
		window.location.href = "cars/detail/" + row.id;
	});
}