$(document).ready(function () {
    $(".create-test").click(function (event) {

        var templateId = document.getElementById("template-selector-id").value;
        var patientId = document.getElementById("patient-selector-id").value;

        var test = getCreateTestDto(null, templateId, patientId, null, null);

        var url = "/rest/tests";
        var jsonObject = JSON.stringify(test);
        var response = addObject(url, jsonObject, "PUT");

        if (response) {
            window.location.replace("http://localhost:8080/tests/" + response.testId + "/run");
        }
    })
});