

<h1>Шаблон ${template.getName()}</h1>
<h1>${template.getId()}</h1>

<form name="deleteTemplate" role="form" action="/templates/${template.getId()}" method="delete">
    <button id="deleteTemplate" type="submit">Удалить шаблон</button>
</form>