package com.potionquest.gui;
import com.potionquest.game.Game;
import com.potionquest.game.Location;

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
    static {
        try {
            whitByFrame = new WhitbyVillageGUI();
            mountainPassGUI = new MountainPassGUI();
            forestGUI = new ForestGUI();
            riverNorthGUI = new RiverNorthGUI();
            riverSouthGUI = new RiverSouthGUI();
            langtoftGUI = new LangtoftGUI();

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
        //titleNamePanel.setBackground(Color.BLACK);
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
        mainText.setOpaque(false);
        mainTextPanel.add(mainText, BorderLayout.CENTER);
        mainTextPanel.setFont(normalFont);


        //creates button to go in container(PANEL)
        startButtonPanel = new JPanel();

        startButtonPanel.setBounds(500, 620, 200, 100);

        startButtonPanel.setBackground(Color.BLACK);
        startButtonPanel.setOpaque(false);

        //gives button a title
        startButton = new JButton("START GAME");
        startButton.setBackground(Color.BLACK);
        startButton.setForeground(Color.GREEN);
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

    public static void actionForStartButton() {
        window.setVisible(false);
        whitByFrame.setVisible(true);
    }

    public static void actionForWhitbyNorthButton() {
        whitByFrame.setVisible(false);
        forestGUI.setVisible(true);
    }
    public static void actionForWhitbySouthButton() {
        whitByFrame.setVisible(false);
        mountainPassGUI.setVisible(true);
    }

    public static void actionForForestEast() {
        forestGUI.setVisible(false);
        riverNorthGUI.setVisible(true);
    }

    public static void actionForForestSouth() {
        forestGUI.setVisible(false);
        whitByFrame.setVisible(true);

    }

    public static void actionForMountainPassNorth() {
        mountainPassGUI.setVisible(false);
        whitByFrame.setVisible(true);

    }
    public static void actionForMountainPassEast() {
        mountainPassGUI.setVisible(false);
        riverSouthGUI.setVisible(true);
    }

    public static void actionForRiverSouthNorth() {
        riverSouthGUI.setVisible(false);
        langtoftGUI.setVisible(true);

    }
    public static void actionForRiverSouthWest() {
        riverSouthGUI.setVisible(false);
        mountainPassGUI.setVisible(true);
    }

    // River North
    public static void actionForRiverNorthWest() {
        riverNorthGUI.setVisible(false);
        forestGUI.setVisible(true);
    }
    public static void actionForRiverNorthSouth() {
        riverNorthGUI.setVisible(false);
        langtoftGUI.setVisible(true);
    }
    // langtoft village
    public static void actionForLangtoftVillageNorth() {
        langtoftGUI.setVisible(false);
        riverNorthGUI.setVisible(true);
    }
    public static void actionForLangtoftVillageSouth() {
        langtoftGUI.setVisible(false);
        riverSouthGUI.setVisible(true);
    }

}
