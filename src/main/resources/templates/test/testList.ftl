<#include "header.ftl">
<div>
    <div>
        <table>
            <tr>
                <th>ID</th>
                <th>тест</th>
                <th>Дата</th>
            </tr>
        <#list tests as test>
            <tr>
                <td><a href="/tests/${test.getId()}">${test.getId()}</a></td>
            </tr>
            <tr>
                <td><a href="/templates/${test.getTemplate().getId()}">${test.getTemplate().getName()}</a></td>
            </tr>
            <tr>
                <td>${test.getDate()}</td>
            </tr>
        </#list>
        </table>
    </div>
    <div>
        <a href="/tests/add">
            <button id="openAddForm">Начать тест</button>
        </a>
    </div>
</div>