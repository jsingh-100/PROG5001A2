import java.awt.EventQueue;
import javax.swing.JFrame;

public class JS_SnakeGame extends JFrame {

    public JS_SnakeGame(String gameTille) { 
        add(new JS_GameBoard());
        setTitle(gameTille);
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();        
    }
    
    public static void main(String[] args) {        
        EventQueue.invokeLater(() -> {
            //create the game with a game title as follow: The Snake Game (C) Your_Name
            JFrame sgame = new JS_SnakeGame("The Snake Game (C) Jaspreet");
            sgame.setVisible(true);
        });
    }
}
