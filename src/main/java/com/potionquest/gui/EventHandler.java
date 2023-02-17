package com.potionquest.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class EventHandler implements ActionListener {
    public EventHandler() throws IOException {
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        String actionPerformedByUser = e.getActionCommand();

        if(actionPerformedByUser.equalsIgnoreCase("start")) {

            PotionQuestGUI.actionForStartButton();

            // make player's location is changed to forest location
        } else if(actionPerformedByUser.equalsIgnoreCase("north")) {
            PotionQuestGUI.actionForNorthButton();

        } else if(actionPerformedByUser.equalsIgnoreCase("south")) {
            PotionQuestGUI.actionForSouthButton();

        }
    }

}
