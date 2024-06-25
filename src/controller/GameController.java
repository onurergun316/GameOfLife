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
    }

    public void start() {
        timer.start();
    }

    public void stop() {
        timer.stop();
    }
}
