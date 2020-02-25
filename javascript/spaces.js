var space = [];
const ROWS = 17;
const COLS = 25;

function createSpaces() {
  var base_width = 10;
  var loc_x = 40;
  var loc_y = 40;
  const BASE_X = loc_x;
  const XPAD = 25;
  const YPAD = 40;

  var y_index = 0;

  // fill the 2d array of spaces
  for(var i = 0; i < ROWS; i++){

    space[i] = [];

    var x_index = 0;
    loc_x = BASE_X;

    for(var j = 0; j < COLS; j++){
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
      x_index++;
      loc_x += XPAD;
    }
    y_index++;
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

var x_plot = [];
for(var i = 0; i < 25; i++){
  x_plot[i] = i;
}
var y_plot = ['a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q'];

function drawSpaces() {

  for(var i = 0; i < ROWS; i++){
    for(var j = 0; j < COLS; j++){
      ctx.fillText(y_plot[i], 10, space[i][j].cy);
      ctx.fillText(x_plot[j], space[i][j].cx, 10);
      if(space[i][j].on_board){
        ctx.beginPath();
        ctx.arc(space[i][j].cx, space[i][j].cy, space[i][j].width, 0, Math.PI*2);
        ctx.fillStyle = space[i][j].color;
        ctx.lineWidth *= 2;
        if(space[i][j].selected) {
          ctx.strokeStyle = 'white';
        }else {
          ctx.strokeStyle = 'black';
        }
        ctx.fill();
        ctx.stroke();
        ctx.lineWidth /= 2;
        ctx.closePath();
      }
    }
  }
}

function getSpace(piece){
  for(var i = 0; i < ROWS; i++){
    for(var j = 0; j < COLS; j++){
      if(space[i][j].on_board && space[i][j].cx == piece.x && space[i][j].cy == piece.y){
        return space[i][j];
      }
    }
  }
}

function occupied(space){
  for(var i = 0; i < team.length; i++) {
    for(var j = 0; j < team[i].piece.length; j++) {
      if(space.cx == team[i].piece[j].x && space.cy == team[i].piece[j].y) {
        return true;
      }
    }
  }
  return false;
}

function coordToString(x, y){
  return '(' + x + ', ' + y + ') ';
}

function spaceToString(s) {
  var row_name = '';
  switch(s.y){
    case 0:
      row_name = 'a';
      break;
    case 1:
      row_name = 'b';
      break;
    case 2:
      row_name = 'c';
      break;
    case 3:
      row_name = 'd';
      break;
    case 4:
      row_name = 'e';
      break;
    case 5:
      row_name = 'f';
      break;
    case 6:
      row_name = 'g';
      break;
    case 7:
      row_name = 'h';
      break;
    case 8:
      row_name = 'i';
      break;
    case 9:
      row_name = 'j';
      break;
    case 10:
      row_name = 'k';
      break;
    case 11:
      row_name = 'L';
      break;
    case 12:
      row_name = 'm';
      break;
    case 13:
      row_name = 'n';
      break;
    case 14:
      row_name = 'o';
      break;
    case 15:
      row_name = 'p';
      break;
    case 16:
      row_name = 'q';
      break;
  }
  return (row_name + s.x);
}

function stringToSpace(str){
  var letter = str.substring(0,1);
  var number = str.substring(1);
  var si = 100;
  var sj = parseInt(number, 10);
  strings = ['a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q'];
  cap_strings = [];
  for(var i = 0; i < strings.length; i++){
    if(letter == strings[i]){
      si = i;
    }
  }
  if(si == 100){
    console.log('Could not convert ' + str + ' to a space.');
    return;
  }else{
    return space[si][sj];
  }
}
