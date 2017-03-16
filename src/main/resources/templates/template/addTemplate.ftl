<#include "header.ftl">
<script type="text/javascript" src="/assets/js/utils/createUiGUID.js"></script>
<script type="text/javascript" src="/assets/js/templateAction/add/addTemplate.js"></script>
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
            <button type="button" id="listenPoint">Прослушать</button>
            <button type="button" id="addTemplatePointLocal">Добавить точку измерения</button>
        </div>
        <div>
            <button type="button" id="addTemplate">Добавить шаблон</button>
        </div>
    </div>
</div>
<div id="main2"></div>
<div id="main3"></div>
<#include "footer.ftl">