<#include "header.ftl">
<script type="text/javascript" src="/assets/js/templateAction/add/addTemplatePointAJAX.js"></script>
<script type="text/javascript" src="/assets/js/templateAction/getTemplateIdByUrl.js"></script>
<script>
    $(document).ready(function () {

        $("#add-template-point").click(function (event) {
            var templateUrl = getTemplateIdByUrl();
            pointDto = new Object();
            pointDto.frequency = document.getElementById('frequency').value;
            pointDto.intensityValue = document.getElementById('intensityValue').value;
            pointDto.templateId = templateUrl;
            addTemplatePointAJAX(pointDto);
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