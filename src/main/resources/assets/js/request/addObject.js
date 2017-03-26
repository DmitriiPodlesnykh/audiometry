function addObject(url, jsonObject) {

    $.ajax({
        url: url,
        type: "POST",
        contentType: "application/json; charset=utf-8",
        data: jsonObject,
        async: false,    //Cross-domain requests and dataType: "jsonp" requests do not support synchronous operation
        cache: false,    //This will force requested pages not to be cached by the browser
        processData: false, //To avoid making query String instead of JSON
        success: function (responseJsonObject) {
            alert(responseJsonObject);
            return responseJsonObject;
        }
    });

}