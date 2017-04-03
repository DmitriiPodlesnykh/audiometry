function showDevicePoint() {

}

function showDevice() {

}

function showAddDevicePointForm(action) {
    if (action === "show") {
        $(".device-point-control-btms").append("<div class='add-device-point-form'></div>");
        $(".add-device-point-form").append("<input type='text' class='frequency-field'>");
        $(".add-device-point-form").append("<input type='text' class='intensity-level-field'>");
        $(".add-device-point-form").append("<input type='text' class='sound-volume-field'>");
        $(".add-device-point-form")
            .append("<input type='button' class='btn add-device-point-btn btn-outline-primary' value='Добавить точку'>");
    } else {
        $(".add-device-point-form").hide();
    }
}

function showAddDevicePointFormBtns(action) {
    if (action === "show") {

    } else {
        $(".btn-device-point-open-form").hide();
        $(".generate-device-value-btn").hide();
    }
}