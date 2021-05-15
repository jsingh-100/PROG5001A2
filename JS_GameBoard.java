
/**
 * This class represents the game board.
 *
 * @author Jaspreet
 * @version 1.0.1
 */
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JPanel;
import javax.swing.Timer;

public class JS_GameBoard extends JPanel implements ActionListener {
    int xcells = 30;
    int ycells = 30;
    int szcell = 10;
    JS_Snake snake;
    JS_Prey prey;
    private final int DELAY = 140;
    private Timer timer;

    private boolean leftDirection = false;
    private boolean rightDirection = true;
    private boolean upDirection = false;
    private boolean downDirection = false;

    /**
     * Constructor for objects of class JS_GameBoard
     */
    public JS_GameBoard() {
        addKeyListener(new TAdapter());
        setPreferredSize(new Dimension(xcells * szcell, ycells * szcell));
        setBackground(Color.black);
        setFocusable(true);
        timer = new Timer(DELAY, this);
        timer.start();

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
    public void showWinningGUI() {
    }

    /**
     * Method to show losing GUI
     */
    public void showLosingGUI() {
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        move();
        repaint();

    }

    /**
     * move snake
     * 
     */
    private void move() {
        if (leftDirection)
            snake.move("left");
        if (rightDirection)
            snake.move("right");
        if (upDirection)
            snake.move("up");
        if (downDirection)
            snake.move("down");
    }

    private class TAdapter extends KeyAdapter {

        @Override
        public void keyPressed(KeyEvent e) {

            int key = e.getKeyCode();

            if ((key == KeyEvent.VK_LEFT) && (!rightDirection)) {
                leftDirection = true;
                upDirection = false;
                downDirection = false;
            }

            if ((key == KeyEvent.VK_RIGHT) && (!leftDirection)) {
                rightDirection = true;
                upDirection = false;
                downDirection = false;
            }

            if ((key == KeyEvent.VK_UP) && (!downDirection)) {
                upDirection = true;
                rightDirection = false;
                leftDirection = false;
            }

            if ((key == KeyEvent.VK_DOWN) && (!upDirection)) {
                downDirection = true;
                rightDirection = false;
                leftDirection = false;
            }
        }
    }

}
