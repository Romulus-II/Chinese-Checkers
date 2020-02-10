var space = [];
const COLS = 17;
const ROWS = 25;

function createSpaces() {
  var base_width = 10;
  var loc_x = 40;
  var loc_y = 40;
  const BASE_X = loc_x;
  const XPAD = 25;
  const YPAD = 40;

  var y_index = 8;

  // fill the 2d array of spaces
  for(var i = 0; i < COLS; i++){

    space[i] = [];

    var x_index = -12;
    loc_x = BASE_X;

    for(var j = 0; j < ROWS; j++){
      space[i][j] = {
        x: x_index,
        y: y_index,
        cx: loc_x,
        cy: loc_y,
        color: '#663d00',
        width: base_width,
        on_board: false,
        selected: false
      };

      loc_x += XPAD;
    }

    loc_y += YPAD;
  }

  console.log('Finished creating the spaces');

  // Select which spaces are on the board.
  space[0][12].on_board = true;
  for(var i = 11; i <= 13; i+=2){space[1][i].on_board = true;}
  for(var i = 10; i <= 14; i+=2){space[2][i].on_board = true;}
  for(var i = 9; i <= 15; i+=2){space[3][i].on_board = true;}
  for(var i = 0; i <= 24; i+=2){space[4][i].on_board = true;}
  for(var i = 1; i <= 23; i+=2){space[5][i].on_board = true;}
  for(var i = 2; i <= 22; i+=2){space[6][i].on_board = true;}
  for(var i = 3; i <= 21; i+=2){space[7][i].on_board = true;}
  for(var i = 4; i <= 20; i+=2){space[8][i].on_board = true;}
  for(var i = 3; i <= 21; i+=2){space[9][i].on_board = true;}
  for(var i = 2; i <= 22; i+=2){space[10][i].on_board = true;}
  for(var i = 1; i <= 23; i+=2){space[11][i].on_board = true;}
  for(var i = 0; i <= 24; i+=2){space[12][i].on_board = true;}
  for(var i = 9; i <= 15; i+=2){space[13][i].on_board = true;}
  for(var i = 10; i <= 14; i+=2){space[14][i].on_board = true;}
  for(var i = 11; i <= 13; i+=2){space[15][i].on_board = true;}
  space[16][12].on_board = true;
}

function drawSpaces() {

  for(var i = 0; i < COLS; i++){
    for(var j = 0; j < ROWS; j++){
      if(space[i][j].on_board){
        ctx.beginPath();
        ctx.arc(space[i][j].cx, space[i][j].cy, space[i][j].width, 0, Math.PI*2);
        ctx.fillStyle = space[i][j].color;
        ctx.strokeStyle = 'black';
        ctx.fill();
        ctx.stroke();
        ctx.closePath();
      }
    }
  }
}

function coordToString(x, y){
  return '(' + x + ', ' + y + ') ';
}