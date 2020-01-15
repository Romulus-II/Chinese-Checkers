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
    private double CENTER_X, CENTER_Y;
    private boolean occupied;
    private boolean on_board;
    
    public Space(int x, int y){
        this.x = x;
        this.y = y;
        occupied = false;
        on_board = false;
    }
    
    
    /**
     * Sets the coordinates that will be used to draw the space on the canvas.
     * @param x position of x coordinate on canvas
     * @param y position of y coordinate on canvas
     */
    public void setCoordinates(double x, double y){
        CENTER_X = x + 5;
        CENTER_Y = y + 5;
    }
    
    public double getCX(){return CENTER_X;}
    
    
    public double getCY(){return CENTER_Y;}
    
    /**
     * Returns a boolean representation of whether or not the space is currently
     * on the board.
     * @return boolean on_board
     */
    public boolean isOnBoard(){
        return on_board;
    }
    
    /**
     * Depict a space as being on the board.
     */
    public void placeOnBoard(){
        on_board = true;
    }
    
    /**
     * Depict a space as not being on the board.
     */
    public void removeFromBoard(){
        on_board = false;
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

    /**
     * Check if a piece can be moved to target location.
     * @return boolean is_legal
     */
    public boolean isLegal(){
        if(on_board){
            if(!occupied){
                return true;
            }else{
                System.out.println("Space is already occupied: (" + x + "," + y + ")");
            }
        }else{
            System.out.println("Space is not on board: (" + x + "," + y + ")");
        }
        return false;
    }
    
    
    
}
