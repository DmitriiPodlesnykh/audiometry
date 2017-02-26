<#include "header.ftl">

<script>
    $(document).ready(function () {
        $("#add-template-point").click(function (event) {

            var urlTemplate;
            window.location.pathname.split('/').forEach(function (item, i, arr) {
                if (i == 2) {
                    urlTemplate =item.toString();
                }
            });

            pointDto = new Object();
            pointDto.frequency = document.getElementById('frequency').value;
            pointDto.intensityValue = document.getElementById('intensityValue').value;
            pointDto.templateId = urlTemplate;

            var dataString = JSON.stringify(pointDto);
            var url = "/templates/" + urlTemplate +"/add";
            $.ajax({
                url: url,
                type: "POST",
                contentType: "application/json; charset=utf-8",
                data: dataString,//'{"frequency": "4", "intensityValue": "1", "authorId": "37"}'
                async: false,    //Cross-domain requests and dataType: "jsonp" requests do not support synchronous operation
                cache: false,    //This will force requested pages not to be cached by the browser
                processData: false, //To avoid making query String instead of JSON
                success: function (resposeJsonObject) {
                    // Success Message Handler
                }
            });

        });
    });
</script>
<div>
    <div>
        <label>Частота:</label>
        <input type="text" name="frequency" id="frequency">
    </div>
    <div>
        <label>Интенсивность:</label>
        <input type="text" name="intensityValue" id="intensityValue">
    </div>
    <div>
        <button type="button" id="add-template-point">Добавить точку</button>
    </div>
</div>


<#include "footer.ftl">