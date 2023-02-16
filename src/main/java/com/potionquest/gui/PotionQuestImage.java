package com.potionquest.gui;

import javax.swing.*;
import java.awt.*;
import java.awt.Image;

public class PotionQuestImage extends JPanel {

    private final Image image;
    public PotionQuestImage(String img){
        this.image = new ImageIcon(img).getImage();
        Dimension size = new Dimension(image.getWidth(null),image.getHeight(null));
        setSize(size);
        setLayout(null);
    }
    @Override
    public void paintComponent(Graphics g){
        g.drawImage(image,0,0,this.getWidth(),this.getHeight(),null);

    }

}