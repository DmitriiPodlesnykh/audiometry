<#include "header.ftl">
<script type="text/javascript" src="/assets/js/action/deviceAction.js" xmlns="http://www.w3.org/1999/html"></script>
<script type="text/javascript" src="/assets/js/request/addObject.js"></script>
<script type="text/javascript" src="/assets/js/utils/getValueFromUrl.js"></script>
<div class="row">
    <div id="createFormDiv" class="col-xs-9 bg-success">
        <div>
            <label>Уровень интенсивности:</label>
            <input type="text" name="intensityLevel" id="intensityLevel">
            <label>ДБ</label>
        </div>
        <!--<div>
            <label>Частота:</label>
            <input type="text" name="frequency" id="frequency">
        </div>-->
        <div>
            <label for="frequency">Частота:</label>
            <select id="frequency" name="frequency">
                <#list frequencyListValues as frequencyValue>
                    <option value="${frequencyValue}">${frequencyValue}</option>
                </#list>
            </select>
        </div>
        <div>
            <label>Громкость:</label>
            <input type="text" name="volumeValue" id="volumeValue">
            <button type="button" class="btn-play-sound">Прослушать</button>
        </div>
        <div>
            <button type="button" id="addDevicePoint">Добавить точку</button>
        </div>
    </div>
</div>