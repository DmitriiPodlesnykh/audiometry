<div id="myModal" class="modal fade" role="dialog">
    <div class="modal-dialog">

        <!-- Modal content-->
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal">&times;</button>
                <h4 class="modal-title">Новая точка</h4>
            </div>
            <form name="add-point" id="add-point-for-template" role="form">
                <div class="modal-body">
                        <div>
                            <label>Частота:</label>
                            <input type="text" id="new-point-frequency" name="frequency">
                        </div>
                        <div>
                            <label>Интенсивность:</label>
                            <input type="text" id="new-point-intensity" name="intensity">
                        </div>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-default" id="check-added-point">Прослушать</button>
                    <button type="submit" class="btn btn-default" id="add-point">Добавить</button>
                    <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                </div>
            </form>
        </div>

    </div>
</div>