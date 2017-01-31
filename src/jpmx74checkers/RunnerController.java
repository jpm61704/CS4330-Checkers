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
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
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
    
    AnchorPane boardPane;
    
    private Stage stage;
    CheckerBoard board;
    

    ChangeListener<Number> resizeListener = (ObservableValue<? extends Number> observableValue, Number oldSceneHeight, Number newSceneHeight) -> {
            wrapper.getChildren().remove(boardPane);
        
            board = new CheckerBoard(8, 8, wrapper.getWidth(), wrapper.getHeight() - MENU_SIZE);
            boardPane = board.build();
   
            wrapper.getChildren().add(boardPane);
        };
    
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    void ready(Stage stage) {
        Scene scene = stage.getScene();
        
        CheckerBoard board = new CheckerBoard(8, 8, wrapper.getWidth(), wrapper.getHeight() - MENU_SIZE);
        boardPane = board.build();
        wrapper.getChildren().add(boardPane);
          
        scene.widthProperty().addListener(resizeListener);
        scene.heightProperty().addListener(resizeListener);
    }
    
    
    
    
    
}
