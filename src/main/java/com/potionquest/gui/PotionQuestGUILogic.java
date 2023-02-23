package com.potionquest.gui;

import javax.sound.sampled.*;
import javax.swing.*;
import java.io.BufferedInputStream;
import java.io.IOException;

public class PotionQuestGUILogic {

    private static JFrame frame = null;

    static {
        try {
            frame = new PotionQuestGUI();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public PotionQuestGUILogic() throws IOException {
        //frame.setVisible(true);
    }

    public static void playAudio(String audioFile) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
        try (AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new BufferedInputStream(ClassLoader.getSystemResourceAsStream(audioFile)))) {
            Clip clip = AudioSystem.getClip();
            clip.open(audioInputStream);
            clip.start();
        }

    }


}
