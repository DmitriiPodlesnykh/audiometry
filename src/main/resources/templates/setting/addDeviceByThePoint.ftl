<#include "header.ftl">
<div class="row">
    <div>
        <div>
            <label>Аудиокарта:</label>
            <input type="text" name="soundCard" id="soundCard">
        </div>
        <div>
            <label>Наушники:</label>
            <input type="text" name="headPhone" id="headPhone">
        </div>
    </div>

    <div class="start-device-point-form">
        <div>
            <p>Уровень интенсивности: 0 Дб. Частота 1000 Гц</p>
        </div>
        <label for="amplitudeValue">Амплитуда</label>
        <input type="text" class="amplitudeValue" id="amplitudeValueId">
        <button type="button" class="btn-play-sound">Прослушать</button>
    </div>
    <div>
        <button type="button" class="create-device-with-generated-points">Сгенерировать точки</button>
    </div>
</div>