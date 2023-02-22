package com.potionquest.gui;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class GameLostGUI extends JFrame{
    JPanel titleNamePanel, descriptionPanel,playAndQuitPanel;
    JLabel titleNameLabel, timeLabel;
    JButton playButton,exitButton;
    JTextArea description;
    EventHandler eventHandler = new EventHandler();

    public GameLostGUI() throws IOException {
        setTitle("Potion Quest");
        setSize(800,800);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        setResizable(false);

        PotionQuestImage backgroundImage = new PotionQuestImage("images/landing.jpg");
        backgroundImage.setBounds(0,0,this.getWidth(),this.getHeight());
        setContentPane(backgroundImage);

        // player info panel
        titleNamePanel = new JPanel();
        titleNamePanel.setBounds(10,0,800,100);
        titleNamePanel.setOpaque(false);


        // titleName
        titleNameLabel = new JLabel("Time is up.");
        titleNameLabel.setForeground(Color.RED);
        titleNameLabel.setBackground(Color.ORANGE);
        titleNameLabel.setOpaque(true);
        titleNameLabel.setFont(new Font("Arial",Font.BOLD,30));
        titleNameLabel.setHorizontalAlignment(SwingConstants.CENTER);
        titleNamePanel.add(titleNameLabel);

        // status labels

        description = new JTextArea("Time is up. Mission failed.");
        description.setForeground(Color.BLACK);
        description.setBackground(Color.ORANGE);
        description.setBounds(150,10,400,200);
        description.setFont(new Font("Comic Sans", Font.BOLD,16));
        description.setLineWrap(true);
        description.setWrapStyleWord(true);

        // creates panel for text area
        descriptionPanel = new JPanel();
        descriptionPanel.setBounds(0,400,800,200);
        descriptionPanel.setOpaque(false);
        descriptionPanel.add(description);

        // panel for quit and new game button
        playAndQuitPanel=new JPanel();
        playAndQuitPanel.setBounds(500, 600, 220, 40);
        playAndQuitPanel.setBackground(Color.BLACK);
        playAndQuitPanel.setLayout(new GridLayout(1, 2));

        playButton = new JButton("PLAY AGAIN");
        playButton.setBackground(Color.GREEN);
        playButton.setForeground(Color.GREEN);
        playButton.setActionCommand("play");
        playButton.addActionListener(eventHandler);

        exitButton = new JButton("EXIT");
        exitButton.setForeground(Color.RED);
        exitButton.setActionCommand("exit");
        exitButton.setBackground(Color.GREEN);
        exitButton.addActionListener(eventHandler);

        playAndQuitPanel.add(playButton);
        playAndQuitPanel.add(exitButton);

        // adds panel to the frame
        add(descriptionPanel);
        add(titleNamePanel);
        add(playAndQuitPanel);
        setVisible(false);
    }
}