/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpmx74checkers;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

/**
 *
 * @author Jack
 */
public class Jpmx74Checkers extends Application {
    
    @Override
    public void start(Stage stage) throws Exception{
        
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Runner.fxml"));
        Parent root = loader.load(); 
        RunnerController controller = loader.getController();
        
        
        Scene scene = new Scene(root);

        stage.setScene(scene);
        
        stage.setHeight(600);
        stage.setWidth(500);
        stage.show();
        
        controller.ready(stage);
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
