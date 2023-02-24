package com.potionquest.gui;

import com.potionquest.game.Game;
import com.potionquest.game.Timer;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.util.stream.Collectors;

public class MountainPassGUI extends JFrame {
    JPanel titleNamePanel, footer,descriptionPanel,itemsAvailablePanel, movementPanel,pickAndDropPanel,itemsDroppedPanel,itemsPickedPanel;
    JLabel titleNameLabel, timeLabel, inventoryLabel, healthLabel,itemsLabel,itemsPickedLabel,itemsDropLabel;
    JButton northButton,eastButton,pickButton,dropButton;
    JTextArea description;
    EventHandler eventHandler = new EventHandler();

    public static final Dimension ss = Toolkit.getDefaultToolkit().getScreenSize();
    public MountainPassGUI() throws IOException {
        Game.getGameInstance().getPlayer().setCurrentLocation(Game.getLocations().get("Mountain Pass"));

        setTitle(Game.getGameInstance().getPlayer().getCurrentLocation().getName());
        setSize(800,800);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        setResizable(false);

        PotionQuestImage backgroundImage = new PotionQuestImage("images/mountainPass.jpg");
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
        itemsLabel.setForeground(Color.BLACK);
        itemsLabel.setBackground(Color.ORANGE);
        itemsLabel.setOpaque(true);
        itemsLabel.setFont(new Font("Comic Sans", Font.BOLD,18));
        itemsAvailablePanel.add(itemsLabel);


        // labels for display panel
        timeLabel= Game.getGuiTimer().getTimeLabel();
        timeLabel.setForeground(Color.BLACK);
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
        pickButton.setActionCommand("pick-item-mountain-pass");
        pickButton.addActionListener(eventHandler);

        dropButton = new JButton("DROP ITEM");
        dropButton.setForeground(Color.RED);
        dropButton.setActionCommand("drop-item-mountain-pass");
        dropButton.addActionListener(eventHandler);

        pickAndDropPanel.add(pickButton);
        pickAndDropPanel.add(dropButton);

        northButton = new JButton("GO NORTH");
        northButton.setForeground(Color.RED);
        northButton.setActionCommand("mountain-north");
        northButton.addActionListener(eventHandler);

        eastButton = new JButton("GO EAST");
        eastButton.setForeground(Color.RED);
        eastButton.setActionCommand("mountain-east");
        eastButton.addActionListener(eventHandler);

        movementPanel.add(northButton);
        movementPanel.add(eastButton);

        // adds panel to the frame
        add(itemsAvailablePanel);
        add(descriptionPanel);
        add(titleNamePanel);
        add(footer);
        add(movementPanel);
        add(pickAndDropPanel);

        // itemsPickedPanel
        itemsPickedPanel = new JPanel();
        itemsPickedPanel.setBounds(0,280,800,50);
        itemsPickedPanel.setOpaque(false);

        itemsDroppedPanel = new JPanel();
        itemsDroppedPanel.setBounds(0,350,800,50);
        itemsDroppedPanel.setOpaque(false);

        add(itemsPickedPanel);
        add(itemsDroppedPanel);

        setVisible(false);
    }

    public void setItemsPickedLabel(String itemPickedName) {
        itemsPickedLabel = new JLabel("You picked "+ itemPickedName+"!");
        itemsPickedLabel.setFont(new Font("Comic Sans", Font.PLAIN,20));
        itemsPickedLabel.setForeground(Color.red);
        itemsPickedLabel.setOpaque(true);
        itemsPickedLabel.setHorizontalAlignment(SwingConstants.CENTER);
        itemsPickedPanel.add(itemsPickedLabel);
    }

    public void setItemsDroppedLabel(String itemDroppedName) {
        itemsDropLabel = new JLabel("You dropped "+itemDroppedName+"!");
        itemsDropLabel.setFont(new Font("Comic Sans", Font.PLAIN,20));
        itemsDropLabel.setForeground(Color.red);
        itemsDropLabel.setOpaque(true);
        itemsDropLabel.setHorizontalAlignment(SwingConstants.CENTER);
        itemsDroppedPanel.add(itemsDropLabel);
    }
}