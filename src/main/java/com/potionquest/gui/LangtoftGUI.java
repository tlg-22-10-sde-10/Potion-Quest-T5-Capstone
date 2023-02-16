package com.potionquest.gui;

import javax.swing.*;
import java.awt.*;

public class LangtoftGUI extends JFrame {
    JPanel titleNamePanel, footer,descriptionPanel,itemsAvailablePanel, movementPanel;
    JLabel titleNameLabel, timeLabel, inventoryLabel, healthLabel,itemsLabel;
    JButton northButton,eastButton,westButton,southButton;
    JTextArea description;
    Font titleFont = new Font("Times New Roman", Font.ROMAN_BASELINE,36);

    public static final Dimension ss = Toolkit.getDefaultToolkit().getScreenSize();
    public LangtoftGUI() {
        setTitle("LANGTOFT VILLAGE");
        setSize(800,800);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        setResizable(false);

        PotionQuestImage backgroundImage = new PotionQuestImage("src/main/resources/images/potionStarting.png");
        backgroundImage.setBounds(0,0,this.getWidth(),this.getHeight());
        setContentPane(backgroundImage);

        // player info panel
        titleNamePanel = new JPanel();
        titleNamePanel.setBounds(0,0,800,100);
        titleNamePanel.setOpaque(true);
//        titleNamePanel.setBackground(Color.BLUE);

        itemsAvailablePanel = new JPanel();
        itemsAvailablePanel.setBounds(0,50,800,40);
        itemsAvailablePanel.setBackground(Color.BLACK);

        itemsLabel = new JLabel("ITEMS AVAILABLE: "+"{Sword, Trinket, Bread, Potion}"); //text label
        itemsLabel.setForeground(Color.GREEN);// text color
        itemsLabel.setFont(new Font("Comic Sans", Font.BOLD,16));
        itemsAvailablePanel.add(itemsLabel);


        // labels for display panel
        timeLabel = new JLabel("TIME: "+"07:00:00"); //text label
        timeLabel.setForeground(Color.RED);// text color
        timeLabel.setFont(new Font("Comic Sans", Font.BOLD,16));

        inventoryLabel = new JLabel("INVENTORY: "+"{rope}"); //text label
        inventoryLabel.setForeground(Color.RED);// text color
        inventoryLabel.setFont(new Font("Comic Sans", Font.BOLD,16));

        healthLabel = new JLabel("HEALTH: "+"91/100"); //text label
        healthLabel.setForeground(Color.RED);// text color
        healthLabel.setFont(new Font("Comic Sans", Font.BOLD,16));



        // titleName
        titleNameLabel = new JLabel("LANGTOFT VILLAGE");
        titleNameLabel.setForeground(Color.ORANGE);
        titleNameLabel.setOpaque(true);
        titleNameLabel.setFont(new Font("Arial",Font.BOLD,40));
        titleNameLabel.setHorizontalAlignment(SwingConstants.CENTER);
        titleNamePanel.add(titleNameLabel);

        // status labels

        // textArea for text
        description = new JTextArea("More to come");
        description.setForeground(Color.BLACK);
        description.setBounds(120,10,600,60);
        description.setFont(new Font("Comic Sans", Font.BOLD,16));
        description.setOpaque(false);
//        description.setBackground(Color.CYAN);
        description.setLineWrap(true);
        description.setWrapStyleWord(true);

        // creates panel for text area
        descriptionPanel = new JPanel();
        descriptionPanel.setBounds(0,100,800,90);
//        descriptionPanel.setBackground(Color.GREEN);
        descriptionPanel.add(description);

        // footer for health and inventory
        footer = new JPanel();
        footer.setBounds(0,700,800,40);
        footer.setBackground(Color.BLUE);
        footer.setLayout(new GridLayout(1, 3));
        footer.add(timeLabel);
        footer.add(inventoryLabel);
        footer.add(healthLabel);

        // movements
        movementPanel = new JPanel();
        movementPanel.setBounds(10, 500, 200, 180);
        movementPanel.setBackground(Color.BLACK);
        movementPanel.setLayout(new GridLayout(2, 1));

        northButton = new JButton("GO NORTH");
        northButton.setForeground(Color.ORANGE);
        northButton.setActionCommand("north");
        northButton.setBackground(Color.GREEN);

        southButton = new JButton("GO SOUTH");
        southButton.setForeground(Color.ORANGE);
        southButton.setActionCommand("south");
        southButton.setBackground(Color.GREEN);

        //Move to location buttons
        movementPanel.add(northButton);
        movementPanel.add(southButton);


        // adds panel to the frame
        add(itemsAvailablePanel);
        add(descriptionPanel);
        add(titleNamePanel);
        add(footer);
        add(movementPanel);
        setVisible(false);
    }
}
