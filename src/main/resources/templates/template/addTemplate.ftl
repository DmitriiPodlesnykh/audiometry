<#include "header.ftl">
<!--*/target/classes/templates/part/header.ftl-->
<form name="template" role="form" action="/templates/add" method="post">
     <div>
        <label>Название:</label>
        <input type="text" name="name">
     </div>
     <input type="hidden" name="authorId" value="1">
     <button type="button" id="addPoint">Добавить точку измерения</button>
     <button type="submit" id="submit">Добавить шаблон</button>
</form>
<p>description</p>