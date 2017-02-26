function addTemplatePointAJAX(pointDto) {

    var dataString = JSON.stringify(pointDto);
    var url = "/templates/" + pointDto.templateId +"/add";

    $.ajax({
        url: url,
        type: "POST",
        contentType: "application/json; charset=utf-8",
        data: dataString,//'{"frequency": "4", "intensityValue": "1", "authorId": "37"}'
        async: false,    //Cross-domain requests and dataType: "jsonp" requests do not support synchronous operation
        cache: false,    //This will force requested pages not to be cached by the browser
        processData: false, //To avoid making query String instead of JSON
        success: function (resposeJsonObject) {
            // Success Message Handler
        }
    });
}