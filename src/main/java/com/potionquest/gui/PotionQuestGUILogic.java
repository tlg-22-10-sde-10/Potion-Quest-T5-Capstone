package com.potionquest.gui;

import javax.swing.*;
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
        frame.setVisible(true);
    }

}
