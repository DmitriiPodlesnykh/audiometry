

$(document).ready(function () {

    $("#addDevice").click(function (event) {
        var device = new Object();
        device.headphoneName = document.getElementById('headPhone').value;
        device.soundCardName = document.getElementById('soundCard').value;

        var url = "/rest/configuration/device";
        var jsonObject = JSON.stringify(device);
        var request = addObject(url, jsonObject);
    });

    $("#addDevicePoints").click(function (event) {

    });

    $("#addDevicePoint").click(function (event) {
        var devicePoint = new Object();

        devicePoint.deviceId = getValueFromUrl(3);//document.getElementById('headPhone').value;
        devicePoint.frequency = document.getElementById('frequency').value;
        devicePoint.intensityLevel = document.getElementById('intensityLevel').value;
        devicePoint.soundValue = document.getElementById('soundValue').value;

        var url = "/config/devices/" + devicePoint.deviceId.value();
        var jsonObject = JSON.stringify(devicePoint);
        var request = addObject(url,jsonObject);
    });

});