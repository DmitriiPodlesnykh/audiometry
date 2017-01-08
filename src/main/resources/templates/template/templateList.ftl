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
            </tr>
        </#list>
        </table>
    </div>
    <div>
        <a href="/templates/add">
            <button id="openAddForm">Добавить шаблон</button>
        </a>
    </div>
</div>
