package gui;


import javax.swing.*;
import java.awt.*;
import javax.swing.JFrame;
import javax.swing.JPanel;



public class PotionQuestGUI {
    JFrame window;
    Container con;
    JPanel titleNamePanel, startButtonPanel;
    JLabel titleNameLabel;
    Font titleFont = new Font("Times New Roman", Font.PLAIN,50);

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

        //gives gui a title
        titleNamePanel = new JPanel();
        titleNamePanel.setBounds(100,40,380,100);
        titleNamePanel.setBackground(Color.BLACK);
        titleNameLabel = new JLabel("POTION QUEST");
        titleNameLabel.setForeground(Color.white);
        titleNameLabel.setFont(titleFont);

        //creates button
//        startButtonPanel = new JPanel();
//        startButtonPanel.setBackground(Color.CYAN);



        titleNamePanel.add(titleNameLabel);
        con.add(titleNamePanel);
//        con.add(startButtonPanel);

    }

}
