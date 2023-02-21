package com.potionquest.gui;


import javax.swing.*;
import java.awt.*;

public class WinLoseMessage {
    public static void main(String[] args) {
        createWindow();
    }

    private static void createWindow() {
        JFrame frame = new JFrame("WIN Tester");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        createUI(frame);
        frame.setSize(100, 100);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    private static void createUI(final JFrame frame){
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