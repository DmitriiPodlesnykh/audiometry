<#include "header.ftl">

<script>
    $(document).ready(function () {
        $("#add-point-for-template").submit(function( event ) {

            $('#myModal').modal('hide');

            var pointFrequncy = $('#new-point-frequency').val();

            $("#div-for-template-form-points")
                    .append("<div><h2>new point</h2><h1>pointFrequncy.value</h1></div>");
            event.preventDefault();
        });
    });
</script>

<form name="template" role="form" action="/templates/add" method="post">
    <div>
        <label>Название:</label>
        <input type="text" name="name">
    </div>
    <input type="hidden" name="authorId" value="1">
    <div id="div-for-template-form-points">
        <!--for templatePoints-->

    </div>
    <button type="submit" id="submit">Добавить шаблон</button>
</form>
<p>description</p>

<button type="submit" class="btn btn-info btn-lg" data-toggle="modal" data-target="#myModal">Добавить точку измерения
</button>

<#include "addTemplatePointModal.ftl">
<#include "footer.ftl">