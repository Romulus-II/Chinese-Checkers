/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chinesecheckers;

import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;

/**
 *
 * @author gfragoso
 */
public class CreateMenu extends MenuBar {
    private final Thread thread;
    /**
     * Stops all running threads.
     */
    public void scrap(){
        thread.stop();
    }
    
    private boolean timer_shown = false;
    
    public CreateMenu() {
      
      //Timer
        Label time = new Label();
        Timer timer = new Timer(time);
                
        time.textProperty().bind(timer.getTime());
        Menu clock = new Menu("", time);
        clock.setDisable(true);
        
        MenuItem timer_1 = new MenuItem();
        clock.getItems().add(timer_1);
        
        getMenus().addAll(clock);
        
        thread = new Thread(timer);
        thread.start();
        
    }
}
