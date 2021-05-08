/**
 * This class represents the game board.
 *
 * @author Jaspreet
 * @version 1.0.1
 */
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JPanel;

public class JS_GameBoard extends JPanel {    
    int xcells = 30;   
    int ycells = 30;
    int szcell = 10;  
    JS_Snake snake;
    JS_Prey prey;
    
    /**
     * Constructor for objects of class JS_GameBoard
     */   
    public JS_GameBoard() {
        setPreferredSize(new Dimension(xcells * szcell, ycells * szcell));        
        setBackground(Color.black);
        setFocusable(true); 
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        snake = new JS_Snake(g);
        prey = new JS_Prey(g);
    }
    
    /**
     * Method to show winning GUI
     */ 
    public void showWinningGUI(){}
    /**
     * Method to show losing GUI
     */ 
    public void showLosingGUI(){}
    
}
