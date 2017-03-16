var points = [];
$(document).ready(function () {

    $("#addTemplate").click(function (event) {
        var templateDto = new Object();
        templateDto.authorId = "1";
        templateDto.name = document.getElementById('templateName').value;
        templateDto.description = document.getElementById('templateDescription').value;
        templateDto.points = points;
        //addTemplateAJAX();
        $.ajax({
            url: "/rest/templates/",
            type: "POST",
            contentType: "application/json; charset=utf-8",
            data: JSON.stringify(templateDto), //Stringified Json Object
            async: false,    //Cross-domain requests and dataType: "jsonp" requests do not support synchronous operation
            cache: false,    //This will force requested pages not to be cached by the browser
            processData: false, //To avoid making query String instead of JSON
            success: function (responseJsonObject) {
                var resultUrl = "/templates/" + responseJsonObject.id;
                $("#createFormDiv").hide();
                $("#main2").load(resultUrl);
                showUIResponseTenplatePoints(responseJsonObject);
                /*resposeJsonObject.points.forEach(function (point, i, resposeJsonObject.points)
                 {
                 var pointUrl = "/templates/" + resposeJsonObject.id + point.id;
                 $("#main2").load(pointUrl);
                 }
                 )
                 ;*/
                //alert( i + ": " + item + " (массив:" + arr + ")" );
                //   var pointUrl = "/templates/" + resposeJsonObject.id + point.id;
                //   $("#main2").load(pointUrl);
                //});
            }
        });


    });

    $("#addTemplatePointLocal").click(function (event) {

        var pointDto = new Object();
        pointDto.frequency = document.getElementById('frequencyLocal').value;
        pointDto.intensityValue = document.getElementById('intensityValueLocal').value;
        points.push(pointDto);

        $( "#pointsTemplateLocalDiv" ).append( "<div class='templatePointLocal'><div>"+ pointDto.frequency + "</div><div>"+ pointDto.intensityValue +"</div></div>" );
    });

    $("#listenPoint").click(function (event) {
        audioCtx = new(window.AudioContext || window.webkitAudioContext)();
        var oscillator = audioCtx.createOscillator();
        var gainNode = audioCtx.createGain();

        oscillator.connect(gainNode);
        gainNode.connect(audioCtx.destination);

        gainNode.gain.value = 0.5;
        oscillator.frequency.value = 440;
        oscillator.type = 'sine';

        oscillator.start();
        oscillator.stop(audioCtx.currentTime + 2); // stop 2 seconds after the current time*/
    });
});

function showUIResponseTenplatePoints(responseJsonObject) {
    alert("H1!");
    var responsePoint =  responseJsonObject.points;
    responsePoint.forEach(function (point, i, responsePoint) {
        var pointId=point.id;
        var pointUrl = "/templates/" + responseJsonObject.id + "/" + pointId;
        //$("#main3").append("<div id='" + pointId + "' ></div>")
        //$("#pointId").load(pointUrl);
        $("#main3").load(pointUrl);
    });


}