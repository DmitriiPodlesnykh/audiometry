<#include "header.ftl">
<div class="row">
    <h1>Точка измерения устройства  ${devicePoint.getId()}</h1>
    <p>Частота: ${devicePoint.getFrequency()} Гц</p>
    <p>Уровень интенсивности: ${devicePoint.getIntensityLevel()} Дб</p>
    <p>Амплитуда: ${devicePoint.getSoundValue()}</p>
    <button type="button" class="btn-play-sound">Прослушать</button>
</div>