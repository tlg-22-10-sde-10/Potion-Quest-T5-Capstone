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
            PotionQuestGUI.actionForWhitbyNorthButton();

        } else if(actionPerformedByUser.equalsIgnoreCase("south")) {
            PotionQuestGUI.actionForWhitbySouthButton();

        }else if(actionPerformedByUser.equalsIgnoreCase("forest-south")) {
            PotionQuestGUI.actionForForestSouth();

        }else if(actionPerformedByUser.equalsIgnoreCase("forest-east")) {
            PotionQuestGUI.actionForForestEast();

        }else if(actionPerformedByUser.equalsIgnoreCase("langtoft-north")) {
            PotionQuestGUI.actionForLangtoftVillageNorth();

        }else if(actionPerformedByUser.equalsIgnoreCase("langtoft-south")) {
            PotionQuestGUI.actionForLangtoftVillageSouth();

        }else if(actionPerformedByUser.equalsIgnoreCase("mountain-north")) {
            PotionQuestGUI.actionForMountainPassNorth();

        }else if(actionPerformedByUser.equalsIgnoreCase("mountain-east")) {
            PotionQuestGUI.actionForMountainPassEast();

        }else if(actionPerformedByUser.equalsIgnoreCase("river-south-north")) {
            PotionQuestGUI.actionForRiverSouthNorth();

        }else if(actionPerformedByUser.equalsIgnoreCase("river-south-west")) {
            PotionQuestGUI.actionForRiverSouthWest();

        }else if(actionPerformedByUser.equalsIgnoreCase("river-north-south")) {
            PotionQuestGUI.actionForRiverNorthSouth();

        }else if(actionPerformedByUser.equalsIgnoreCase("river-north-west")) {
            PotionQuestGUI.actionForRiverNorthWest();

        }
    }

}
