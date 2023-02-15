package gui;


import javax.swing.*;
import java.awt.*;
import javax.swing.JFrame;
import javax.swing.JPanel;



public class PotionQuestGUI {
    //creates window
    JFrame window;
    //creates container
    Container con;
    //creates the panel that our info sits in
    JPanel titleNamePanel, startButtonPanel;
    //creates label that lets you add text to panel
    JLabel titleNameLabel;
    //custom fonts
    Font titleFont = new Font("Times New Roman", Font.PLAIN,50);
    Font normalFont = new Font("Times New Roman", Font.PLAIN,30);
    //Creates button
    JButton startButton;

    public static void main(String[] args) {
        new PotionQuestGUI();
    }

    public PotionQuestGUI(){

        //displays window
        window = new JFrame();
        window.setSize(600,400);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.getContentPane().setBackground(Color.BLACK);
        window.setLayout(null);
        window.setVisible(true);
        con = window.getContentPane();

        //creates title to go in container(PANEL)
        titleNamePanel = new JPanel();
        titleNamePanel.setBounds(100,100,600,150);
        titleNamePanel.setBackground(Color.BLACK);
        titleNameLabel = new JLabel("POTION QUEST");
        titleNameLabel.setForeground(Color.white);
        titleNameLabel.setFont(titleFont);



        //creates button to go in container(PANEL)
        startButtonPanel = new JPanel();
        startButtonPanel.setBounds(300,400,200,100);
        startButtonPanel.setBackground(Color.BLACK);

        //gives button a title
        startButton = new JButton("START GAME");
        startButton.setBackground(Color.BLACK);
        startButton.setForeground(Color.WHITE);
        startButton.setFont(normalFont);


        titleNamePanel.add(titleNameLabel);
        startButtonPanel.add(startButton);

        //container adds the
        con.add(titleNamePanel);
        con.add(startButtonPanel);
//

    }

}
