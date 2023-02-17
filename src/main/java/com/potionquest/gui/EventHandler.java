package com.potionquest.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class EventHandler implements ActionListener {


    private static WhitbyVillageGUI whitByFrame;
    private static PotionQuestGUI potionQuestGUI;
    private static ForestGUI forestGUI;
    private static MountainPassGUI mountainPassGUI;
    static {
        try {
            whitByFrame = new WhitbyVillageGUI();
            potionQuestGUI = new PotionQuestGUI();
            mountainPassGUI = new MountainPassGUI();
            forestGUI = new ForestGUI();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public EventHandler() throws IOException {
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        String actionPerformedByUser = e.getActionCommand();

        if(actionPerformedByUser.equalsIgnoreCase("start")) {
            potionQuestGUI.setVisible(false);
            whitByFrame.setVisible(true);

            // make player's location is changed to forest location
        } else if(actionPerformedByUser.equalsIgnoreCase("north")) {
            whitByFrame.setVisible(false);
            forestGUI.setVisible(true);
        } else if(actionPerformedByUser.equalsIgnoreCase("south")) {
            whitByFrame.setVisible(false);
            mountainPassGUI.setVisible(true);
        }
    }

}
