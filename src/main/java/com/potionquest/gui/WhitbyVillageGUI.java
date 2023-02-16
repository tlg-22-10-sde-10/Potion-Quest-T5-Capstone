package com.potionquest.gui;

import com.potionquest.game.Game;
import com.potionquest.game.Location;
import com.potionquest.game.Player;
import com.potionquest.game.Timer;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.util.stream.Collectors;

public class WhitbyVillageGUI extends JFrame {
    JPanel titleNamePanel, footer,descriptionPanel,itemsAvailablePanel, movementPanel,pickAndDropPanel;
    JLabel titleNameLabel, timeLabel, inventoryLabel, healthLabel,itemsLabel;
    JButton northButton,eastButton,westButton,southButton,pickButton,dropButton;
    JTextArea description;
    Font titleFont = new Font("Times New Roman", Font.ROMAN_BASELINE,36);

    public static final Dimension ss = Toolkit.getDefaultToolkit().getScreenSize();
    public WhitbyVillageGUI() throws IOException {
        Game.createGameInstance();
        Game.getGameInstance().getPlayer().getCurrentLocation();

        (new Thread(new Timer(System.currentTimeMillis(), 7L, 0L, 0L))).start();
        setTitle(Game.getGameInstance().getPlayer().getCurrentLocation().getName());
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

        itemsAvailablePanel = new JPanel();
        itemsAvailablePanel.setBounds(0,50,800,40);
        itemsAvailablePanel.setBackground(Color.BLACK);

        itemsLabel = new JLabel("ITEMS AVAILABLE: "
                +Game.getGameInstance().getPlayer().getCurrentLocation().getItems().stream().map(p -> p.getName())
                .collect(Collectors.toList()));
        //text label
        itemsLabel.setForeground(Color.ORANGE);// text color
        itemsLabel.setFont(new Font("Comic Sans", Font.BOLD,16));
        itemsAvailablePanel.add(itemsLabel);


        // labels for display panel
        timeLabel = new JLabel("TIME: "+Timer.getTimeRemainingMin()); //text label
        timeLabel.setForeground(Color.RED);// text color
        timeLabel.setFont(new Font("Comic Sans", Font.BOLD,16));

        inventoryLabel = new JLabel("INVENTORY: "+Game.getGameInstance().getPlayer().getInventory()); //text label
        inventoryLabel.setForeground(Color.RED);// text color
        inventoryLabel.setFont(new Font("Comic Sans", Font.BOLD,16));

        healthLabel = new JLabel("HEALTH: "+Game.getGameInstance().getPlayer().getHealth()); //text label
        healthLabel.setForeground(Color.RED);// text color
        healthLabel.setFont(new Font("Comic Sans", Font.BOLD,16));


        // titleName
        titleNameLabel = new JLabel(Game.getGameInstance().getPlayer().getCurrentLocation().getName());
        titleNameLabel.setForeground(Color.ORANGE);
        titleNameLabel.setOpaque(true);
        titleNameLabel.setFont(new Font("Arial",Font.BOLD,40));
        titleNameLabel.setHorizontalAlignment(SwingConstants.CENTER);
        titleNamePanel.add(titleNameLabel);

        // status labels

        description = new JTextArea(Game.getGameInstance().getPlayer().getCurrentLocation().description());
        description.setForeground(Color.BLACK);
        description.setBounds(120,10,600,60);
        description.setFont(new Font("Comic Sans", Font.BOLD,16));
        description.setOpaque(false);
//        description.setBackground(Color.CYAN);
        description.setLineWrap(true);
        description.setWrapStyleWord(true);

        // creates panel for text area
        descriptionPanel = new JPanel();
        descriptionPanel.setBounds(0,100,800,150);
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
        movementPanel.setBounds(10, 500, 120, 80);
        movementPanel.setBackground(Color.BLACK);
        movementPanel.setLayout(new GridLayout(2, 1));

        pickAndDropPanel=new JPanel();
        pickAndDropPanel.setBounds(500, 600, 220, 40);
        pickAndDropPanel.setBackground(Color.BLACK);
        pickAndDropPanel.setLayout(new GridLayout(1, 2));

        pickButton = new JButton("PICK ITEM");
        pickButton.setBackground(Color.GREEN);
        pickButton.setForeground(Color.GREEN);
        pickButton.setActionCommand("west");

        dropButton = new JButton("DROP ITEM");
        dropButton.setForeground(Color.RED);
        dropButton.setActionCommand("north");
        dropButton.setBackground(Color.GREEN);

        pickAndDropPanel.add(pickButton);
        pickAndDropPanel.add(dropButton);

        westButton = new JButton("GO WEST");
        westButton.setBackground(Color.GREEN);
        westButton.setForeground(Color.ORANGE);
        westButton.setActionCommand("west");

        northButton = new JButton("GO NORTH");
        northButton.setForeground(Color.ORANGE);
        northButton.setActionCommand("north");
        northButton.setBackground(Color.GREEN);

        eastButton = new JButton("GO EAST");
        eastButton.setForeground(Color.ORANGE);
        eastButton.setActionCommand("east");
        eastButton.setBackground(Color.GREEN);

        southButton = new JButton("GO SOUTH");
        southButton.setForeground(Color.ORANGE);
        southButton.setActionCommand("south");
        southButton.setBackground(Color.GREEN);
        movementPanel.add(northButton);
        movementPanel.add(southButton);

        // adds panel to the frame
        add(itemsAvailablePanel);
        add(descriptionPanel);
        add(titleNamePanel);
        add(footer);
        add(movementPanel);
        add(pickAndDropPanel);
        setVisible(false);
    }
}