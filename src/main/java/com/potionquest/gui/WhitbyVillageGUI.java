package com.potionquest.gui;

import javax.swing.*;
import java.awt.*;

public class WhitbyVillageGUI extends JFrame {

    JPanel titleNamePanel, footer,descriptionPanel,playerStatusDisplayPanel;
    JLabel titleNameLabel;
    JButton startButton;
    JTextArea description;
    Font titleFont = new Font("Times New Roman", Font.ROMAN_BASELINE,36);

    public static final Dimension ss = Toolkit.getDefaultToolkit().getScreenSize();
    public WhitbyVillageGUI() {
        setTitle("WhitbyVillage");
        setSize(800,800);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        setResizable(false);


        Image backgroundImage = new Image("src/main/resources/images/potionStarting.png");
        backgroundImage.setBounds(0,0,this.getWidth(),this.getHeight());
        setContentPane(backgroundImage);

        // player info panel
        titleNamePanel = new JPanel();
        titleNamePanel.setBounds(0,0,800,100);
        titleNamePanel.setOpaque(true);
//        titleNamePanel.setBackground(Color.BLUE);

        playerStatusDisplayPanel = new JPanel();
        playerStatusDisplayPanel.setBounds(0,50,800,50);
        playerStatusDisplayPanel.setBackground(Color.GREEN);

        // titleName
        titleNameLabel = new JLabel("WHITBY VILLAGE");
        titleNameLabel.setForeground(Color.ORANGE);
        titleNameLabel.setOpaque(true);
        titleNameLabel.setFont(new Font("Arial",Font.BOLD,40));
        titleNameLabel.setHorizontalAlignment(SwingConstants.CENTER);
        titleNamePanel.add(titleNameLabel);

        // status labels

        // textArea for text
        description = new JTextArea("Whitby is a quaint small village near a dense forest. A few homes" +
                "line in the outskirts of town with the village tavern in the middle. To the north of the village " +
                "there is a forest and to the south there is a Mountain Pass!");
        description.setForeground(Color.BLACK);
        description.setBounds(0,0,800,50);
        description.setFont(new Font("Comic Sans", Font.BOLD,16));
        description.setOpaque(true);
//        description.setBackground(Color.CYAN);
        description.setLineWrap(true);

        // creates panel for text area
        descriptionPanel = new JPanel();
        descriptionPanel.setBounds(0,100,800,100);
//        descriptionPanel.setBackground(Color.GREEN);
        descriptionPanel.add(description);

        // footer for health and inventory
        footer = new JPanel();
        footer.setBounds(0,700,800,100);
        footer.setBackground(Color.BLUE);



        // adds panel to the frame
        add(playerStatusDisplayPanel);
        add(descriptionPanel);
        add(titleNamePanel);
        add(footer);


        setVisible(false);
    }
}
