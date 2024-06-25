package controller;

import model.GameOfLifeModel;
import view.GameOfLifeView;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameController {
    private GameOfLifeModel model;
    private GameOfLifeView view;
    private Timer timer;

    public GameController(GameOfLifeModel model, GameOfLifeView view) {
        this.model = model;
        this.view = view;
        this.timer = new Timer(100, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                model.update();
                view.refresh();
            }
        });

        view.setRunning(false);
    }

    public void start() {
        view.setRunning(true);
        timer.start();
    }

    public void stop() {
        view.setRunning(false);
        timer.stop();
    }
}
