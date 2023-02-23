package com.potionquest.gui;

import com.potionquest.game.Game;
import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.util.stream.Collectors;

public class RiverSouthGUI extends JFrame {
    JPanel titleNamePanel, footer,descriptionPanel,itemsAvailablePanel, movementPanel,pickAndDropPanel;
    JLabel titleNameLabel, timeLabel, inventoryLabel, healthLabel,itemsLabel;
    JButton northButton,westButton,pickButton,dropButton;
    JTextArea description;
    EventHandler eventHandler = new EventHandler();

    public RiverSouthGUI() throws IOException {
        Game.getGameInstance().getPlayer().setCurrentLocation(Game.getLocations().get("River South"));
        setTitle(Game.getGameInstance().getPlayer().getCurrentLocation().getName());
        setSize(800,800);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        setResizable(false);

        PotionQuestImage backgroundImage = new PotionQuestImage("images/riverSouth.jpg");
        backgroundImage.setBounds(0,0,this.getWidth(),this.getHeight());
        setContentPane(backgroundImage);

        // player info panel
        titleNamePanel = new JPanel();
        titleNamePanel.setBounds(0,0,800,100);
        titleNamePanel.setOpaque(false);

        itemsAvailablePanel = new JPanel();
        itemsAvailablePanel.setBounds(0,65,800,60);
        itemsAvailablePanel.setOpaque(false);

        itemsLabel = new JLabel("ITEMS AVAILABLE: "
                +Game.getGameInstance().getPlayer().getCurrentLocation().getItems().stream().map(p -> p.getName())
                .collect(Collectors.toList()));
        //text label
        itemsLabel.setForeground(Color.BLACK);// text color
        itemsLabel.setBackground(Color.ORANGE);
        itemsLabel.setOpaque(true);
        itemsLabel.setFont(new Font("Comic Sans", Font.BOLD,18));
        itemsAvailablePanel.add(itemsLabel);


        // labels for display panel
        timeLabel= Game.getGuiTimer().getTimeLabel();
        timeLabel.setForeground(Color.BLACK);// text color
        timeLabel.setFont(new Font("Comic Sans", Font.PLAIN,16));

        inventoryLabel = new JLabel("INVENTORY: "+Game.getGameInstance().getPlayer().getInventory().stream().map(p -> p.getName()).collect(Collectors.toList())); //text label

        inventoryLabel.setForeground(Color.BLACK);// text color
        inventoryLabel.setFont(new Font("Comic Sans", Font.PLAIN,16));

        healthLabel = new JLabel("HEALTH: "+Game.getGameInstance().getPlayer().getHealth()); //text label
        healthLabel.setForeground(Color.BLACK);// text color
        healthLabel.setFont(new Font("Comic Sans", Font.PLAIN,16));


        // titleName
        titleNameLabel = new JLabel(Game.getGameInstance().getPlayer().getCurrentLocation().getName());
        titleNameLabel.setForeground(Color.BLUE);
        titleNameLabel.setBackground(Color.ORANGE);
        titleNameLabel.setOpaque(true);
        titleNameLabel.setFont(new Font("Arial",Font.BOLD,40));
        titleNameLabel.setHorizontalAlignment(SwingConstants.CENTER);
        titleNamePanel.add(titleNameLabel);

        // status labels

        description = new JTextArea(Game.getGameInstance().getPlayer().getCurrentLocation().description());
        description.setForeground(Color.BLACK);
        description.setBackground(Color.ORANGE);
        description.setBounds(120,10,620,65);
        description.setFont(new Font("Comic Sans", Font.BOLD,16));
//        description.setOpaque(false);
        description.setLineWrap(true);
        description.setWrapStyleWord(true);

        // creates panel for text area
        descriptionPanel = new JPanel();
        descriptionPanel.setBounds(10,100,800,150);
        descriptionPanel.setOpaque(false);
        descriptionPanel.add(description);

        // footer for health and inventory
        footer = new JPanel();
        footer.setBounds(0,700,800,40);
        footer.setBackground(Color.ORANGE);
        footer.setLayout(new GridLayout(1, 3));
        footer.add(timeLabel);
        footer.add(inventoryLabel);
        footer.add(healthLabel);

        // movements
        movementPanel = new JPanel();
        movementPanel.setBounds(10, 500, 120, 80);
        movementPanel.setOpaque(false);
        movementPanel.setLayout(new GridLayout(2, 1));

        pickAndDropPanel=new JPanel();
        pickAndDropPanel.setBounds(500, 600, 220, 40);
        pickAndDropPanel.setOpaque(false);
        pickAndDropPanel.setLayout(new GridLayout(1, 2));

        pickButton = new JButton("PICK ITEM");
        pickButton.setForeground(Color.RED);
        pickButton.setActionCommand("pick-item-river-south");
        pickButton.addActionListener(eventHandler);


        dropButton = new JButton("DROP ITEM");
        dropButton.setForeground(Color.RED);
        dropButton.setActionCommand("drop-item-river-south");
        dropButton.addActionListener(eventHandler);

        pickAndDropPanel.add(pickButton);
        pickAndDropPanel.add(dropButton);

        northButton = new JButton("GO NORTH");
        northButton.setForeground(Color.RED);
        northButton.setActionCommand("river-south-north");
        //northButton.setBackground(Color.GREEN);

        northButton.addActionListener(eventHandler);

        westButton = new JButton("GO WEST");
        westButton.setForeground(Color.RED);
        westButton.setActionCommand("river-south-west");
        //westButton.setBackground(Color.GREEN);

        westButton.addActionListener(eventHandler);

        movementPanel.add(northButton);
        movementPanel.add(westButton);

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