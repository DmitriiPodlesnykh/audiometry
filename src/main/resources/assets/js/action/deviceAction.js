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

        if($(this).parent().hasClass("add-device-point-form")) {
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

        playSound(frequency, volume);
    });

    $("#cancelAddDevice").click(function (event) {

    });

    $("#cancelAddDevicePoint").click(function (event) {

    });

    $(".generate-device-value").click(function (event) {
        alert("тут пока ничего нет");
    });

    $(".btn-device-point-open-form").click(function (event) {
        showAddDevicePointForm("show");
        showAddDevicePointFormBtns("hide");
        alert("тут пока ничего нет");
    });

});