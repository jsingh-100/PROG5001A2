import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;

/**
 * This class represents a snake in the game.
 *
 * @author Jaspreet
 * @version 1.0.1
 */
public class JS_Snake extends JS_UIElement
{
    
    private int length;
    private float speed;
    private Image image;
    
    /**
     * Constructor for objects of class Snake
     */
    public JS_Snake(Graphics g) {
        // Initialize instance variables  
        length = 1;
        speed = 1;
        xPosition = 150;
        yPosition = 150;
        this.g = g;
        imageName = "snake_head.png";
        ImageIcon icon = new ImageIcon("resources/"+imageName);
        Image image = icon.getImage();
        g.drawImage(image, xPosition, yPosition,xSize,ySize, this);
        for (int i = 0; i < length; i++) {
            ImageIcon tailIcon = new ImageIcon("resources/snake_tail.png");
            Image tail = tailIcon.getImage();
            g.drawImage(tail, xPosition, yPosition+ySize,xSize,ySize, this);
        }
    }
    
        /**
     * Returns the length of the snake
     * 
     * @return property length
     */
    public int getLength() {
        return this.length; 
    }

    /**
     * Method to set the length of the snake
     *
     * @param  length the length to be set
     */
    public void setLength(int length) {

    }

    /**
     * Increases the length of the snake
     *
     * @param  amount the amount to which to increase the length
     * @return length + amount
     */
    public void increaseLength(int amount) {

    }

    /**
     * Method to return the snakes movement speed.
     *
     * @return the speed property
     */
    public float getSpeed() {
        return this.speed;
    }

    /**
     * Method to set the speed of the snake
     *
     * @param  amount  the amount to be set as speed
     */
    public void setSpeed(float amount) {

    }

    /**
     * Method to change the x or y position of the snake
     *
     * @param  direction the movement direction (left, right, up, down)
     */
    public void move(String direction) {
    }

    /**
     * Checks if snake collided on walls or its body.
     * 
     * @return True if collision adentified, False otherwise.
     */
    public boolean checkCollision() {
        return false;
    }

}
