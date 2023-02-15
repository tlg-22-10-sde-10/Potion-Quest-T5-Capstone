package com.potionquest.gui;

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

}
