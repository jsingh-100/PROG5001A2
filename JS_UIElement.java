import java.awt.Graphics;

import javax.swing.JFrame;

/**
 * This class is has commonly shared properties of game objects.
 *
 * @author Jaspreet
 * @version 1.0.1
 */
public abstract class JS_UIElement extends JFrame
{

    protected int xPosition, yPosition;
    protected int xSize=25, ySize=25;
    
    protected String imageName;
    protected Graphics g;
    

    /**
     * Constructor for class JS_GameElement
     */
    public JS_UIElement(){
    }

    /**
     * Method to return the X position of the element.
     *
     * @return the x position of the element.
     */
    public int getXPosition() {
        return this.xPosition;
    }

    /**
     * Method to set the element's xPosition
     *
     * @param  position  the value for position X
     */
    public void setXPosition(int position) {

    }

    /**
     * Method to return the Y position of the element
     *
     * @return the y position of the element
     */
    public int getYPosition() {
        return yPosition;
    }

    /**
     * Method to set the element's yPosition
     *
     * @param  position the value for y position to be set
     */
    public void setYPosition(int position) {

    }

    /**
     * Method to set the element's initial x and y position.
     * 
     */
    public void setInitialPosition(int x, int y) {
    }

    /**
     * Method to draw the element on the screen
     *
     */
    public void draw() {

    }
    
    /**
     * Method to set the image's name
     *
     * @param name of the UI element image
     */
    public void setImageName(String imageName) {
        this.imageName = imageName;

    }
    
    /**
     * Method to set the image's name
     *
     * @return name of the UI element image
     */
    public String getImageName() {
        return this.imageName;

    }
}
