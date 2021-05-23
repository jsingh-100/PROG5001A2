
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
import javax.swing.JButton;
import java.awt.BorderLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import javax.swing.JLabel;
import java.awt.Insets;

public class JS_GameBoard extends JPanel implements ActionListener {
    private static final int B_HEIGHT = 300;
    private static final int B_WIDTH = 300;
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
    private boolean inGame = true;
    final JPanel menuPannel = new JPanel();

    /**
     * Constructor for objects of class JS_GameBoard
     */
    public JS_GameBoard() {
        addKeyListener(new TAdapter());
        setPreferredSize(new Dimension(xcells * szcell, ycells * szcell));
        setBackground(Color.black);
        setFocusable(true);
        timer = new Timer(DELAY, this);
        createMenu();
        timer.start();

    }


    /**
     * 
     */
    private void createMenu() {
        GridBagLayout gridBagLayout = new GridBagLayout();
        gridBagLayout.columnWidths = new int[]{50, 200, 0};
        gridBagLayout.rowHeights = new int[] {100, 200, 0};
        gridBagLayout.columnWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
        gridBagLayout.rowWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
        setLayout(gridBagLayout);
        menuPannel.setBackground(Color.BLACK);
        menuPannel.setPreferredSize(new Dimension(200, 200));
        GridBagConstraints gbc_menuPannel = new GridBagConstraints();
        gbc_menuPannel.anchor = GridBagConstraints.NORTHWEST;
        gbc_menuPannel.gridx = 1;
        gbc_menuPannel.gridy = 1;
        add(menuPannel, gbc_menuPannel);
        GridBagLayout gbl_menuPannel = new GridBagLayout();
        gbl_menuPannel.columnWidths = new int[] {58, 0, 0};
        gbl_menuPannel.rowHeights = new int[] {23, 0, 0, 0, 0, 89, 0};
        gbl_menuPannel.columnWeights = new double[]{0.0, 0.0, 0.0};
        gbl_menuPannel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
        menuPannel.setLayout(gbl_menuPannel);
        
        JLabel gameOverLbl = new JLabel("GAME OVER");
        gameOverLbl.setForeground(Color.WHITE);
        GridBagConstraints gbc_gameOverLbl = new GridBagConstraints();
        gbc_gameOverLbl.insets = new Insets(0, 0, 5, 5);
        gbc_gameOverLbl.gridx = 1;
        gbc_gameOverLbl.gridy = 4;
        menuPannel.add(gameOverLbl, gbc_gameOverLbl);
        
        JButton playBtn = new JButton("CLICK TO PLAY");
        playBtn.setBackground(Color.BLACK);
        playBtn.setForeground(Color.WHITE);
        GridBagConstraints gbc_playBtn = new GridBagConstraints();
        gbc_playBtn.insets = new Insets(0, 0, 5, 5);
        gbc_playBtn.anchor = GridBagConstraints.NORTHWEST;
        gbc_playBtn.gridx = 1;
        gbc_playBtn.gridy = 5;
        menuPannel.add(playBtn, gbc_playBtn);
        menuPannel.setVisible(false);
    }


    /**
     * 
     */
    private void showHideMenu() {
        if (!inGame) {
            menuPannel.setVisible(true);
        }else {
            menuPannel.setVisible(false);
        }
    }


    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        showHideMenu();
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
        checkCollision();
        checkSnakeEatingPrey();
    }

    /**
     * Check if the snake has eaten the prey
     */
    private void checkSnakeEatingPrey() {
        
        int x = Integer.parseInt( JS_PointArray.positions.get(0).split(",")[0]);
        int y = Integer.parseInt( JS_PointArray.positions.get(0).split(",")[1]);
        int size = prey.getxSize();
        if (x < prey.x+size && x >prey.x-size) {
            if (y < prey.y+size && y >prey.y-size) {
                eatPrey();
            }
        }
        

        
    }

    
    /**
     * Grow snake by one bone
     * 
     * Instantiate new prey
     */
    private void eatPrey() {
        prey.destroy();
        snake.increaseLength(1);
        
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

            if ((key == KeyEvent.VK_SPACE)) {
                if (timer.isRunning()) {
                    timer.stop();
                } else {
                    timer.start();
                }
            }
        }
    }

    /**
     * check snake collision
     */
    private void checkCollision() {

        int x = Integer.parseInt(JS_PointArray.positions.get(0).split(",")[0]);
        int y = Integer.parseInt(JS_PointArray.positions.get(0).split(",")[1]);

        if (snake.checkCollision()) {
            inGame = false;
        }

        if (y >= B_HEIGHT) {
            inGame = false;
        }

        if (y < 0) {
            inGame = false;
        }

        if (x >= B_WIDTH) {
            inGame = false;
        }

        if (x < 0) {
            inGame = false;
        }

        if (!inGame) {
            timer.stop();
        }
    }

}
