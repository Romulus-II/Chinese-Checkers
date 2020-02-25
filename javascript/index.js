// Create and fill 2D space array
createSpaces();

// Using 10 element subarrays of space, create array teams
//   To do this, we must create two separate subarrays: team_i_spaces and
//    team_i_goal
function setUpTeams(){
  switch(num_players){
    case 1:
      createTeam1();
      break;
    case 2:
      createTeam2();
      createTeam5();
      break;
    case 3:
      createTeam1();
      createTeam3();
      createTeam5();
      break;
    case 4:
      createTeam2();
      createTeam3();
      createTeam5();
      createTeam6();
      break;
    case 5:
      createTeam1();
      createTeam2();
      createTeam3();
      createTeam5();
      createTeam6();
      break;
    case 6:
      createTeam1();
      createTeam2();
      createTeam3();
      createTeam4();
      createTeam5();
      createTeam6();
      break;
  }
}

setUpTeams();

function draw() {
  ctx.clearRect(0, 0, canvas.width, canvas.height);
  ctx.beginPath();
  ctx.rect(0, 0, canvas.width, canvas.height);
  ctx.fillStyle = '#ffcc80';
  ctx.fill();
  ctx.closePath();

  drawSpaces();
  drawPieces();

  requestAnimationFrame(draw);
}

draw();
