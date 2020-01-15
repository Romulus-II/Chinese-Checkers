/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chinesecheckers;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.ArcType;

/**
 *
 * @author gfragoso
 */
public class Board{
    
    private Pane pane;
    private Canvas canvas;
    private GraphicsContext ctx;
    private Space[][] content;
    
    private final int PIECE_WIDTH = 5;
    
    private final Team[] TEAM;
    private int teams_generated = 0;
    
    public Board(Canvas canvas, Pane pane, int num_players){
        this.pane = pane;
        this.canvas = canvas;
        ctx = canvas.getGraphicsContext2D();
        content = createBoard();
        drawBoard(content);
        
        TEAM = new Team[num_players];
        
        switch(num_players){
            case 1:
                createTeam1(content);
                break;
            case 2:
                createTeam2(content);
                createTeam5(content);
                break;
            case 3:
                createTeam1(content);
                createTeam3(content);
                createTeam5(content);
                break;
            case 4:
                createTeam2(content);
                createTeam3(content);
                createTeam5(content);
                createTeam6(content);
                break;
            case 5:
                createTeam1(content);
                createTeam2(content);
                createTeam3(content);
                createTeam5(content);
                createTeam6(content);
                break;
            case 6:
                createTeam1(content);
                createTeam2(content);
                createTeam3(content);
                createTeam4(content);
                createTeam5(content);
                createTeam6(content);
                break;
        }
    }
    
    public Space[][] createBoard(){
                //Instantiate the content as an empty grid
        Space[][] b = new Space[17][25];
        //fill all of the spaces with "dummy" spaces
        int y = 8;
        for(int i = 0; i < b.length; i++){
            int x = -12;
            for(int j = 0; j < b[0].length; j++){
                b[i][j] = new Space(x, y);
                x++;
            }
            y--;
        }
        
        //Set piecesspaces onto content
        b[0][12].placeOnBoard();
        for(int i = 11; i <= 13; i+=2){b[1][i].placeOnBoard();}
        for(int i = 10; i <= 14; i+=2){b[2][i].placeOnBoard();}
        for(int i = 9; i <= 15; i+=2){b[3][i].placeOnBoard();}
        for(int i = 0; i <= 24; i+=2){b[4][i].placeOnBoard();}
        for(int i = 1; i <= 23; i+=2){b[5][i].placeOnBoard();}
        for(int i = 2; i <= 22; i+=2){b[6][i].placeOnBoard();}
        for(int i = 3; i <= 21; i+=2){b[7][i].placeOnBoard();}
        for(int i = 4; i <= 20; i+=2){b[8][i].placeOnBoard();}
        for(int i = 3; i <= 21; i+=2){b[9][i].placeOnBoard();}
        for(int i = 2; i <= 22; i+=2){b[10][i].placeOnBoard();}
        for(int i = 1; i <= 23; i+=2){b[11][i].placeOnBoard();}
        for(int i = 0; i <= 24; i+=2){b[12][i].placeOnBoard();}
        for(int i = 9; i <= 15; i+=2){b[13][i].placeOnBoard();}
        for(int i = 10; i <= 14; i+=2){b[14][i].placeOnBoard();}
        for(int i = 11; i <= 13; i+=2){b[15][i].placeOnBoard();}
        b[16][12].placeOnBoard();

        
        return b;
    }
    
    private void drawBoard(Space[][] b){
        double width = 10, x = 40, y = 40;
        final double BASE_X = 40, BASE_Y = 40;
        double xPadding = 25, yPadding = 40;
        
        int index = 0;
        for(int i = 0; i < b[0].length; i++){
            ctx.beginPath();
            ctx.setFill(Color.BLACK);
            ctx.fillText("" + index, x, 15);
            ctx.closePath();
            index++;
            x+=xPadding;
        }
        String[] left_axis = {"a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r"};
        for(int i = 0; i < b.length; i++){
            ctx.beginPath();
            ctx.setFill(Color.BLACK);
            ctx.fillText(left_axis[i], 15, y);
            ctx.closePath();
            y+=yPadding;
        }
        y = BASE_Y;
        
        for(int i = 0; i < b.length; i++){
            x = BASE_X;
            for(int j = 0; j < b[0].length; j++){
                if(b[i][j].isOnBoard())
                {
                    ctx.beginPath();
                    ctx.setLineWidth(2);
                    ctx.setStroke(Color.BLACK);
                    ctx.setFill(Color.DARKGRAY);
                    ctx.fillArc(x, y, width, width, 0, 360, ArcType.CHORD);
                    ctx.closePath();
                    b[i][j].setCoordinates(x, y);
                }
                x+=xPadding;
            }
            y+=yPadding;
        }
    }

    private void createTeam1(Space[][] b){
        Color c = Color.RED;
        Space[] goal = {b[16][12], b[15][11], b[15][13], b[14][10], b[14][12], 
                        b[14][14], b[13][9], b[13][11], b[13][13], b[13][15]};
        Piece[] team = new Piece[10];
        int team_count = 0;
        
        for(int i = 0; i < 4; i++){
            for(int j = 0; j < 25; j++){
                if(b[i][j].isOnBoard()){
                    team[team_count] = new Piece(j, i, goal, "red", c, pane);
                    team[team_count].setOnSpace(b[i][j]);
                    team_count++;
                }
            }
        }
        
        TEAM[teams_generated] = new Team("Red", team, goal);
        teams_generated++;
        System.out.println("Created team 1");
    }
    
    private void createTeam2(Space[][] b){
        Color c = Color.PURPLE;
        Space[] goal = {b[12][0], b[12][2], b[12][4], b[12][6], b[11][1], 
                        b[11][3], b[11][5], b[10][2], b[10][4], b[9][3]};
        Piece[] team = new Piece[10];
        int team_count = 0;
        
        for(int i = 18; i <= 24; i+=2){
            if(b[4][i].isOnBoard()){
                team[team_count] = new Piece(i, 4, goal, "purple", c, pane);
                team[team_count].setOnSpace(b[4][i]);
                team_count++;
            }
        }
        for(int i = 19; i <= 23; i+=2){
            if(b[5][i].isOnBoard()){
                team[team_count] = new Piece(i, 5, goal, "purple", c, pane);
                team[team_count].setOnSpace(b[5][i]);
                team_count++;
            }
        }
        team[team_count] = new Piece(20, 6, goal, "purple", c, pane);
        team[team_count].setOnSpace(b[6][20]);
        team_count++;
        team[team_count] = new Piece(22, 6, goal, "purple", c, pane);
        team[team_count].setOnSpace(b[6][22]);
        team_count++;
        team[team_count] = new Piece(21, 7, goal, "purple", c, pane);
        team[team_count].setOnSpace(b[7][21]);
        
        TEAM[teams_generated] = new Team("Purple", team, goal);
        teams_generated++;
        System.out.println("Created team 2");
    }
    
    private void createTeam3(Space[][] b){
        Color c = Color.GREEN;
        Space[] goal = {b[4][0], b[4][2], b[4][4], b[4][6], b[5][1], 
                        b[5][3], b[5][5], b[6][2], b[6][4], b[7][3]};
        Piece[] team = new Piece[10];
        int team_count = 0;
        
        team[team_count] = new Piece(21, 9, goal, "green", c, pane);
        team[team_count].setOnSpace(b[9][21]);
        team_count++;
        team[team_count] = new Piece(20, 10, goal, "green", c, pane);
        team[team_count].setOnSpace(b[10][20]);
        team_count++;
        team[team_count] = new Piece(22, 10, goal, "green", c, pane);
        team[team_count].setOnSpace(b[10][22]);
        team_count++;
        for(int i = 19; i <= 23; i+=2){
            if(b[11][i].isOnBoard()){
                team[team_count] = new Piece(i, 11, goal, "green", c, pane);
                team[team_count].setOnSpace(b[11][i]);
                team_count++;
            }
        }
        for(int i = 18; i <= 24; i+=2){
            if(b[12][i].isOnBoard()){
                team[team_count] = new Piece(i, 12, goal, "green", c, pane);
                team[team_count].setOnSpace(b[12][i]);
                team_count++;
            }
        }
        
        TEAM[teams_generated] = new Team("Green", team, goal);
        teams_generated++;
        System.out.println("Created team 3");
    }
    
    private void createTeam4(Space[][] b){
        Color c = Color.DARKORANGE;
        Space[] goal = {b[0][12], b[1][11], b[1][13], b[2][10], b[2][12], 
                        b[2][14], b[3][9], b[3][11], b[3][13], b[3][15]};
        Piece[] team = new Piece[10];
        int team_count = 0;
        
        for(int i = b.length-4; i < b.length; i++){
            for(int j = 0; j < 25; j++){
                if(b[i][j].isOnBoard()){
                    team[team_count] = new Piece(j, i, goal, "orange", c, pane);
                    team[team_count].setOnSpace(b[i][j]);
                    team_count++;
                }
            }
        }
        
        TEAM[teams_generated] = new Team("Orange", team, goal);
        teams_generated++;
        System.out.println("Created team 4"); 
    }
    
    private void createTeam5(Space[][] b){
        Color c = Color.BLUE;
        Space[] goal = {b[12][24], b[12][22], b[12][20], b[12][18], b[11][23], 
                        b[11][21], b[11][19], b[10][22], b[10][20], b[9][21]};
        Piece[] team = new Piece[10];
        int team_count = 0;
        
        team[team_count] = new Piece(9, 3, goal, "blue", c, pane);
        team[team_count].setOnSpace(b[9][3]);
        team_count++;
        team[team_count] = new Piece(10, 2, goal, "blue", c, pane);
        team[team_count].setOnSpace(b[10][2]);
        team_count++;
        team[team_count] = new Piece(10, 4, goal, "blue", c, pane);
        team[team_count].setOnSpace(b[10][4]);
        team_count++;
        for(int i = 1; i <= 5; i+=2){
            if(b[11][i].isOnBoard()){
                team[team_count] = new Piece(i, 11, goal, "blue", c, pane);
                team[team_count].setOnSpace(b[11][i]);
                team_count++;
            }
        }
        for(int i = 0; i <= 6; i+=2){
            if(b[12][i].isOnBoard()){
                team[team_count] = new Piece(i, 12, goal, "blue", c, pane);
                team[team_count].setOnSpace(b[12][i]);
                team_count++;
            }
        }
        
        TEAM[teams_generated] = new Team("Blue", team, goal);
        teams_generated++;
        System.out.println("Created team 5");
    }
    
    private void createTeam6(Space[][] b){
        Color c = Color.YELLOW;
        Space[] goal = {b[12][18], b[12][20], b[12][22], b[12][24], b[11][19], 
                        b[11][21], b[11][23], b[10][20], b[10][22], b[9][21]};
        Piece[] team = new Piece[10];
        int team_count = 0;
        
        for(int i = 0; i <= 6; i+=2){
            if(b[4][i].isOnBoard()){
                team[team_count] = new Piece(i, 4, goal, "yellow", c, pane);
                team[team_count].setOnSpace(b[4][i]);
                team_count++;
            }
        }
        for(int i = 1; i <= 5; i+=2){
            if(b[5][i].isOnBoard()){
                team[team_count] = new Piece(i, 5, goal, "yellow", c, pane);
                team[team_count].setOnSpace(b[5][i]);
                team_count++;
            }
        }
        team[team_count] = new Piece(2, 6, goal, "yellow", c, pane);
        team[team_count].setOnSpace(b[6][2]);
        team_count++;
        team[team_count] = new Piece(4, 6, goal, "yellow", c, pane);
        team[team_count].setOnSpace(b[6][4]);
        team_count++;
        team[team_count] = new Piece(3, 7, goal, "yellow", c, pane);
        team[team_count].setOnSpace(b[7][3]);
        
        TEAM[teams_generated] = new Team("Yellow", team, goal);
        teams_generated++;
        System.out.println("Created team 6");
    }
}
