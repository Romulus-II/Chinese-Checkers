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
public class Team {
    
    private final String COLOR;
    private final Piece[] MEMBER;
    private final Space[] GOAL;
    
    private int min_distance;
    private int max_distance;
    
    private boolean in_goal;
    
    public Team(String color, Piece[] member, Space[] goal){
        COLOR = color;
        MEMBER = member;
        GOAL = goal;
        
        in_goal = false;
    }
    
    /**
     * Returns a boolean representation of whether or not every piece on the team
     * has reached the goal, used to track if the team has won the game.
     * @return boolean in_goal
     */
    public boolean inGoal(){
        return in_goal;
    }

    
}
