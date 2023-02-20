package com.potionquest.gui;

import javax.swing.*;
import java.awt.*;
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

    public PotionQuestGUILogic() {
        initGui();
        frame.setVisible(true);
        //createWindow();  //Winners window if clicked it should start new game
        //code begins on line #31
    }

    public void initGui() {
    }
//
    //create a window saying winner
    private static void createWindow() {
        JFrame frame = new JFrame("WINNER!");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        createUI(frame);
        frame.setSize(100, 100);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    private static void createUI(final JFrame frame) {
        JPanel panel = new JPanel();
        LayoutManager layout = new FlowLayout();
        panel.setLayout(layout);
        JButton button = new JButton("You Win");
        button.addActionListener(e -> JOptionPane.showMessageDialog(frame, "CLICK to play again!!",
                "Play again", JOptionPane.QUESTION_MESSAGE));

        panel.add(button);
        frame.getContentPane().add(panel, BorderLayout.CENTER);
    }
}
