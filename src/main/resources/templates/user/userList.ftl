<div>
    <div>
        <table>
            <tr>
                <th>First Name</th>
                <th>Last Name</th>
            </tr>
        <#list users as user>
            <tr>
                <td>${user.id!}</td>
            </tr>
        </#list>
        </table>
    </div>
</div>
