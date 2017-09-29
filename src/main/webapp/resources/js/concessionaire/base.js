$(function () {
    setupCsrfToken();
    sidebarMenuActions();
});

function setupCsrfToken() {
    var token = $("meta[name='_csrf']").attr("content");
    var header = $("meta[name='_csrf_header']").attr("content");

    $(document).ajaxSend(function (e, xhr) {
        if (header && token) {
            xhr.setRequestHeader(header, token);
        }
    });
}

function sidebarMenuActions() {
    var $sidebar = $('#sidebar');

    $sidebar.find('li ul').first().slideDown();
    $sidebar.find('li').addClass('active');

    $sidebar.find('li').click(function () {
        if ($(this).is('.active')) {
            $(this).removeClass('active');
            $('ul', this).delay(20).slideToggle(600);
            $(this).removeClass('nv');
            $(this).addClass('vn');
        } else {
            if($(this).children.length > 0) {
                $("ul", this).find('ul').hide();
            }

            $(this).find('ul').delay(20).slideToggle(600);
            $(this).addClass('active');
        }
    });
}

/**
 * Export to spreadsheet from server.
 *
 * @param tableId
 * @param url
 */
function exportToSpreadsheet(tableId, url) {

    var header = [];
    var colIds = [];
    var table = $("#" + tableId);
    var options = table.bootstrapTable('getOptions');
    // Header
    table.find('thead').find('tr').each(function () {
        $(this).filter(':visible').find('th').each(function (index) {
            if ($(this).css('display') !== 'none' && $.trim($(this).text()) !== '') {
                // Decode accents
                header[index] = decodeURIComponent($.trim($(this).text()));
                // Field identifiers in bean
                colIds[index] = $(this).attr('data-field');
            }
        });
    });
    // Trim the arrays
    header = header.filter(function (v) {
        return v !== ''
    });
    colIds = colIds.filter(function (v) {
        return v !== ''
    });

    // Sorting and pagination params.

    var sort = options.sortName;
    var order = options.sortOrder;
    var search = options.searchText;

    exportToSpreadsheetWithAjax(url
        + '?header=' + header
        + '&ids=' + colIds
        + '&sort=' + sort
        + '&order=' + order
        + '&search=' + search);

}

/**
 * Export to spreadsheet using AJAX.
 * @param url
 */
function exportToSpreadsheetWithAjax(url) {

    $(".btn-spreadsheet").button('loading');
    var xhr = new XMLHttpRequest();
    xhr.open('GET', url, true);
    xhr.responseType = 'blob';
    xhr.setRequestHeader('Content-type', 'application/json; charset=utf-8');
    xhr.send(null);

    xhr.onload = function () {
        $(".btn-spreadsheet").button('reset');
        if (this.status === 200) {
            var filename = "";
            var disposition = xhr.getResponseHeader('Content-Disposition');
            if (disposition && disposition.indexOf('attachment') !== -1) {
                var filenameRegex = /filename[^;=\n]*=((['"]).*?\2|[^;\n]*)/;
                var matches = filenameRegex.exec(disposition);
                if (matches !== null && matches[1]) {
                    filename = matches[1].replace(/['"]/g, '');
                }
            }
            var type = xhr.getResponseHeader('Content-Type');
            var blob = new Blob([this.response], {type: type});
            // For Windows
            if (window.navigator.msSaveOrOpenBlob) {
                window.navigator.msSaveOrOpenBlob(blob, filename);
            } else {
                var downloadUrl = URL.createObjectURL(blob);
                var a = document.createElement("a");
                a.href = downloadUrl;
                a.download = filename;
                document.body.appendChild(a);
                a.click();
            }
        }
    };
}