<#include "header.ftl">
<div id="deviceInfo">
    <h1>Устройство id ${device.getId()}</h1>
    <h2>${device.getHeadphoneName()}</h2>
    <h2>${device.getSoundCardName()}</h2>

    <div>
        <table>
            <tr>
                <th>ID</th>
                <th>Частота</th>
                <th>Уровень интенсивности</th>
                <th>Амплитуда</th>
            </tr>
        <#list device.getPointList() as devicePoint>
            <tr class="device-point-table-record" id="device-point-table-record-${devicePoint.getId()}">
                <td>
                    <a href="/config/devices/${devicePoint.getDeviceId()}/${devicePoint.getId()}">${devicePoint.getId()}</a>
                </td>
                <td class="frequency-view">${devicePoint.getFrequency()?c}</td>
                <td class="intensity-level-view">${devicePoint.getIntensityLevel()}</td>
                <td class="sound-volume-view"> ${devicePoint.getSoundValue()}</td>
                <td>
                    <button type="button" class="btn btn-play-sound btn-outline-info"
                            data-id="${devicePoint.getId()}">Прослушать
                    </button>
                </td>
                <td>
                    <button type="button" class="btn btn-outline-warning">Изменить</button>
                </td>
            </tr>
        </#list>
        </table>
    </div>
    <div>
        <!--<button class="btn btn-info btn-generate-device-points" name="generate-device-points">Сгенерировать точки</button>
        <button class="btn btn-info btn-add-device-point" name="add-device-point">Добавить точку</button>-->
        <a href="/config/devices">
            <button id="goToAddDeviceForm">Назад</button>
        </a>
    </div>
</div>
<#include "footer.ftl">