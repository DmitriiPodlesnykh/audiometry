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
            //alert(jsonPointsString);
            $('#formTemplatePoints').val(jsonPointsString);
            //document.getElementById('#formTemplatePoints') = jsonPointsString.value;


            event.preventDefault();
        });


        $("#testajax").click(function (event) {

            var testString = '{"points": [{"frequency":"11","intensityValue":"111"}],"authorId": 1,"name": "testajax","description": "description for ajax"}';

            /*
            tempateDto.name = document.getElementById('name').value;
            tempateDto.description = document.getElementById('description').value;
            tempateDto.authorId = 1;
            tempateDto.points = points;

             */
            $.ajax({
                url: "/templates/add",
                type: "POST",
                contentType: "application/json; charset=utf-8",
                data: testString, //Stringified Json Object
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

<form name="template" role="form" action="/templates/add" method="post">
    <div>
        <label>Название:</label>
        <input type="text" name="name">
    </div>
    <div>
        <input type="hidden" name="authorId" value="1">
        <input type="hidden" name="points" id="formTemplatePoints" value="">
    </div>
    <div>
        <p>description</p>
    </div>
    <div id="div-for-template-form-points"></div>

    <button type="submit" id="submit">Добавить шаблон</button>
</form>
<button type="submit" class="btn btn-info btn-lg" data-toggle="modal" data-target="#myModal">Добавить точку измерения
</button>

<button type="button" id="testajax">test
</button>


<#include "addTemplatePointModal.ftl">
<#include "footer.ftl">