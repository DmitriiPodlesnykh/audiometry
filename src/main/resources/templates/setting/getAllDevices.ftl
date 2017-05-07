<#include "header.ftl">
<div>
    <div>
        <table>
            <tr>
                <th>ID</th>
                <th>Аудиовыход</th>
                <th>Аудиокарта</th>
            </tr>
        <#list devices as device>
            <tr>
                <td>
                    <a href="/config/devices/${device.getId()}">${device.getId()}</a>
                </td>
                <td>${device.getHeadphoneName()}</td>
                <td>${device.getSoundCardName()}</td>
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
