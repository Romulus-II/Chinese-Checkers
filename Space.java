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
public class Space {
    private int x, y;
    private final int WIDTH;
    private boolean occupied;
    
    public Space(int x, int y, int width){
        this.x = x;
        this.y = y;
        WIDTH = 25; //Place holder
        occupied = false;
    }
    
    /**
     * Returns a boolean representation of whether or not the space is currently
     * occupied by a piece.
     * @return boolean occupied
     */
    public boolean isOccupied(){
        return occupied;
    }
    
    /**
     * Depict a space as occupied by a piece.
     */
    public void occupy(){
        occupied = true;
    }
    
    /**
     * Depict a space as not occupied by a piece.
     */
    public void desert(){
        occupied = false;
    }
    
}
