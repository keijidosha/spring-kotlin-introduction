$(function() {
    $("#user-table").dataTable({
        language: {
            url: "/webjars/datatables-plugins/i18n/ja.json"
        },
        dom: "Bfrtip",
        buttons: ["excelHtml5", "csvHtml5", "print"]
    });
});