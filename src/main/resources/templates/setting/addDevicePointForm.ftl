<#include "header.ftl">
<div id="addDevicePointForm" xmlns:s="http://www.w3.org/1999/html">
    <div id="addDevicePointFormHeader">
        <h2>Добавить точку устройства</h2>
    </div>
    <div id="addDevicePointFormBody">
        <div>
            <label for="frequency">Частота: </label>
            <input type="text" id="frequency">
        </div>
        <div>
            <label for="intensityLevel">Уровень интенсивности: </label>
            <input type="text" id="intensityLevel">
        </div>
        <div>
            <label for="volumeValue">Громкость: </label>
            <input type="text" id="volumeValue">
            <input type="button" class="btn-play-sound" name="Прослушать">
        </div>
        <input type="button" id="addDevicePoint" name="Добавить точку">
        <input type="button" id="cancelAddDevicePoint" name="Отмена">
    </div>
</div>