/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chinesecheckers;

import java.util.ArrayList;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

/**
 *
 * @author gfragoso
 */
public class Piece {
    private int x, y;
    
    private Space[] goal;
    private ArrayList<Space> pos_moves;
    
    private String team;
    
    private Circle self;
    private final int CIRC_RAD = 15;
    
    private Space space;
    
    public Piece(int x, int y, Space[] goal, String team, Color c, Pane pane){
        this.x = x;
        this.y = y;
        this.goal = goal;
        this.team = team;
        
        self = new Circle();
        self.setCenterX(0);
        self.setCenterY(0);
        self.setRadius(CIRC_RAD);
        self.setFill(c);
        self.setStroke(Color.BLACK);
        pane.getChildren().add(self);
        pos_moves = new ArrayList<>();
    }
    
    public void setOnSpace(Space s){
        if(s.isOnBoard()){
            if(!s.isOccupied()){
                space = s;
                self.setCenterX(s.getCX());
                self.setCenterY(s.getCY());
                s.occupy();
            }else{
                System.out.println("Cannot place piece on top of another piece");
            }
        }else{
            System.out.println("Cannot place piece off the board.");
        }
    }
    
    public void move(){
        
    }
}
