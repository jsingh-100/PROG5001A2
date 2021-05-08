/**
 * This class represents the game menu.
 *
 * @author Jaspreet
 * @version 1.0.1
 */
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

public class JS_GameMenu extends JPanel {    
    int xcells = 25;   
    int ycells = 30;
    int szcell = 10;  


    
    /**
     * Constructor for objects of class JS_GameBoard
     */   
    public JS_GameMenu() {
        setPreferredSize(new Dimension(xcells * szcell, ycells * szcell));        
        setBackground(Color.WHITE);
        setFocusable(true); 
        GridBagLayout gridBagLayout = new GridBagLayout();
        gridBagLayout.columnWidths = new int[]{55, 124, 10, 0};
        gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        gridBagLayout.columnWeights = new double[]{0.0, 1.0, 1.0, Double.MIN_VALUE};
        gridBagLayout.rowWeights = new double[]{1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, Double.MIN_VALUE};
        setLayout(gridBagLayout);
       
       JPanel topScorePanl = new JPanel();
       topScorePanl.setBorder(new LineBorder(Color.BLUE));
       topScorePanl.setBackground(Color.WHITE);
       GridBagConstraints gbc_topScorePanl = new GridBagConstraints();
       gbc_topScorePanl.anchor = GridBagConstraints.NORTH;
       gbc_topScorePanl.insets = new Insets(0, 0, 5, 5);
       gbc_topScorePanl.fill = GridBagConstraints.HORIZONTAL;
       gbc_topScorePanl.gridx = 1;
       gbc_topScorePanl.gridy = 1;
       add(topScorePanl, gbc_topScorePanl);
       
       JLabel topScore = new JLabel("TOP LAYER\u2019s SCORE");
       topScorePanl.add(topScore);
       
       JPanel currentScorePanl = new JPanel();
       currentScorePanl.setBackground(Color.WHITE);
       currentScorePanl.setBorder(new LineBorder(Color.BLUE));
       GridBagConstraints gbc_currentScorePanl = new GridBagConstraints();
       gbc_currentScorePanl.insets = new Insets(0, 0, 5, 5);
       gbc_currentScorePanl.fill = GridBagConstraints.BOTH;
       gbc_currentScorePanl.gridx = 1;
       gbc_currentScorePanl.gridy = 2;
       add(currentScorePanl, gbc_currentScorePanl);
       
       JLabel topScore_1 = new JLabel("CURRENT PLAYER SCORE");
       currentScorePanl.add(topScore_1);
       
       JLabel lblNewLabel = new JLabel("");
       lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
       ImageIcon icon = new ImageIcon(JS_GameMenu.class.getResource("/resources/snake_image.jpg"));
       Image img = icon.getImage() ;  
       Image newimg = img.getScaledInstance( 60, 60,  java.awt.Image.SCALE_SMOOTH ) ;  
       icon = new ImageIcon( newimg );
       lblNewLabel.setIcon(icon);
       GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
       gbc_lblNewLabel.weightx = 0.05;
       gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
       gbc_lblNewLabel.gridx = 1;
       gbc_lblNewLabel.gridy = 4;
       add(lblNewLabel, gbc_lblNewLabel);
       
       JPanel infoPanel = new JPanel();
       infoPanel.setBorder(new LineBorder(Color.BLUE));
       infoPanel.setBackground(Color.WHITE);
       GridBagConstraints gbc_infoPanel = new GridBagConstraints();
       gbc_infoPanel.insets = new Insets(0, 0, 5, 5);
       gbc_infoPanel.fill = GridBagConstraints.BOTH;
       gbc_infoPanel.gridx = 1;
       gbc_infoPanel.gridy = 6;
       add(infoPanel, gbc_infoPanel);
       GridBagLayout gbl_infoPanel = new GridBagLayout();
       gbl_infoPanel.columnWidths = new int[] {46};
       gbl_infoPanel.rowHeights = new int[] {0, 0};
       gbl_infoPanel.columnWeights = new double[]{0.0};
       gbl_infoPanel.rowWeights = new double[]{0.0, 0.0};
       infoPanel.setLayout(gbl_infoPanel);
       
       JLabel lbLabel = new JLabel("PROG5001: 2021");
       lbLabel.setHorizontalAlignment(SwingConstants.CENTER);
       GridBagConstraints gbc_lbLabel = new GridBagConstraints();
       gbc_lbLabel.fill = GridBagConstraints.HORIZONTAL;
       gbc_lbLabel.anchor = GridBagConstraints.NORTH;
       gbc_lbLabel.insets = new Insets(0, 0, 5, 5);
       gbc_lbLabel.gridx = 0;
       gbc_lbLabel.gridy = 0;
       infoPanel.add(lbLabel, gbc_lbLabel);
       
       JLabel Jaspreet = new JLabel("Jaspreet");
       Jaspreet.setHorizontalAlignment(SwingConstants.CENTER);
       GridBagConstraints gbc_Jaspreet = new GridBagConstraints();
       gbc_Jaspreet.fill = GridBagConstraints.HORIZONTAL;
       gbc_Jaspreet.insets = new Insets(0, 0, 0, 5);
       gbc_Jaspreet.anchor = GridBagConstraints.NORTH;
       gbc_Jaspreet.gridx = 0;
       gbc_Jaspreet.gridy = 1;
       infoPanel.add(Jaspreet, gbc_Jaspreet);
       
       JButton closeButton = new JButton("QUIT");
       closeButton.setForeground(Color.WHITE);
       closeButton.setBackground(new Color(65, 105, 225));
       GridBagConstraints gbc_closeButton = new GridBagConstraints();
       gbc_closeButton.fill = GridBagConstraints.HORIZONTAL;
       gbc_closeButton.insets = new Insets(0, 0, 5, 5);
       gbc_closeButton.gridx = 1;
       gbc_closeButton.gridy = 7;
       add(closeButton, gbc_closeButton);
       
 
       
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
    }
    
}
