package com.potionquest.gui;

<<<<<<< HEAD
import javax.swing.*;

public class PotionQuestGUI extends JFrame {

    PotionQuestGUI(){
        setTitle("Team 5 Potion Quest Game");
        setSize(900,700);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        setResizable(false);


        Images backgroundImage = new Images("IMG/blackjack-classic-background.jpeg");
        backgroundImage.setBounds(0,0,this.getWidth(),this.getHeight());
        setContentPane(backgroundImage);
    }

=======

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class PotionQuestGUI {
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

    public static void main(String[] args) {
        new PotionQuestGUI();
    }

    public PotionQuestGUI() {

        //displays window
        window = new JFrame();
        window.setSize(600, 400);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.getContentPane().setBackground(Color.BLACK);
        window.setLayout(null);
        window.setVisible(true);
        con = window.getContentPane();

        //creates title to go in container(PANEL)
        titleNamePanel = new JPanel();
        titleNamePanel.setBounds(100, 100, 600, 150);
        titleNamePanel.setBackground(Color.BLACK);
        titleNameLabel = new JLabel("POTION QUEST");
        titleNameLabel.setForeground(Color.white);
        titleNameLabel.setFont(titleFont);


        //creates button to go in container(PANEL)
        startButtonPanel = new JPanel();
        startButtonPanel.setBounds(300, 400, 200, 100);
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
        con.add(startButtonPanel);
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
            createGameScreen();


        }

    }
>>>>>>> 69b776c34da9fa2ab6dcd9c0c63aa632569ec7a0
}
