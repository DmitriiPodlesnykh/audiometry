<div>
    <table>
        <tr>
            <th>Частота</th>
            <th>Интенсивность</th>
        </tr>
    <#list templatePoints as templatePoint>
    <tr>
        <td>${templatePoint.getFrequency()}</td>
        <td>${templatePoint.getIntensityLevel()}</td>
    </tr>
    </#list>
    </table>
</div>