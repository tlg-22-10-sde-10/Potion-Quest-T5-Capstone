package com.potionquest.client;

import com.potionquest.gui.PotionQuestGUILogic;

public class PotionQuestApplication implements Runnable {



    public static void main(String[] args) {

        new Thread(new PotionQuestApplication()).start();

    }

    @Override
    public void run() {
        PotionQuestGUILogic potionQuestGUILogic = new PotionQuestGUILogic();
    }
}
