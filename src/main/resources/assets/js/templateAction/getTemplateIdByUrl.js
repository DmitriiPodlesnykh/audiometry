function getTemplateIdByUrl() {
    var templateId;
    window.location.pathname.split('/').forEach(function (item, i, arr) {
        if (i == 2) {
            templateId =item.toString();
        }
    });
    return templateId;
}