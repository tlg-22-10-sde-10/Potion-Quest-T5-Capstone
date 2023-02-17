package com.potionquest.gui;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.Image;
import java.io.IOException;
import java.io.InputStream;

public class PotionQuestImage extends JPanel {

    private final Image image;

    public PotionQuestImage(String img) {
        try (InputStream inputStream = getClass().getClassLoader().getResourceAsStream(img)) {
            image = ImageIO.read(inputStream);
            Dimension size = new Dimension(image.getWidth(null), image.getHeight(null));
            setSize(size);
            setLayout(null);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public void paintComponent(Graphics g) {
        g.drawImage(image, 0, 0, this.getWidth(), this.getHeight(), null);

    }

}
