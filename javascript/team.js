var team = [];
const PIECE_WIDTH = 15;

var cur_team = 0;

function createTeam(index, spaces, color, goal){

  // Create pieces array;
  var new_piece = [];
  for(var i = 0; i < 10; i++){
    new_piece[i] = createPiece(spaces[i], color, goal);
  }

  // Fill team array with this team
  t = {
    color: color,
    piece: new_piece,
    active: false,
    in_goal: false
  }
  team.push(t);

  console.log('Finished creating team ' + index);
}

function createPiece(s, c, g){
  var piece = {
    x: s.cx,
    y: s.cy,
    width: PIECE_WIDTH,
    color: c,
    goal: g,
    selected: false,
    in_goal: false
  };
  return piece;
}

function createTeam1(){
  var team_1_spaces = [
    space[0][12], space[1][11], space[1][13], space[2][10], space[2][12],
    space[2][14], space[3][9], space[3][11], space[3][13], space[3][15]
  ];
  var team_1_color = '#ff0000';
  var team_1_goal = [
    space[16][12], space[15][11], space[15][13], space[14][10], space[14][12],
    space[14][14], space[13][9], space[13][11], space[13][13], space[13][15]
  ];
  createTeam(1, team_1_spaces, team_1_color, team_1_goal);
}
function createTeam2(){
  var team_2_spaces = [
    space[4][18], space[4][20], space[4][22], space[4][24], space[5][19],
    space[5][21], space[5][23], space[6][20], space[6][22], space[7][21]
  ];
  var team_2_color = '#9933ff';
  var team_2_goal = [
    space[9][3], space[10][2], space[10][4], space[11][1], space[11][3],
    space[11][5], space[12][0], space[12][2], space[12][4], space[12][6]
  ];
  createTeam(2, team_2_spaces, team_2_color, team_2_goal);
}
function createTeam3(){
  var team_3_spaces = [
    space[9][21], space[10][20], space[10][22], space[11][19], space[11][21],
    space[11][23], space[12][18], space[12][20], space[12][22], space[12][24]
  ];
  var team_3_color = '#009933';
  var team_3_goal = [
    space[4][0], space[4][2], space[4][4], space[4][6], space[5][1],
    space[5][3], space[5][5], space[6][2], space[6][4], space[7][3]
  ];
  createTeam(3, team_3_spaces, team_3_color, team_3_goal);
}
function createTeam4(){
  var team_4_spaces = [
    space[16][12], space[15][11], space[15][13], space[14][10], space[14][12],
    space[14][14], space[13][9], space[13][11], space[13][13], space[13][15]
  ];
  var team_4_color = '#ff6600';
  var team_4_goal = [
    space[0][12], space[1][11], space[1][13], space[2][10], space[2][12],
    space[2][14], space[3][9], space[3][11], space[3][13], space[3][15]
  ];
  createTeam(4, team_4_spaces, team_4_color, team_4_goal);
}
function createTeam5(){
  var team_5_spaces = [
    space[9][3], space[10][2], space[10][4], space[11][1], space[11][3],
    space[11][5], space[12][0], space[12][2], space[12][4], space[12][6]
  ];
  var team_5_color = '#3333ff';
  var team_5_goal = [
    space[4][18], space[4][20], space[4][22], space[4][24], space[5][19],
    space[5][21], space[5][23], space[6][20], space[6][22], space[7][21]
  ];
  createTeam(5, team_5_spaces, team_5_color, team_5_goal);
}
function createTeam6(){
  var team_6_spaces = [
    space[4][0], space[4][2], space[4][4], space[4][6], space[5][1],
    space[5][3], space[5][5], space[6][2], space[6][4], space[7][3]
  ];
  var team_6_color = '#ffff00';
  var team_6_goal = [
    space[9][21], space[10][20], space[10][22], space[11][19], space[11][21],
    space[11][23], space[12][18], space[12][20], space[12][22], space[12][24]
  ];
  createTeam(6, team_6_spaces, team_6_color, team_6_goal);
}

function drawPieces(){
  for(var i = 0; i < team.length; i++){
    for(var j = 0; j < team[i].piece.length; j++){
      ctx.beginPath();
      ctx.arc(team[i].piece[j].x, team[i].piece[j].y, team[i].piece[j].width, 0, Math.PI*2);
      ctx.fillStyle = team[i].piece[j].color;
      ctx.lineWidth *= 3;
      if(team[i].piece[j].selected){
        ctx.strokeStyle = 'white';
      }else{
        ctx.strokeStyle = 'black';
      }
      ctx.fill();
      ctx.stroke();
      ctx.lineWidth /= 3;
      ctx.closePath();
    }
  }
}

function inGoal(t){
  for(var i = 0; i < t.piece.length; i++){
    if(!t.piece[i].in_goal){
      return false;
    }
  }
  return true;
}

function goalCheck(p){
  for(var i = 0; i < p.goal.length; i++){
    if(p.x == p.goal[i].cx && p.y == p.goal[i].cy){
      p.in_goal = true;
    }
  }
}

function findPiece(i, x, y){
  //console.log('i: ' + i + ', x: ' + x + ', y: ' + y);
  for(var j = 0; j < team[i].piece.length; j++){
    if(team[i].piece[j].x == x && team[i].piece[j].y == y){
      //console.log('Found piece.')
      return j;//team[i].piece[j];
    }
  }
}
