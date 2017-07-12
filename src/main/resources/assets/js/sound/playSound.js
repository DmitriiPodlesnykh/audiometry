function playSound(frequency, volume) {
    //var audioCtx = new (window.AudioContext || window.webkitAudioContext)();
    if(!audioCtx) {
        audioCtx =  new (window.AudioContext || window.webkitAudioContext)();
    }
    var oscillator = audioCtx.createOscillator();
    var gainNode = audioCtx.createGain();
    oscillator.connect(gainNode);
    gainNode.connect(audioCtx.destination);

    gainNode.gain.value = volume;
    oscillator.frequency.value = frequency;
    oscillator.type = 'sine';

    oscillator.start();
    oscillator.stop(audioCtx.currentTime + 2);
}