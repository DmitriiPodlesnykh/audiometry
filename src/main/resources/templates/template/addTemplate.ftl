<#include "header.ftl">

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

            event.preventDefault();
        });
    });
    
    function addUIPoint() {
        var containerId = guid();
        var pointFrequncy = document.getElementById('new-point-frequency').value;
        var pointIntensity = document.getElementById('new-point-intensity').value;
        $("#div-for-template-form-points").append("<div class='container' id='" + containerId + "'></div>");
        var containerIdForAppend = "#" + containerId + "";
        $(containerIdForAppend).append("<div><p>Частота: " + pointFrequncy + "</p></div>");
        $(containerIdForAppend).append("<div><p>Интенсивность: " + pointIntensity + "</p></div>");

    }

    function cleanPointModal() {
        document.getElementById('new-point-frequency').value = "";
        document.getElementById('new-point-intensity').value = "";
    }
    
    function guid() {
        function s4() {
            return Math.floor((1 + Math.random()) * 0x10000)
                    .toString(16)
                    .substring(1);
        }

        return s4() + s4() + '-' + s4() + '-' + s4() + '-' +
                s4() + '-' + s4() + s4() + s4();
    }
</script>

<form name="template" role="form" action="/templates/add" method="post">
    <div>
        <label>Название:</label>
        <input type="text" name="name">
    </div>
    <input type="hidden" name="authorId" value="1">
    <input type="hidden" name="elements" value="1,2,9,15">
    <p>description</p>
    <div id="div-for-template-form-points"></div>

    <button type="submit" id="submit">Добавить шаблон</button>
</form>
<button type="submit" class="btn btn-info btn-lg" data-toggle="modal" data-target="#myModal">Добавить точку измерения
</button>


<#include "addTemplatePointModal.ftl">
<#include "footer.ftl">