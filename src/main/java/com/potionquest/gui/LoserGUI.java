package com.potionquest.gui;

import com.potionquest.game.Game;
import com.potionquest.game.Timer;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class LoserGUI extends JFrame {
    JPanel titleNamePanel, descriptionPanel;
    JLabel titleNameLabel, timeLabel;
    JTextArea description;

    public LoserGUI() throws IOException {
        Game.getGameInstance().getPlayer().setCurrentLocation(Game.getLocations().get("Losing Message"));
        (new Thread(new Timer(System.currentTimeMillis(), 7L, 0L, 0L))).start();
        setTitle("Loser!");
        setSize(800,800);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        setResizable(false);

        PotionQuestImage backgroundImage = new PotionQuestImage("images/loser.jpg");
        backgroundImage.setBounds(0,0,this.getWidth(),this.getHeight());
        setContentPane(backgroundImage);

        // player info panel
        titleNamePanel = new JPanel();
        titleNamePanel.setBounds(0,0,800,100);
        titleNamePanel.setOpaque(false);


        // labels for display panel
        timeLabel = new JLabel("TIME: "+ Timer.getTimeRemainingMin()); //text label
        timeLabel.setForeground(Color.BLACK);// text color
        timeLabel.setFont(new Font("Comic Sans", Font.PLAIN,16));

        // titleName
        titleNameLabel = new JLabel("YOU LOSE!");
        titleNameLabel.setForeground(Color.BLUE);
        titleNameLabel.setBackground(Color.ORANGE);
        titleNameLabel.setOpaque(true);
        titleNameLabel.setFont(new Font("Arial",Font.BOLD,40));
        titleNameLabel.setHorizontalAlignment(SwingConstants.CENTER);
        titleNamePanel.add(titleNameLabel);

        // status labels

        description = new JTextArea("Your speed determined the outcome of you sister!");
        description.setForeground(Color.BLACK);
        description.setBackground(Color.ORANGE);
        description.setBounds(120,10,260,60);
        description.setFont(new Font("Comic Sans", Font.BOLD,16));
        description.setLineWrap(true);
        description.setWrapStyleWord(true);

        // creates panel for text area
        descriptionPanel = new JPanel();
        descriptionPanel.setBounds(0,100,800,150);
        descriptionPanel.setOpaque(false);
        descriptionPanel.add(description);


        // adds panel to the frame
        add(descriptionPanel);
        add(titleNamePanel);
        add(timeLabel);

        setVisible(false);
    }
}