<div>
    <div>
        <table>
            <tr>
                <th>ID</th>
                <th>Частота</th>
                <th>Аудиокарта</th>
            </tr>
        <#list devicePoints as devicePoint>
            <tr>
                <td>
                    <a href="/config/devices/${devicePoint.getId()}">${devicePoint.getId()}</a>
                </td>
                <td>${devicePoint.getFrequency()}</td>
                <td>${devicePoint.getIntensityLevel()}</td>
            </tr>
        </#list>
        </table>
    </div>
    <div>
        <a href="/config/devices/add">
            <button id="goToAddDeviceForm">Добавить Устройство</button>
        </a>
    </div>
</div>
