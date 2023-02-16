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

   // public static void main(String[] args) {
//        new PotionQuestGUI();
//    }

    public PotionQuestGUI() {

        //displays window
        window = new JFrame();
        window.setTitle("Team 5 Potion Quest Game");
        window.setSize(1280, 1024);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //for background pics
        PotionQuestImage backgroundImage = new PotionQuestImage("src/main/resources/images/landing.jpg");
        backgroundImage.setBounds(0,0,this.getWidth(),this.getHeight());
        window.setContentPane(backgroundImage);

        window.getContentPane().setBackground(Color.BLACK);
        window.setLayout(null);

        con = window.getContentPane();

        //creates title to go in container(PANEL)
        titleNamePanel = new JPanel();
        titleNamePanel.setBounds(200, 100, 800, 150);


        titleNamePanel.setOpaque(false);
        titleNameLabel = new JLabel("  WELCOME TO POTION QUEST");
        titleNameLabel.setForeground(Color.white);
        titleNameLabel.setFont(titleFont);

        //create story
        mainTextPanel=new JPanel();
        mainTextPanel.setBounds(200, 200, 1000, 800);
        mainTextPanel.setForeground(Color.white);
        mainTextPanel.setFont(normalFont);
        JTextArea mainText=new JTextArea("This game will allow you to go on an adventure to get the potion to cure your sister!\n" +
                "During the quest you will be faced with many choices and obstacles.\n" +
                "Choose wisely ........\n" +
                "Your life and your sister's life DEPENDS on it!\n" +
                "Complete the quest by traveling to Langtoft Village\n" +
                "and bringing back the potion to cure your sister's illness.\n" +
                "Your game will end if your health goes to 0 or you do not complete the quest in 7 minutes.");
        mainTextPanel.add(mainText,BorderLayout.CENTER);
        mainTextPanel.setOpaque(false);



        //creates button to go in container(PANEL)
        startButtonPanel = new JPanel();
        startButtonPanel.setBounds(300, 800, 200, 100);
        startButtonPanel.setBackground(Color.BLACK);

        //gives button a title
        startButton = new JButton("START GAME");
        startButton.setBackground(Color.BLACK);
        startButton.setForeground(Color.WHITE);
        startButton.setFont(normalFont);
        //onClick will call tsHandler function
        startButton.addActionListener(tsHandler);

        titleNamePanel.add(titleNameLabel);
        startButtonPanel.add(startButton);

        //container adds the
        con.add(titleNamePanel);
        con.add(mainTextPanel);
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

        //comment for pushing

    }


    public class TitleScreenHandler implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            //once button is pressed the game will go to next page
            window.setVisible(false);
            whitByFrame.setVisible(true);
        }

    }

}
