import java.awt.Graphics;
import java.awt.Image;
import java.util.Iterator;

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
    JS_PointArray snakeArray;
    Image headImg;
    Image tailImg;
    
    /**
     * Constructor for objects of class Snake
     */
    public JS_Snake(Graphics g) {
        // Initialize instance variables  

        if (snakeArray==null) {
            length = 4;
            xPosition = 150;
            yPosition = 150;
            snakeArray = new JS_PointArray(xPosition,yPosition,length,xSize,ySize);
        }
        
        this.g = g;
        imageName = "snake_head.png";
        ImageIcon icon = new ImageIcon("resources/"+imageName);
        headImg= icon.getImage();
        ImageIcon tailIcon = new ImageIcon("resources/snake_tail.png");
        tailImg = tailIcon.getImage();
        for (int i = 0; i < length; i++) {
            String bonePos= snakeArray.getPositions().get(i);
            int x = Integer.parseInt(bonePos.split(",")[0]);
            int y = Integer.parseInt(bonePos.split(",")[1]);
            if (i==0) {
                g.drawImage(headImg, x, y,xSize,ySize, this);
            }else {
                 g.drawImage(tailImg, x, y,xSize,ySize, this);
            }
            
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
        xPosition=Integer.parseInt(snakeArray.getPositions().get(0).split(",")[0]);
        yPosition=Integer.parseInt(snakeArray.getPositions().get(0).split(",")[1]);
        switch (direction) {
        case "up": 
            yPosition-=ySize;
            break;
        case "down":
            yPosition+=ySize;
            break;
        case "left":
            xPosition-=xSize;
            break;
        case "right":
            xPosition+=xSize;
            break;
        default:
            throw new IllegalArgumentException("Unexpected value: " + direction);
        }
        
        
        for (int i = length-1; i > 0; i--) {
            snakeArray.getPositions().set(i, snakeArray.getPositions().get(i-1));
        }
        snakeArray.getPositions().set(0, xPosition+","+yPosition);
        
        
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
