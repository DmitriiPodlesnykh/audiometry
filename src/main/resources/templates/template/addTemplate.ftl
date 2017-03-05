<#include "header.ftl">
<script type="text/javascript" src="/assets/js/utils/createUiGUID.js"></script>
<script>
    var points = [];
    $(document).ready(function () {

        $("#addTemplate").click(function (event) {
            var templateDto = new Object();
            templateDto.authorId = "1";
            templateDto.name = document.getElementById('templateName').value;
            templateDto.description = document.getElementById('templateDescription').value;
            templateDto.points = points;
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
                    var resultUrl = "/templates/" + resposeJsonObject.id;
                    $("#createFormDiv").hide();
                    $("#main2").load(resultUrl);
                    /*resposeJsonObject.points.forEach(function (point, i, resposeJsonObject.points)
                    {
                        var pointUrl = "/templates/" + resposeJsonObject.id + point.id;
                        $("#main2").load(pointUrl);
                    }
                    )
                    ;*/
                    //alert( i + ": " + item + " (массив:" + arr + ")" );
                    //   var pointUrl = "/templates/" + resposeJsonObject.id + point.id;
                    //   $("#main2").load(pointUrl);
                    //});
                }
            });


        });

        $("#addTemplatePointLocal").click(function (event) {

            var pointDto = new Object();
            pointDto.frequency = document.getElementById('frequencyLocal').value;
            pointDto.intensityValue = document.getElementById('intensityValueLocal').value;
            points.push(pointDto);

            $( "#pointsTemplateLocalDiv" ).append( "<div class='templatePointLocal'><div>"+ pointDto.frequency + "</div><div>"+ pointDto.intensityValue +"</div></div>" );
        });
    });
</script>
<div class="row">
    <div id="createFormDiv" class="col-xs-9 bg-success">
        <div>
            <label>Название:</label>
            <input type="text" name="name" id="templateName">
        </div>
        <div>
            <label>Описание:</label>
            <input type="text" name="description" id="templateDescription">
        </div>
        <div>
            <div id="pointsTemplateLocalDiv"></div>
            <div id="addTemplatePointsLocal">
                <div>
                    <label>Частота:</label>
                    <input type="text" name="frequency" id="frequencyLocal">
                </div>
                <div>
                    <label>Интенсивность:</label>
                    <input type="text" name="intensityValue" id="intensityValueLocal">
                </div>
            </div>
            <button type="button" id="addTemplatePointLocal">Добавить точку измерения</button>
        </div>
        <div>
            <button type="button" id="addTemplate">Добавить шаблон</button>
        </div>
    </div>
</div>
<div id="main2"></div>
<#include "footer.ftl">