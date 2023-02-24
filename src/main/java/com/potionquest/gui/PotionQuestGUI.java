package com.potionquest.gui;

import com.potionquest.game.Game;
import com.potionquest.game.Item;
import com.potionquest.game.Monster;
import com.potionquest.game.Player;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;



public class PotionQuestGUI extends JFrame {
    //creates window
    static JFrame window;
    //creates container
    Container con;
    //creates the panel that our info sits in
    JPanel titleNamePanel, startButtonPanel, mainTextPanel;
    //creates label that lets you add text to panel
    JLabel titleNameLabel;
    //custom fonts
    Font titleFont = new Font("Times New Roman", Font.PLAIN, 50);
    Font normalFont = new Font("Times New Roman", Font.PLAIN, 30);
    //Creates button
    JButton startButton;
    //Text Area
    JTextArea mainTextArea;
    //event listener for title screen
    EventHandler eventHandler = new EventHandler();

    private static WhitbyVillageGUI whitByFrame;
    private static ForestGUI forestGUI;
    private static MountainPassGUI mountainPassGUI;
    private static RiverNorthGUI riverNorthGUI;
    private static RiverSouthGUI riverSouthGUI;
    private static LangtoftGUI langtoftGUI;
    private static WinnerGUI winnerGUI;
    private static GameLostGUI gameLostGUI;

    static {
        try {
            whitByFrame = new WhitbyVillageGUI();
            mountainPassGUI = new MountainPassGUI();
            forestGUI = new ForestGUI();
            riverNorthGUI = new RiverNorthGUI();
            riverSouthGUI = new RiverSouthGUI();
            langtoftGUI = new LangtoftGUI();
            winnerGUI = new WinnerGUI();
            gameLostGUI=new GameLostGUI();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public PotionQuestGUI() throws IOException {
        //displays window
        window = new JFrame();
        //displays window
        window.setTitle("Team 5 Potion Quest Game");
        window.setSize(800, 800);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.getContentPane().setBackground(Color.BLACK);
        window.setLayout(null);
        window.setLocationRelativeTo(null);
        window.setResizable(false);

        //for background pics
        PotionQuestImage backgroundImage = new PotionQuestImage("images/landing.jpg");
        backgroundImage.setBounds(0, 0, this.getWidth(), this.getHeight());
        window.setContentPane(backgroundImage);
        con = window.getContentPane();

        //creates title to go in container(PANEL)
        titleNamePanel = new JPanel();
        titleNamePanel.setOpaque(false);
        titleNameLabel = new JLabel("POTION QUEST");
        titleNamePanel.setBounds(100, 100, 600, 150);
        titleNamePanel.setOpaque(false);
        titleNameLabel.setForeground(Color.ORANGE);
        titleNameLabel.setFont(titleFont);

        //create story
        mainTextPanel = new JPanel();
        mainTextPanel.setBounds(40, 230, 700, 400);
        mainTextPanel.setOpaque(false);

        JTextArea mainText = new JTextArea(
                "This game will allow you to go on an adventure to get the potion to cure your sister!\n" +
                        "\nDuring the quest you will be faced with many choices and obstacles.\n" +
                        "\nChoose wisely ........\n" +
                        "\nYour life and your sister's life DEPENDS on it!\n" +
                        "\nComplete the quest by traveling to Langtoft Village\n" +
                        "\nand bringing back the potion to cure your sister's illness.\n" +
                        "\nYour game will end if your health goes to 0 or you do not complete \n" +
                        "\nthe quest in 7 minutes.");

        mainText.setFont(new Font("Comic Sans", Font.BOLD, 15));
        mainText.setForeground(Color.WHITE);
        mainText.setBackground(Color.orange);
        mainText.setOpaque(false);
        mainTextPanel.add(mainText, BorderLayout.CENTER);
        mainTextPanel.setFont(normalFont);


        //creates button to go in container(PANEL)
        startButtonPanel = new JPanel();
        startButtonPanel.setBounds(500, 620, 200, 100);
        startButtonPanel.setOpaque(false);

        //gives button a title
        startButton = new JButton("START GAME");
        startButton.setForeground(Color.RED);
        startButton.setBackground(Color.ORANGE);
        startButton.setOpaque(false);
        startButton.setFont(normalFont);

        //onClick will call tsHandler function
        startButton.addActionListener(eventHandler);
        startButton.setActionCommand("start");

        titleNamePanel.add(titleNameLabel);
        startButtonPanel.add(startButton);

        //container adds the
        con.add(titleNamePanel);
        con.add(mainTextPanel);
        con.add(startButtonPanel);
        window.setVisible(true);

    }


    public static void actionForStartButton() throws IOException {
        window.setVisible(false);
        Game.getGameInstance().getPlayer().setCurrentLocation(Game.getLocations().get("Whitby Village"));
        whitByFrame = new WhitbyVillageGUI();
        whitByFrame.setVisible(true);
    }

    public static void actionForWhitbyNorthButton() throws IOException {
        whitByFrame.setVisible(false);
        Game.getGameInstance().getPlayer().setCurrentLocation(Game.getLocations().get("Forest"));
        forestGUI = new ForestGUI();
        forestGUI.setVisible(true);
    }
    public static void actionForWhitbySouthButton() throws IOException {
        whitByFrame.setVisible(false);
        Game.getGameInstance().getPlayer().setCurrentLocation(Game.getLocations().get("Mountain Pass"));
        mountainPassGUI = new MountainPassGUI();
        mountainPassGUI.setVisible(true);
    }

    public static void actionForForestEast() throws IOException {
        forestGUI.setVisible(false);
        Game.getGameInstance().getPlayer().setCurrentLocation(Game.getLocations().get("River North"));
        riverNorthGUI = new RiverNorthGUI();
        riverNorthGUI.setVisible(true);
    }

    public static void actionForForestSouth() throws IOException {
        forestGUI.setVisible(false);
        Game.getGameInstance().getPlayer().setCurrentLocation(Game.getLocations().get("Whitby Village"));


        if (Game.getGameInstance().getPlayer().getInventory().contains(Game.getGameInstance().getItems().get("Potion"))) {
            if (Game.getGameInstance().getPlayer().getCurrentLocation().getName().equalsIgnoreCase("Whitby Village")) {
                winnerGUI.setVisible(true);
                GuiTimer.stopTimer();
            }
        } else {
            whitByFrame = new WhitbyVillageGUI();
            whitByFrame.setVisible(true);
        }

    }

    public static void actionForMountainPassNorth() throws IOException {
        mountainPassGUI.setVisible(false);
        Game.getGameInstance().getPlayer().setCurrentLocation(Game.getLocations().get("Whitby Village"));


        if (Game.getGameInstance().getPlayer().getInventory().contains(Game.getGameInstance().getItems().get("Potion"))) {
            if (Game.getGameInstance().getPlayer().getCurrentLocation().getName().equalsIgnoreCase("Whitby Village")) {
                GuiTimer.stopTimer();
                winnerGUI.setVisible(true);
            }
        } else {
            whitByFrame = new WhitbyVillageGUI();
            whitByFrame.setVisible(true);
        }
    }

    public static void actionForMountainPassEast() throws IOException {
        mountainPassGUI.setVisible(false);
        Game.getGameInstance().getPlayer().setCurrentLocation(Game.getLocations().get("River South"));
        riverSouthGUI = new RiverSouthGUI();
        riverSouthGUI.setVisible(true);
    }

    public static void actionForRiverSouthNorth() throws IOException {
        riverSouthGUI.setVisible(false);
        Game.getGameInstance().getPlayer().setCurrentLocation(Game.getLocations().get("Langtoft Village"));

        langtoftGUI = new LangtoftGUI();
        langtoftGUI.setVisible(true);

    }
    public static void actionForRiverSouthWest() throws IOException {
        riverSouthGUI.setVisible(false);
        Game.getGameInstance().getPlayer().setCurrentLocation(Game.getLocations().get("Mountain Pass"));
        mountainPassGUI = new MountainPassGUI();
        mountainPassGUI.setVisible(true);
    }

    // River North
    public static void actionForRiverNorthWest() throws IOException {
        riverNorthGUI.setVisible(false);
        Game.getGameInstance().getPlayer().setCurrentLocation(Game.getLocations().get("Forest"));
        forestGUI = new ForestGUI();
        forestGUI.setVisible(true);
    }
    public static void actionForRiverNorthSouth() throws IOException {
        riverNorthGUI.setVisible(false);
        Game.getGameInstance().getPlayer().setCurrentLocation(Game.getLocations().get("Langtoft Village"));
        langtoftGUI = new LangtoftGUI();
        langtoftGUI.setVisible(true);
    }
    // langtoft village
    public static void actionForLangtoftVillageNorth() throws IOException {
        langtoftGUI.setVisible(false);
        Game.getGameInstance().getPlayer().setCurrentLocation(Game.getLocations().get("River North"));
        riverNorthGUI = new RiverNorthGUI();
        riverNorthGUI.setVisible(true);

    }
    public static void actionForLangtoftVillageSouth() throws IOException {
        langtoftGUI.setVisible(false);
        Game.getGameInstance().getPlayer().setCurrentLocation(Game.getLocations().get("River South"));
        riverSouthGUI = new RiverSouthGUI();

        riverSouthGUI.setVisible(true);
    }

    public static void actionForPickItemWhitby() throws IOException {
        Game.getGameInstance().getPlayer().setCurrentLocation(Game.getLocations().get("Whitby Village"));

        if(Game.getGameInstance().getPlayer().getCurrentLocation().getItems().size()>0) {
            Item item = Game.getGameInstance().getPlayer().getCurrentLocation().getItems().get(0);
            Game.getGameInstance().getPlayer().getCurrentLocation().getItems().remove(item);
            Game.getGameInstance().getPlayer().getInventory().add(item);
            whitByFrame.setVisible(false);
            whitByFrame = new WhitbyVillageGUI();
            whitByFrame.setItemsPickedLabel((item.getName()));
            whitByFrame.setVisible(true);
        }
    }

    public static void actionForDropItemWhitby() throws IOException {
        Game.getGameInstance().getPlayer().setCurrentLocation(Game.getLocations().get("Whitby Village"));
        if(Game.getGameInstance().getPlayer().getInventory().size()>0) {
            Item item = Game.getGameInstance().getPlayer().getInventory().get(0);
            Game.getGameInstance().getPlayer().getInventory().remove(item);

            whitByFrame.setVisible(false);
            whitByFrame = new WhitbyVillageGUI();
            whitByFrame.setItemsDroppedLabel(item.getName());
            whitByFrame.setVisible(true);
        }

    }

    public static void actionForCombatWolf() throws IOException {
        Game.getGameInstance().getPlayer().setCurrentLocation(Game.getLocations().get("Forest"));

        if(!Game.getGameInstance().getPlayer().getCurrentLocation().getMonsters().isEmpty() &&Game.getGameInstance().getPlayer().getHealth()>20) {
            Monster monster = Game.getGameInstance().getPlayer().getCurrentLocation().getMonsters().get(0);
            Player player = Game.getGameInstance().getPlayer();

            int monsterHealth = monster.getHealth();
            int playerHealth = player.getHealth();

            player.setHealth(playerHealth-10);
            monster.setHealth(monsterHealth-10);

            if(monsterHealth <= 0) {
                Game.getGameInstance().getPlayer().getCurrentLocation().getMonsters().remove(0);
            }
        }

        forestGUI.setVisible(false);
        forestGUI = new ForestGUI();
        forestGUI.setVisible(true);
    }

    public static void actionForPickItemForest() throws IOException {

        Game.getGameInstance().getPlayer().setCurrentLocation(Game.getLocations().get("Forest"));
        if(Game.getGameInstance().getPlayer().getCurrentLocation().getItems().size()>0) {
            Item item = Game.getGameInstance().getPlayer().getCurrentLocation().getItems().get(0);
            Game.getGameInstance().getPlayer().getCurrentLocation().getItems().remove(item);
            Game.getGameInstance().getPlayer().getInventory().add(item);

            forestGUI.setVisible(false);
            forestGUI = new ForestGUI();
            forestGUI.setItemsPickedLabel(item.getName());
            forestGUI.setVisible(true);
        }

    }

    public static void actionForDropItemForest() throws IOException {
        Game.getGameInstance().getPlayer().setCurrentLocation(Game.getLocations().get("Whitby Village"));
        if(Game.getGameInstance().getPlayer().getInventory().size()>0) {
            Item item = Game.getGameInstance().getPlayer().getInventory().get(0);
            Game.getGameInstance().getPlayer().getInventory().remove(item);

            forestGUI.setVisible(false);
            forestGUI = new ForestGUI();
            forestGUI.setItemsDroppedLabel(item.getName());
            forestGUI.setVisible(true);
        }
    }

    public static void actionForPickItemMountainpass() throws IOException {
        Game.getGameInstance().getPlayer().setCurrentLocation(Game.getLocations().get("Mountain Pass"));

        if(Game.getGameInstance().getPlayer().getCurrentLocation().getItems().size()>0) {
            Item item = Game.getGameInstance().getPlayer().getCurrentLocation().getItems().get(0);
            Game.getGameInstance().getPlayer().getCurrentLocation().getItems().remove(item);
            Game.getGameInstance().getPlayer().getInventory().add(item);

            mountainPassGUI.setVisible(false);
            mountainPassGUI = new MountainPassGUI();
            mountainPassGUI.setItemsPickedLabel(item.getName());
            mountainPassGUI.setVisible(true);
        }
    }

    public static void actionForDropItemMountainpass() throws IOException {
        Game.getGameInstance().getPlayer().setCurrentLocation(Game.getLocations().get("Mountain Pass"));
        if(Game.getGameInstance().getPlayer().getInventory().size()>0) {
            Item item = Game.getGameInstance().getPlayer().getInventory().get(0);
            Game.getGameInstance().getPlayer().getInventory().remove(item);

            mountainPassGUI.setVisible(false);
            mountainPassGUI = new MountainPassGUI();
            mountainPassGUI.setItemsDroppedLabel(item.getName());
            mountainPassGUI.setVisible(true);
        }
    }

    public static void actionForPickItemLangtoft() throws IOException {
        Game.getGameInstance().getPlayer().setCurrentLocation(Game.getLocations().get("Langtoft Village"));

        if(Game.getGameInstance().getPlayer().getCurrentLocation().getItems().size()>0) {
            Item item = Game.getGameInstance().getPlayer().getCurrentLocation().getItems().get(0);
            Game.getGameInstance().getPlayer().getCurrentLocation().getItems().remove(item);
            Game.getGameInstance().getPlayer().getInventory().add(item);

            langtoftGUI.setVisible(false);
            langtoftGUI = new LangtoftGUI();
            langtoftGUI.setItemsPickedLabel(item.getName());
            langtoftGUI.setVisible(true);
        }

    }

    public static void actionForDropItemLangtoft() throws IOException {
        Game.getGameInstance().getPlayer().setCurrentLocation(Game.getLocations().get("Langtoft Village"));
        if(Game.getGameInstance().getPlayer().getInventory().size()>0) {
            Item item = Game.getGameInstance().getPlayer().getInventory().get(0);
            Game.getGameInstance().getPlayer().getInventory().remove(item);

            langtoftGUI.setVisible(false);
            langtoftGUI = new LangtoftGUI();
            langtoftGUI.setItemsDroppedLabel(item.getName());
            langtoftGUI.setVisible(true);
        }

    }

    public static void actionForPickItemRiverNorth() throws IOException {
        Game.getGameInstance().getPlayer().setCurrentLocation(Game.getLocations().get("River North"));

        if(Game.getGameInstance().getPlayer().getCurrentLocation().getItems().size()>0) {
            Item item = Game.getGameInstance().getPlayer().getCurrentLocation().getItems().get(0);
            Game.getGameInstance().getPlayer().getCurrentLocation().getItems().remove(item);
            Game.getGameInstance().getPlayer().getInventory().add(item);

            riverNorthGUI.setVisible(false);
            riverNorthGUI = new RiverNorthGUI();
            riverNorthGUI.setItemsPickedLabel(item.getName());
            riverNorthGUI.setVisible(true);
        }

    }

    public static void actionForDropItemRiverNorth() throws IOException {
        Game.getGameInstance().getPlayer().setCurrentLocation(Game.getLocations().get("River North"));
        if(Game.getGameInstance().getPlayer().getInventory().size()>0) {
            Item item = Game.getGameInstance().getPlayer().getInventory().get(0);
            Game.getGameInstance().getPlayer().getInventory().remove(item);

            riverNorthGUI.setVisible(false);
            riverNorthGUI = new RiverNorthGUI();
            riverNorthGUI.setItemsDroppedLabel(item.getName());
            riverNorthGUI.setVisible(true);
        }

    }

    public static void actionForPickItemRiverSouth() throws IOException {
        Game.getGameInstance().getPlayer().setCurrentLocation(Game.getLocations().get("River South"));


        if(Game.getGameInstance().getPlayer().getCurrentLocation().getItems().size()>0) {
            Item item = Game.getGameInstance().getPlayer().getCurrentLocation().getItems().get(0);
            Game.getGameInstance().getPlayer().getCurrentLocation().getItems().remove(item);
            Game.getGameInstance().getPlayer().getInventory().add(item);


            riverSouthGUI.setVisible(false);
            riverSouthGUI = new RiverSouthGUI();
            riverSouthGUI.setItemsPickedLabel(item.getName());
            riverSouthGUI.setVisible(true);
        }
    }

    public static void actionForDropItemRiverSouth() throws IOException {
        Game.getGameInstance().getPlayer().setCurrentLocation(Game.getLocations().get("River South"));
        if(Game.getGameInstance().getPlayer().getInventory().size()>0) {
            Item item = Game.getGameInstance().getPlayer().getInventory().get(0);
            Game.getGameInstance().getPlayer().getInventory().remove(item);

            riverSouthGUI.setVisible(false);
            riverSouthGUI = new RiverSouthGUI();
            riverSouthGUI.setItemsDroppedLabel(item.getName());
            riverSouthGUI.setVisible(true);
        }
    }



    public static void actionForEXitGame() throws IOException {
        Game.destroyGameInstance();
        System.exit(0);

    }

    public static void gameOverDueToRunningOutOfTime(){
        riverSouthGUI.setVisible(false);
        riverNorthGUI.setVisible(false);
        langtoftGUI.setVisible(false);
        mountainPassGUI.setVisible(false);
        forestGUI.setVisible(false);
        whitByFrame.setVisible(false);
        winnerGUI.setVisible(false);
        gameLostGUI.setVisible(true);
    }

    public static void actionForPlayAgain() throws IOException {
        winnerGUI.setVisible(false);
        Game.destroyGameInstance();
        Game.createGameInstance();
        window.setVisible(true);
    }

    public static void actionForPlayAgainForGameLost() throws IOException {
        gameLostGUI.setVisible(false);
        Game.destroyGameInstance();
        Game.createGameInstance();
        window.setVisible(true);
    }

    public static void stopSoundInP(){
        Game.getGameInstance().getSound().getClip().stop();
    }



}