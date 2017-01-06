<div>
    <div>
        <table>
            <tr>
                <th>Название</th>
                <th>Автор:</th>


            </tr>
        <#list templates as template>
            <tr>
                <td><a href="/templates/${template.getId()}">${template.getName()}</a></td>
                <td>${template.getAuthorId()}</td>
            </tr>
        </#list>
        </table>
    </div>
    <div>
        <a href="/templates/add" target="_blank">
            <button id="openAddForm">Добавить шаблон</button>
        </a>
    </div>
</div>
