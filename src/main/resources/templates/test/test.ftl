<#include "header.ftl">
<div>
    <div>
        <p>test.getId()</p>
    </div>
    <table>
        <tr>
            <th>Частота</th>
            <th>Интенсиваность</th>
        </tr>
    <#list test.getPoints() as testPoint>
        <tr>
            <td>${testPoint.getFrequency()}</td>
        </tr>
        <tr>
            <td>${testPoint.getIntensityLevel()}</td>
        </tr>
    </#list>
    </table>
</div>