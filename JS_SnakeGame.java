import java.awt.EventQueue;
import java.awt.FlowLayout;

import javax.swing.JFrame;

public class JS_SnakeGame extends JFrame {

    public JS_SnakeGame(String gameTille) {
        getContentPane().setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
        add(new JS_GameBoard());
        add(new JS_GameMenu());
        setTitle(gameTille);
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();        

    }
    
    public static void main(String[] args) {        
        EventQueue.invokeLater(() -> {
            JFrame sgame = new JS_LoginForm();
            sgame.setVisible(true);
        });
    }
}
