package com.potionquest.gui;


import javax.swing.*;
import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimerTask;

public class GuiTimer extends JFrame{

    private   JLabel timeLabel;



    public GuiTimer() {
        super("Countdown Timer");

        timeLabel = new JLabel();
        timeLabel.setFont(new Font("Comic Sans", Font.PLAIN,16));
        timeLabel.setHorizontalAlignment(SwingConstants.LEFT);

        add(timeLabel, BorderLayout.CENTER);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 100);
        setVisible(false);

        // Start the timer thread
        java.util.Timer timer=new java.util.Timer();
        timer.scheduleAtFixedRate(new Task(),0,1000);


    }


    private class Task extends TimerTask {

        private final long startTime = System.currentTimeMillis();

        @Override
        public void run() {
            long now = System.currentTimeMillis();
            long elapsed = now - startTime;
            int seconds = 7 * 60 - Math.round(elapsed / 1000.0F);
            int minutes = seconds / 60;
            seconds = seconds % 60;
            String timeString = String.format("%d:%02d", minutes, seconds);
            SwingUtilities.invokeLater(() -> timeLabel.setText("Time Left: "+timeString));


        }
    }
    public JLabel getTimeLabel() {
        return timeLabel;
    }

}
