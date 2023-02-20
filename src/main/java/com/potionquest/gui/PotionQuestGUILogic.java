package com.potionquest.gui;

import com.potionquest.game.Game;

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
        initGui();
        frame.setVisible(true);
    }

    public void initGui() throws IOException {
        Game.checkPlayerWinStatus(Game.getGameInstance().getPlayer().getInventory(), Game.getGameInstance().getPlayer().getCurrentLocation());

    }
}
