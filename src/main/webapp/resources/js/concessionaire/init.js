$(function () {
    setupCsrfToken();
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