var moves = [];
var pieces_moved = [];
var undone_moves = [];

function getMousePos(canvas, evt) {
  var rect = canvas.getBoundingClientRect();
  return {
    x: evt.clientX - rect.left,
    y: evt.clientY - rect.top
  };
}

function getDistanceFromSpace(x, y, s) {
  var dist = Math.sqrt(Math.pow(x - s.cx, 2) + Math.pow(y - s.cy, 2));
  return dist;
}
function getDistanceFromPiece(x, y, p) {
  var dist = Math.sqrt(Math.pow(x - p.x, 2) + Math.pow(y - p.y, 2));
  return dist;
}

// Necessary variables in order to move on to the next turn.
var piece_selected = false;
var cur_piece;
var starting_space;
var cur_space;
var moved = false;

function undo(){
  if(moves.length == 0){
    console.log('You must make a move first!');
    return;
  }
  resetVarables();
  if(cur_team == 0){
    cur_team = num_players-1;
  }else{
    cur_team--;
  }

  var move = moves.pop();
  spaces = move.split('-');
  start_str = spaces[0];
  end_str = spaces[spaces.length-1];
  space_s = stringToSpace(start_str);
  space_e = stringToSpace(end_str);

  var moved_piece = pieces_moved.pop();
  piece_info = moved_piece.split(',');
  pie = findPiece(cur_team, parseInt(piece_info[0]), parseInt(piece_info[piece_info.length-1]));
  team[cur_team].piece[pie].x = space_s.cx;
  team[cur_team].piece[pie].y = space_s.cy;
  console.log('Team ' + (cur_team+1) + "'s turn");
}

function resetVarables(){
  piece_selected = false;
  starting_space = null;
  cur_space = null;
  moved = false;
}

function startNextTurn(){
  for(var i = 0; i < ROWS; i++){
    for(var j = 0; j < COLS; j++){
      space[i][j].selected = false;
    }
  }
  for(var i = 0; i < team[cur_team].piece.length; i++){
    team[cur_team].piece[i].selected = false;
  }
  cur_team++;
  if(cur_team == num_players){
    cur_team = 0;
  }
  var pie = cur_piece.x.toString() + ',' + cur_piece.y.toString();
  console.log(pie);
  pieces_moved.push(pie);
  var str = spaceToString(starting_space) + '-' + spaceToString(cur_space);
  console.log(str)
  moves.push(str);
  resetVarables();
  console.log('Team ' + (cur_team+1) + "'s turn");
}


canvas.addEventListener('mousedown', function(evt) {

  var mouse = getMousePos(canvas, evt);
  //var mouse_loc = getDistance(mouse.x, mouse.y, obj);

  //console.log(coordToString(mouse.x, mouse.y));

  for(var i = 0; i < team[cur_team].piece.length; i++) {
    var mouse_loc = getDistanceFromPiece(mouse.x, mouse.y, team[cur_team].piece[i]);
    //console.log('Distance: ' + mouse_loc + ' v/s Width: ' + team[cur_team].piece[i].width);
    if(mouse_loc < team[cur_team].piece[i].width) {

      if(team[cur_team].piece[i].selected) {
        team[cur_team].piece[i].selected = false;
        if(moved){
          startNextTurn();
        }else{
          cur_piece = null;
          piece_selected = false;
        }
      }else{
        if(!moved) {
          for(var j = 0; j < team[cur_team].piece.length; j++){
            team[cur_team].piece[j].selected = false;
          }
          team[cur_team].piece[i].selected = true;
          starting_space = getSpace(team[cur_team].piece[i]);
          cur_piece = team[cur_team].piece[i];
          piece_selected = true;
        }else {
          startNextTurn();
        }
      }
      return;
    }
  }

  for(var i = 0; i < ROWS; i++) {
    for(var j = 0; j < COLS; j++) {
      if(space[i][j].on_board) {
        var mouse_loc = getDistanceFromSpace(mouse.x, mouse.y, space[i][j]);
        if(mouse_loc < space[i][j].width) {
          // Break up into multiple if statements to catch "errors" with else console logs
          if(piece_selected && !occupied(space[i][j])) {//&& space[i][j] != starting_space) {
            cur_piece.x = space[i][j].cx;
            cur_piece.y = space[i][j].cy;
            if(cur_piece.goal.includes(space[i][j])) {
              cur_piece.in_goal = true;
            }else{
              cur_piece.in_goal = false;
            }
            cur_space = space[i][j];
            if(cur_space!=starting_space) {
              moved = true;
            }
            return;
          }
        }
      }
    }
  }
});
