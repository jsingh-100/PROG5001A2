import java.awt.Graphics;
import java.awt.Image;
import java.util.concurrent.ThreadLocalRandom;

import javax.swing.ImageIcon;

/**
 * Class Prey represents any prey object.
 *
 * @author Jaspreet
 * @version 1.0.0
 */
public class JS_Prey extends JS_UIElement {
    
    public static boolean hasOne=false;
    public static int x;
    public static int y;
    /**
     * Constructor for objects of class JS_Prey
     */
    public JS_Prey(Graphics g)
    {
        if (!hasOne) {
        setRandomPosition(300, 300, 0, 0);
        hasOne=true;
        }
        this.g = g;
        imageName = "prey.jpg";
        ImageIcon icon = new ImageIcon("resources/"+imageName);
        Image image = icon.getImage();
        g.drawImage(image, x, y,xSize,ySize, this);

    }
    
    /**
     * Method to set the prey position to a random spot
     * 
     * @param Max X
     * @param Max Y
     * @param Min X
     * @param Min Y
     * 
     */
    private void setRandomPosition(int maxX,int maxY,int minX,int minY){
        x = ThreadLocalRandom.current().nextInt(minX, maxX + 1);
        y = ThreadLocalRandom.current().nextInt(minY, maxY + 1);
    }
    
    /**
     * Method to destroy the current prey
     */
    public void destroy(){}
}
