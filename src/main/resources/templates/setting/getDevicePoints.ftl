<#include "header.ftl">
<div>
    <div>
        <table>
            <tr>
                <th>ID</th>
                <th>Частота</th>
                <th>Уровень интенсивности</th>
                <th>Амплитуда</th>
            </tr>
        <#list devicePoints as devicePoint>
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
    <div class="device-point-control-btms">
        <button id="goToAddDevicePointForm" class="btn-device-point-open-form btn btn-outline-secondary">Добавить точку
            измерения
        </button>
        <button class="generate-device-value-btn btn btn-outline-primary">Сгенеровать точки</button>
    </div>
</div>
<#include "footer.ftl">