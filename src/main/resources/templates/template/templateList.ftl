<div>
    <div>
        <table>
            <tr>
                <th>ID</th>
                <th>Имя</th>
                <th>Автор:</th>
            </tr>
        <#list templates as template>
            <tr>
                <td>${template.getId()}</td>
                <td>${template.getName()}</td>
                <td>${template.getAuthorId()}</td>
            </tr>
        </#list>
        </table>
    </div>
</div>
