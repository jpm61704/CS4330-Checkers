/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpmx74checkers;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Jack
 */
public class RunnerController implements Initializable {
    
    private static final int MENU_SIZE = 33;
    
    @FXML
    VBox wrapper; 
    
    @FXML
    MenuItem sixteenButton, tenButton, eightButton, threeButton, defaultColorButton, blueColorButton;
    
    AnchorPane boardPane;
    
    private Stage stage;
    CheckerBoard board;
    ChangeListener<Number> resizeListener;
    
    

    public RunnerController() {
        this.resizeListener = (ObservableValue<? extends Number> observableValue, Number oldSceneHeight, Number newSceneHeight) -> {
            wrapper.getChildren().remove(boardPane);
        
            board = new CheckerBoard(
                    board.getNumRows(),
                    board.getNumCols(),
                    wrapper.getWidth(),
                    wrapper.getHeight() - MENU_SIZE,
                    board.getLightColor(), 
                    board.getDarkColor());
            boardPane = board.build();
   
            wrapper.getChildren().add(boardPane);
        };
       
       
    }
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    void ready(Stage stage) {
        Scene scene = stage.getScene();
       
        board = new CheckerBoard(8, 8, wrapper.getWidth(), wrapper.getHeight() - MENU_SIZE, Color.RED, Color.BLACK);
        boardPane = board.build();
        wrapper.getChildren().add(boardPane);
        
        sixteenButton.setOnAction(e -> changeDimensions(16, 16));
        tenButton.setOnAction(e -> changeDimensions(10, 10));
        eightButton.setOnAction(e -> changeDimensions(8, 8));
        threeButton.setOnAction(e -> changeDimensions(3, 3));
        
        blueColorButton.setOnAction(e -> changeColors(Color.LIGHTBLUE, Color.DARKBLUE));
        defaultColorButton.setOnAction(e -> changeColors(Color.RED, Color.BLACK));
          
        scene.widthProperty().addListener(resizeListener);
        scene.heightProperty().addListener(resizeListener);
        
        
    }
    
    
    private void changeDimensions(int rows, int cols){
        wrapper.getChildren().remove(boardPane);
            
         board = new CheckerBoard(
                    rows,
                    cols,
                    wrapper.getWidth(),
                    wrapper.getHeight() - MENU_SIZE,
                    board.getLightColor(),
                    board.getDarkColor());
        boardPane = board.build();
            
        wrapper.getChildren().add(boardPane);
    }
    
    private void changeColors(Color lightColor, Color darkColor){
            wrapper.getChildren().remove(boardPane);
            
            board = new CheckerBoard(
                    board.getNumRows(),
                    board.getNumCols(),
                    wrapper.getWidth(),
                    wrapper.getHeight() - MENU_SIZE,
                    lightColor,
                    darkColor);
            boardPane = board.build();
            
            wrapper.getChildren().add(boardPane);
    }
    
    
}
