$(document).ready(function () {

    $("#addDevice").click(function (event) {
        var device = {};
        device.headphoneName = document.getElementById('headPhone').value;
        device.soundCardName = document.getElementById('soundCard').value;

        var url = "/rest/configuration/devices";
        var jsonObject = JSON.stringify(device);
        var request = addObject(url, jsonObject, "PUT");

        if (!request) {
        }
    });

    $("#addDevicePoints").click(function (event) {

    });

    $("#addDevicePoint").click(function (event) {
        var devicePoint = {};

        devicePoint.deviceId = getValueFromUrl(3);//document.getElementById('headPhone').value;
        devicePoint.frequency = document.getElementById('frequency').value;
        devicePoint.intensityLevel = document.getElementById('intensityLevel').value;
        devicePoint.volumeValue = document.getElementById('volumeValue').value;

        var url = "/rest/configuration/devices/" + getValueFromUrl(3);
        var jsonObject = JSON.stringify(devicePoint);
        var request = addObject(url, jsonObject, "PUT");
    });

    $(".add-device-point-btn").click(function (event) {
        var devicePoint = {};

        if ($(this).parent().hasClass("add-device-point-form")) {
            var volume = $(this).parent().children().hasClass("sound-volume-field");
            var frequency = $(this).parent().children().hasClass("frequency-field");
            var soundValue = $(this).parent().children().hasClass("intensity-level-field");
        }
    });

    $("#openAddDeviceForm").click(function (event) {

    });

    $("#openAddDevicePointForm").click(function (event) {

    });

    $(".btn-play-sound").click(function (event) {

        if (document.getElementById('volumeValue') && document.getElementById('frequency')) {
            var volume = document.getElementById('volumeValue').value;
            var frequency = document.getElementById('frequency').value;
        }

        if ($(this).parent().parent().hasClass("device-point-record")) {
            var a = $(this).parent();
            var b = $(this).parent().parent();

            volume = $(this).parent().parent().children().hasClass("sound-volume-view");
            frequency = $(this).parent().parent().children().hasClass("frequency-view");
        }

        if ($(this).parent().hasClass("start-device-point-form")) {
            frequency = 1000;
            volume = document.getElementById('amplitudeValueId').value;
        }
        if (volume && frequency) {
            playSound(frequency, volume);
        } else {
            alert("volume or frequency is empty");
            var q = $(this).parent();
            var w = $(this).parent().parent();
        }
    });

    $("#cancelAddDevice").click(function (event) {

    });

    $("#cancelAddDevicePoint").click(function (event) {

    });

    $(".generate-device-value").click(function (event) {
        alert("тут пока ничего нет");
    });

    $(".btn-generate-device-points").click(function (event) {
        alert("пытаемся нагененрировать");
        var deviceId = getValueFromUrl(3);
        var url = "/rest/configuration/devices/" + deviceId + "/generate/allpoints";
        var jsonObject = JSON.stringify(deviceId);
        var request = addObject(url, jsonObject, "POST");
    });

    $(".btn-device-point-open-form").click(function (event) {
        showAddDevicePointForm("show");
        showAddDevicePointFormBtns("hide");
        alert("тут пока ничего нет");
    });

    $(".generate-device-points-by-the-point").click(function (event) {
        var devicePoint = {};
        devicePoint.frequency = 1000;
        devicePoint.intensityLevel = 0;
        devicePoint.soundValue = document.getElementById('amplitudeValueId').value;

        var url = "/rest/configuration/devices/new";
        var jsonObject = JSON.stringify(devicePoint);
        var request = addObject(url, jsonObject, "POST");
    });
});