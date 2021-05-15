import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 
 * @author Jaspreet
 * @version 1.0.1
 */
public class JS_PointArray {
    
    public static List<String> positions = new ArrayList<>();

    public JS_PointArray(int xPosition, int yPosition, int length, int xSize, int ySize) {
        if (!positions.isEmpty()) {
            return;
        }
        positions.add(0, xPosition+","+yPosition);
        for (int i = 1; i < length; i++) {
            int lastYPos = Integer.parseInt( positions.get(i-1).split(",")[1]);
            positions.add(i, xPosition+","+ (lastYPos+ySize));
        }
        
    }

    /**
     * get x,y locations of each snake bone
     * 
     * @return positions
     */
    public List<String> getPositions() {
        return positions;
    }
    
    

}
