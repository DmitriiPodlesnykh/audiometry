<#include "header.ftl">
<div class="row">
    <h1>Точка измерения устройства  ${devicePoint.getId()}</h1>
    <p>Частота: ${devicePoint.getFrequency()} Гц</p>
    <p>Уровень интенсивности: ${devicePoint.getIntensityLevel()} Дб</p>
    <p>Амплитуда: ${devicePoint.getSoundValue()}</p>

    <input value="${devicePoint.getFrequency()}" hidden="true" id="h-frequency">
    <input value="${devicePoint.getIntensityLevel()}" hidden="true" id="h-intensity-level">
    <input value="${devicePoint.getSoundValue()}" hidden="true" id="h-amplitude">
    <button type="button" class="btn-play-sound">Прослушать</button>
</div>