package com.potionquest.gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class PotionQuestGUI extends JFrame{
    //creates window
    JFrame window;
    //creates container
    Container con;
    //creates the panel that our info sits in
    JPanel titleNamePanel, startButtonPanel, mainTextPanel;
    //creates label that lets you add text to panel
    JLabel titleNameLabel;
    //custom fonts
    Font titleFont = new Font("Times New Roman", Font.PLAIN, 50);
    Font normalFont = new Font("Times New Roman", Font.PLAIN, 30);
    //Creates button
    JButton startButton;
    //Text Area
    JTextArea mainTextArea;
    //event listener for title screen
    TitleScreenHandler tsHandler = new TitleScreenHandler();
    WhitbyVillageGUI whitByFrame = new WhitbyVillageGUI();

    public PotionQuestGUI() {

        //displays window
        window = new JFrame();
        window.setTitle("Team 5 Potion Quest Game");
        window.setSize(800, 800);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.getContentPane().setBackground(Color.BLACK);
        window.setLayout(null);

        //for background pics
//        PotionQuestImage backgroundImage = new PotionQuestImage("src/main/resources/images/home.jpg");
//        backgroundImage.setBounds(0,0,this.getWidth(),this.getHeight());
//        window.setContentPane(backgroundImage);



        con = window.getContentPane();

        //creates title to go in container(PANEL)
        titleNamePanel = new JPanel();
        titleNamePanel.setBounds(100, 100, 600, 150);
        titleNamePanel.setBackground(Color.BLACK);
        titleNameLabel = new JLabel("POTION QUEST");
        titleNameLabel.setForeground(Color.ORANGE);
        titleNameLabel.setFont(titleFont);


        //creates button to go in container(PANEL)
        startButtonPanel = new JPanel();
        startButtonPanel.setBounds(500, 620, 200, 100);
        startButtonPanel.setBackground(Color.BLACK);

        //gives button a title
        startButton = new JButton("START GAME");
        startButton.setBackground(Color.BLACK);
        startButton.setForeground(Color.GREEN);
        startButton.setFont(normalFont);

        //onClick will call tsHandler function
        startButton.addActionListener(tsHandler);

        titleNamePanel.add(titleNameLabel);
        startButtonPanel.add(startButton);

        //container adds the
        con.add(titleNamePanel);
        con.add(startButtonPanel);



        window.setVisible(true);
    }


//    =================================GAME SCREEN================================

    public void createGameScreen() {

        titleNamePanel.setVisible(false);
        startButtonPanel.setVisible(false);

        mainTextPanel = new JPanel();
        mainTextPanel.setBounds(100, 100, 600, 250);
        mainTextPanel.setBackground(Color.blue);
        con.add(mainTextPanel);

        mainTextArea = new JTextArea();
        mainTextArea.setBounds(100, 100, 600, 250);
        mainTextArea.setBackground(Color.BLACK);
        mainTextArea.setForeground(Color.WHITE);
        mainTextArea.setFont(normalFont);
        mainTextArea.setLineWrap(true);
        mainTextPanel.add(mainTextArea);


    }


    public class TitleScreenHandler implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            //once button is pressed the game will go to next page
            window.setVisible(false);
            whitByFrame.setVisible(true);
        }

    }

}
