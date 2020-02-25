var canvas = document.getElementById('myCanvas');
var ctx = canvas.getContext('2d');

/*var window_loaded = false;
window.addEventListener('resize', resizeCanvas, false);
function resizeCanvas() {
  // Account for mobile phone users holding their phones upright.
  if(window.innerHeight > window.innerWidth)
  {
    //Refractor for mobile users
    canvas.width = window.innerWidth - (window.innerWidth/10);
    canvas.height = window.innerHeight - (window.innerHeight/10);
  }
  else
  {
    canvas.width = window.innerWidth - (window.innerWidth/10);
    canvas.height = window.innerHeight - (window.innerHeight/10);
  }
  if(window_loaded){
    resetWindow();
  }
}
resizeCanvas();
window_loaded = true;
function resetWindow(){
}*/

var num_players = 3;
