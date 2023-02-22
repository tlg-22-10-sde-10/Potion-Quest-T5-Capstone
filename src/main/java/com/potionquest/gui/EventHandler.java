package com.potionquest.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import static com.potionquest.gui.PotionQuestGUILogic.playAudio;

public class EventHandler implements ActionListener {
    public EventHandler() throws IOException {
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        String actionPerformedByUser = e.getActionCommand();



        if(actionPerformedByUser.equalsIgnoreCase("start")) {

            try {
                PotionQuestGUI.actionForStartButton();
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }

        } else if(actionPerformedByUser.equalsIgnoreCase("north")) {
            try {
                PotionQuestGUI.actionForWhitbyNorthButton();
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }

        } else if(actionPerformedByUser.equalsIgnoreCase("south")) {
            try {
                PotionQuestGUI.actionForWhitbySouthButton();
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }

        }else if(actionPerformedByUser.equalsIgnoreCase("forest-south")) {
            try {
                PotionQuestGUI.actionForForestSouth();
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }

        }else if(actionPerformedByUser.equalsIgnoreCase("forest-east")) {
            try {
                PotionQuestGUI.actionForForestEast();
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }

        }else if(actionPerformedByUser.equalsIgnoreCase("langtoft-north")) {
            try {
                PotionQuestGUI.actionForLangtoftVillageNorth();
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }

        }else if(actionPerformedByUser.equalsIgnoreCase("langtoft-south")) {
            try {
                PotionQuestGUI.actionForLangtoftVillageSouth();
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }

        }else if(actionPerformedByUser.equalsIgnoreCase("mountain-north")) {
            try {
                PotionQuestGUI.actionForMountainPassNorth();
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }

        }else if(actionPerformedByUser.equalsIgnoreCase("mountain-east")) {
            try {
                PotionQuestGUI.actionForMountainPassEast();
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }

        }else if(actionPerformedByUser.equalsIgnoreCase("river-south-north")) {
            try {
                PotionQuestGUI.actionForRiverSouthNorth();
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }

        }else if(actionPerformedByUser.equalsIgnoreCase("river-south-west")) {
            try {
                PotionQuestGUI.actionForRiverSouthWest();
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }

        }else if(actionPerformedByUser.equalsIgnoreCase("river-north-south")) {
            try {
                PotionQuestGUI.actionForRiverNorthSouth();
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }

        }else if(actionPerformedByUser.equalsIgnoreCase("river-north-west")) {
            try {
                PotionQuestGUI.actionForRiverNorthWest();
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }

        }else if(actionPerformedByUser.equalsIgnoreCase("pick-whitby")) {
            try {
                PotionQuestGUI.actionForPickItemWhitby();
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }

        }else if(actionPerformedByUser.equalsIgnoreCase("drop-whitby")) {
            try {
                PotionQuestGUI.actionForDropItemWhitby();
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }

        }else if(actionPerformedByUser.equalsIgnoreCase("pick-item-langtoft")) {

            try {
                PotionQuestGUI.actionForPickItemLangtoft();
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }


        }else if(actionPerformedByUser.equalsIgnoreCase("drop-item-langtoft")) {

            try {
                PotionQuestGUI.actionForDropItemLangtoft();
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }


        }else if(actionPerformedByUser.equalsIgnoreCase("fight-wolf")) {

            try {
                PotionQuestGUI.actionForCombatWolf();
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }


        }else if(actionPerformedByUser.equalsIgnoreCase("drop-item-forest")) {

            try {
                PotionQuestGUI.actionForDropItemForest();
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }

        }else if(actionPerformedByUser.equalsIgnoreCase("pick-item-forest")) {
            try {
                PotionQuestGUI.actionForPickItemForest();
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }

        }else if(actionPerformedByUser.equalsIgnoreCase("pick-item-mountain-pass")) {

            try {
                PotionQuestGUI.actionForPickItemMountainpass();
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }


        }else if(actionPerformedByUser.equalsIgnoreCase("drop-item-mountain-pass")) {

            try {
                PotionQuestGUI.actionForDropItemMountainpass();
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }

        }else if(actionPerformedByUser.equalsIgnoreCase("pick-item-river-north")) {

            try {
                PotionQuestGUI.actionForPickItemRiverNorth();
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }

        }else if(actionPerformedByUser.equalsIgnoreCase("drop-item-river-north")) {
            try {
                PotionQuestGUI.actionForDropItemRiverNorth();
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        }else if(actionPerformedByUser.equalsIgnoreCase("pick-item-river-south")) {
            try {
                PotionQuestGUI.actionForPickItemRiverSouth();
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }

        }else if(actionPerformedByUser.equalsIgnoreCase("drop-item-river-south")) {
            try {
                PotionQuestGUI.actionForDropItemRiverSouth();
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        }else if(actionPerformedByUser.equalsIgnoreCase("play")) {

            try {
                PotionQuestGUI.actionForPlayAgain();
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }

        }else if(actionPerformedByUser.equalsIgnoreCase("exit")) {

            try {
                PotionQuestGUI.actionForEXitGame();
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }

        }else if(actionPerformedByUser.equalsIgnoreCase("play-loser")) {

            try {
                PotionQuestGUI.actionForPlayAgainForGameLost();
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }

        }

    }

}
