

$(document).ready(function () {

    $("#addDevice").click(function (event) {
        var device = new Object();
        device.headphoneName = document.getElementById('headPhone').value;
        device.soundCardName = document.getElementById('soundCard').value;

        var url = "/rest/configuration/device";
        var jsonObject = JSON.stringify(device);
        var request = addObject(url, jsonObject);
        alert(request);
    });




});