
var audioCtx;

$(document).ready(function () {
    audioCtx =  new (window.AudioContext || window.webkitAudioContext)();
});
