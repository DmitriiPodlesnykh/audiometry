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
            </tr>
        <#list device.getPointList() as devicePoint>
            <tr>
                <td>
                    <a href="/config/devices/${devicePoint.getDeviceId()}/${devicePoint.getId()}">${devicePoint.getId()}</a>
                </td>
                <td>${devicePoint.getFrequency()}</td>
                <td>${devicePoint.getIntensityLevel()}</td>
            </tr>
        </#list>
        </table>
    </div>
    <div>
        <button class="btn btn-info btn-generate-device-points" name="generate-device-points">Сгенерировать точки</button>
        <button class="btn btn-info btn-add-device-point" name="add-device-point">Добавить точку</button>
    </div>
</div>
<#include "footer.ftl">