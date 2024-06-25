package view;

import model.GameOfLifeModel;

import javax.swing.*;
import java.awt.*;

public class GameOfLifeView {
    private JFrame frame;
    private GamePanel gamePanel;

    public GameOfLifeView(GameOfLifeModel model) {
        frame = new JFrame("Game of Life");
        gamePanel = new GamePanel(model);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());
        frame.add(gamePanel, BorderLayout.CENTER);
        frame.pack();
        frame.setVisible(true);
    }

    public void refresh() {
        gamePanel.repaint();
    }
}
