/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chinesecheckers;

/**
 *
 * @author gfragoso
 */
public class Game {
    
    private int round;
    
    private final Space[][] BOARD;
    private final Team[] TEAM;
    
    private final int NUM_PLAYERS;
    private int player;
    
    private boolean game_won;
    
    public Game(Space[][] board, Team[] team, int num_players){
        BOARD = board;
        TEAM = team;
        NUM_PLAYERS = num_players;
        
        // Initialize Variables
        round = 0;
        player = 0;
        game_won = false;
    }
    
    public void gamePlay(){
        while(!game_won){
            if(TEAM[0].finishedTurn()){
                
            }
        }
    }
}
