<#include "header.ftl">
<script type="text/javascript" src="/assets/js/utils/createUiGUID.js"></script>
<script type="text/javascript" src="/assets/js/templateAction/add/addTemplateAJAX.js"></script>
<script>
    var points = [];

    $(document).ready(function () {

        $("#add-point-for-template").submit(function (event) {

            $('#myModal').modal('hide');
            addUIPoint();

            templatePointDto = new Object();
            templatePointDto.frequency = document.getElementById('new-point-frequency').value;
            templatePointDto.intensityValue = document.getElementById('new-point-intensity').value;
            points.push(templatePointDto);


            var jsonPointsString = JSON.stringify(points);
            $('#formTemplatePoints').val(jsonPointsString);


            event.preventDefault();
        });

        $("#addTemplate").click(function (event) {

            pointDto = new Object();
            pointDto.frequency = "9";
            pointDto.intensityValue = "15";

            templateDto = new Object();
            templateDto.authorId = "1";
            templateDto.name = document.getElementById('templateName').value;
            templateDto.description = document.getElementById('templateDescription').value;
            templateDto.points = [pointDto];
            //addTemplateAJAX();
            var testString = '{"points": [{"frequency":"11","intensityValue":"111"}],"authorId": 1,"name": "testajax","description": "description for ajax"}';
            $.ajax({
                url: "/rest/templates/",
                type: "POST",
                contentType: "application/json; charset=utf-8",
                data: JSON.stringify(templateDto), //Stringified Json Object
                async: false,    //Cross-domain requests and dataType: "jsonp" requests do not support synchronous operation
                cache: false,    //This will force requested pages not to be cached by the browser
                processData: false, //To avoid making query String instead of JSON
                success: function (resposeJsonObject) {
                    // Success Message Handler
                }
            });


        });
    });

    function addUIPoint() {
        var containerId = createUiGUID();
        var pointFrequncy = document.getElementById('new-point-frequency').value;
        var pointIntensity = document.getElementById('new-point-intensity').value;
        $("#div-for-template-form-points").append("<div class='container' id='" + containerId + "'></div>");
        var containerIdForAppend = "#" + containerId + "";
        $(containerIdForAppend).append("<div><p>Частота: " + pointFrequncy + "</p></div>");
        $(containerIdForAppend).append("<div><p>Интенсивность: " + pointIntensity + "</p></div>");

    }
</script>
<div>
    <div>
        <label>Название:</label>
        <input type="text" name="name" id="templateName">
    </div>
    <div>
        <label>Описание:</label>
        <input type="text" name="description" id="templateDescription">
    </div>
    <div>
        <button type="submit" class="btn btn-info btn-lg" data-toggle="modal" data-target="#myModal">
            Добавить точку измерения
        </button>
    </div>
    <div>
        <button type="button" id="addTemplate">Добавить шаблон</button>
    </div>
</div>
<#include "addTemplatePointModal.ftl">
<#include "footer.ftl">