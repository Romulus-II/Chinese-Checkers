/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chinesecheckers;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author gfragoso
 */
public class MoveRecorder {
    
    private File file;
    private BufferedWriter writer;
    
    private long startTime;
    private long Date;
    
    private final String NAME;
    
    private final String TAB = "   ";
    
    private boolean saved;
    
    public MoveRecorder(String file_name) {
        NAME = file_name;
        
        saved = false;
        
        try {
            file = new File(NAME);
            writer = new BufferedWriter(new FileWriter(file, true));
            
            writer.write(getCurrentDate().toString());
            writer.newLine();
            writer.newLine();
            
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }
        System.out.println("Preparing to record user action...");
        startTime = System.currentTimeMillis();
    }
    
    
    /**
     * Returns a date representation of today's date.
     * @return 
     */
    private Date getCurrentDate(){
        long millis=System.currentTimeMillis();
        Date date = new Date(millis);
        return date;
    }
    
    
    public void recordTurn(Space start, Space end){
        try {
            writer.write(start.toString() + "-" + end.toString() + TAB);
        } catch (IOException ex) {
            Logger.getLogger(MoveRecorder.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
