package view;

import model.GameOfLifeModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class GameOfLifeView {
    private JFrame frame;
    private GamePanel gamePanel;
    private JButton startButton;
    private JButton stopButton;
    private JButton generateButton;
    private boolean isRunning;

    public GameOfLifeView(GameOfLifeModel model, ActionListener startListener, ActionListener stopListener, ActionListener generateListener) {
        frame = new JFrame("Game of Life");
        gamePanel = new GamePanel(model, this);
        startButton = new JButton("Start");
        stopButton = new JButton("Stop");
        generateButton = new JButton("Generate");

        startButton.addActionListener(startListener);
        stopButton.addActionListener(stopListener);
        generateButton.addActionListener(generateListener);

        JPanel controlPanel = new JPanel();
        controlPanel.add(startButton);
        controlPanel.add(stopButton);
        controlPanel.add(generateButton);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());
        frame.add(gamePanel, BorderLayout.CENTER);
        frame.add(controlPanel, BorderLayout.SOUTH);
        frame.pack();
        frame.setVisible(true);
        isRunning = false;
    }

    public void refresh() {
        gamePanel.repaint();
    }

    public boolean isRunning() {
        return isRunning;
    }

    public void setRunning(boolean isRunning) {
        this.isRunning = isRunning;
        startButton.setEnabled(!isRunning);
        stopButton.setEnabled(isRunning);
        generateButton.setEnabled(!isRunning);
    }
}
