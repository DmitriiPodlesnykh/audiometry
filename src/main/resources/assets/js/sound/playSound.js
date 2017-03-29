function playSound(frequency, volume) {
    var audioCtx = new(window.AudioContext || window.webkitAudioContext)();
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
//function playSound() {
// one context per document
  /*  var context = new (window.AudioContext || window.webkitAudioContext)();
    var osc = context.createOscillator(); // instantiate an oscillator

    var vol = context.createGainNode();
    vol.gain.value = 0.6; // from 0 to 1, 1 full volume, 0 is muted

    osc.type = 'sine'; // this is the default - also square, sawtooth, triangle
    osc.frequency.value = 440; // Hz
    osc.connect(vol); // connect osc to vol
    osc.connect(context.destination); // connect it to the destination
    osc.start(); // start the oscillator
    osc.stop(context.currentTime + 2); // stop 2 seconds after the current time*/
   /* audioCtx = new(window.AudioContext || window.webkitAudioContext)();
    var oscillator = audioCtx.createOscillator();
    var gainNode = audioCtx.createGain();

    oscillator.connect(gainNode);
    gainNode.connect(audioCtx.destination);

    gainNode.gain.value = 0.5;
    oscillator.frequency.value = 440;
    oscillator.type = 'sine';

    oscillator.start();
    oscillator.stop(audioCtx.currentTime + 2); // stop 2 seconds after the current time*/
//};
