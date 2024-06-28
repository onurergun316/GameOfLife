package view;

import model.GameOfLifeModel;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionListener;

public class GameOfLifeView {
    private final GamePanel gamePanel;
    private final JButton startButton;
    private final JButton stopButton;
    private final JButton generateButton;
    private final JLabel generationLabel;
    private boolean isRunning;

    public GameOfLifeView(GameOfLifeModel model, ActionListener startListener, ActionListener stopListener, ActionListener generateListener) {
        JFrame frame = new JFrame("Game of Life");
        JPanel contentPane = new JPanel(new BorderLayout());
        contentPane.setBorder(new EmptyBorder(10, 30, 0, 20));

        gamePanel = new GamePanel(model, this);
        startButton = new JButton("Start");
        stopButton = new JButton("Stop");
        generateButton = new JButton("Generate");
        generationLabel = new JLabel("Generation: 0");

        startButton.addActionListener(startListener);
        stopButton.addActionListener(stopListener);
        generateButton.addActionListener(generateListener);

        JPanel controlPanel = new JPanel();
        controlPanel.add(startButton);
        controlPanel.add(stopButton);
        controlPanel.add(generateButton);

        frame.setContentPane(contentPane);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());
        frame.add(gamePanel, BorderLayout.CENTER);
        frame.add(generationLabel, BorderLayout.NORTH);
        frame.add(controlPanel, BorderLayout.SOUTH);
        frame.pack();
        Dimension preferredSize = frame.getPreferredSize();
        frame.setSize(preferredSize.width + 10, preferredSize.height + 20);
        frame.setVisible(true);
        isRunning = false;
    }

    public void refresh() {
        gamePanel.repaint();
    }

    public boolean getRunning() {
        return isRunning;
    }

    public void setRunning(boolean isRunning) {
        this.isRunning = isRunning;
        startButton.setEnabled(!isRunning);
        stopButton.setEnabled(isRunning);
        generateButton.setEnabled(!isRunning);
    }

    public void updateGenerationLabel(int generationCount) {
        generationLabel.setText("Generation: " + generationCount);
    }
}
