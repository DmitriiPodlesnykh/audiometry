

$(document).ready(function () {

    $("#addDevice").click(function (event) {
        var device = {};
        device.headphoneName = document.getElementById('headPhone').value;
        device.soundCardName = document.getElementById('soundCard').value;

        var url = "/rest/configuration/devices";
        var jsonObject = JSON.stringify(device);
        var request = addObject(url, jsonObject, "PUT");

        if(!request) {
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
        var request = addObject(url,jsonObject, "PUT");
    });

    $("#openAddDeviceForm").click(function (event) {

    });

    $("#openAddDevicePointForm").click(function (event) {

    });

    $("#playDevicePointSound").click(function (event) {
        var volume =  document.getElementById('volumeValue').value;
        var frequency = document.getElementById('frequency').value;
        playSound(frequency, volume);
    });

    $("#cancelAddDevice").click(function (event) {

    });

    $("#cancelAddDevicePoint").click(function (event) {

    });

});