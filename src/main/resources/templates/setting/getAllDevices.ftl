<div>
    <div>
        <table>
            <tr>
                <th>ID Устройства</th>
            </tr>
        <#list devices as device>
            <tr>
                <td>
                    <a href="/config/devices/${device.getId()}">${device.getId()}</a>
                </td>
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
