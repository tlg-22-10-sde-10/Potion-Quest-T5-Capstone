package com.potionquest.client;

import com.potionquest.controller.UserInputParser;
import com.potionquest.game.Game;
import com.potionquest.gui.PotionQuestGUILogic;

import java.io.IOException;

public class PotionQuestApplication implements Runnable {

    public static void main(String[] args) throws IOException {
        new Thread(new PotionQuestApplication()).start();

    }
    @Override
    public void run() {
        try {
           PotionQuestGUILogic potionQuestGUILogic = new PotionQuestGUILogic();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
