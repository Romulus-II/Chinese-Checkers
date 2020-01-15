/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chinesecheckers;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 *
 * @author gfragoso
 */
public class ChineseCheckers extends Application {
    
    private final int WIN_WIDTH = 1000, WIN_HEIGHT = 750;
    private final int CAN_WIDTH = 750, CAN_HEIGHT = 750;
    
    @Override
    public void start(Stage primaryStage) {
        StackPane root = new StackPane();
        
        
        Canvas canvas = new Canvas(CAN_WIDTH, CAN_HEIGHT);
        Pane pane = new Pane(canvas);
        
        //Very Important!!
        int numPlayers = 6;
        
        Board board = new Board(canvas, pane, numPlayers);
        
        
        //CreateMenu menu = new CreateMenu();
        CreateMenu menu = new CreateMenu();
        
        VBox main = new VBox();
        
        HBox content = new HBox();
        content.getChildren().add(pane);
        
        main.getChildren().addAll(menu, content);
        
        root.getChildren().add(main);
        
        Scene scene = new Scene(root, WIN_WIDTH, WIN_HEIGHT);
        
        primaryStage.setTitle("Chinese Checkers");
        primaryStage.setScene(scene);
        primaryStage.show();
        primaryStage.setOnCloseRequest(e -> {
            menu.scrap();
        });
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
