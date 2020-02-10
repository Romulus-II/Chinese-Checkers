var space = [];
const COLS = 17;
const ROWS = 25;

function createSpaces() {
  var width = 10;
  var x = 40;
  var y = 40;
  const BASE_X= x;
  const BASE_Y =y;

  var y_index = 8;
  for(var i = 0; i < COLS; i++){

    space[i] = [];

    var x_index = -12;
    x = BASE_X;

    for(var j = 0; j < ROWS; j++){
      space[i][j] = {
        x: x_index,
        y: y_index,
        cx: x,
        xy: y,
        width: width,
        on_board: false
      };
    }
  }

  console.log('Finished creating the spaces');

}

function drawSpaces() {

  console.log('Drawing the spaces');

  for(var i = 0; i < COLS; i++){
    for(var j = 0; j < ROWS; j++){
      ctx.beginPath();
      ctx.arc(space[i][j].x, space[i][j].y, space[i][j].width, 0, Math.PI*2, false);
      ctx.fillStyle = "white";//"#d6d6c2";
      ctx.fill();
      ctx.closePath();
    }
  }
}
