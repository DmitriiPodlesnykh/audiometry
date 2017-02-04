<#include "header.ftl">

<script>
    $(document).ready(function () {
        $("#add-point").click(function () {

            $('#myModal').modal('hide');
            $("#div-for-template-form-points")
                    .append("<br><h2>new point</h2>");
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

<button type="button" class="btn btn-info btn-lg" data-toggle="modal" data-target="#myModal">Добавить точку измерения
</button>


<!-- Modal new template point-->
<div id="myModal" class="modal fade" role="dialog">
    <div class="modal-dialog">

        <!-- Modal content-->
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal">&times;</button>
                <h4 class="modal-title">Новая точка</h4>
            </div>
            <form name="add-point-for-template" role="form">
                <div class="modal-body">
                    <form name="add-point-for-template" role="form">
                        <div>
                            <label>Частота:</label>
                            <input type="text" id="new-point-frequency" name="frequency">
                        </div>
                        <div>
                            <label>Интенсивность:</label>
                            <input type="text" id="new-point-intensity" name="intensity">
                        </div>
                    </form>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-default" id="check-added-point">Прослушать</button>
                    <button type="button" class="btn btn-default" id="add-point">Добавить</button>
                    <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                </div>
            </form>
        </div>

    </div>
</div>

<#include "footer.ftl">