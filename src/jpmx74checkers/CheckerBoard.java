package jpmx74checkers;

import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Jack
 */
public class CheckerBoard {
    private int numRows, numCols;
    private double boardWidth, boardHeight, rectangleWidth, rectangleHeight;
    private Color lightColor, darkColor;
    private AnchorPane board;

    public CheckerBoard(int numRows, int numCols, double boardWidth, double boardHeight) {
        this.numRows = numRows;
        this.numCols = numCols;
        this.boardWidth = boardWidth;
        this.boardHeight = boardHeight;
        this.darkColor = Color.BLACK;
        this.lightColor = Color.RED;
        
        board = new AnchorPane();
    
    }

    public CheckerBoard(int numRows, int numCols, double boardWidth, double boardHeight, Color lightColor, Color darkColor) {
        this(numRows, numCols, boardWidth, boardHeight);
        this.lightColor = lightColor;
        this.darkColor = darkColor;
    }
    
    public AnchorPane build(){
        
       GridPane grid = new GridPane();
       board.getChildren().add(grid);
       
       rectangleWidth = Math.ceil(boardWidth / numCols);
       rectangleHeight = Math.ceil(boardHeight / numRows);
        
       drawSquares(grid);
 
       return board;
    }
    
    private void drawSquares(GridPane grid){
   
        
        for(int i = 0; i < numRows; i++){
            for(int j = 0; j < numCols; j++){
                Color color = nextColor(i + j);
                Rectangle rect = new Rectangle(rectangleWidth, rectangleHeight, color);
                grid.add(rect, j, i);
            }
        }
        
        
    }
    
    private Color nextColor(int cell){
        if(cell % 2 == 0){
            return lightColor;
        }else return darkColor;
    }
    
    public AnchorPane getBoard(){
        return board;
    }

    public int getNumRows() {
        return numRows;
    }

    public int getNumCols() {
        return numCols;
    }

    public double getBoardWidth() {
        return boardWidth;
    }

    public double getBoardHeight() {
        return boardHeight;
    }

    public Color getLightColor() {
        return lightColor;
    }

    public Color getDarkColor() {
        return darkColor;
    }
    
    public double getRectangleWidth(){
        return 0;
    }
    
    public double getRectangleHeight(){
        return 0;
    }
}
    
    
    

    
    

