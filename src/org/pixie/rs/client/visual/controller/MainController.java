package org.pixie.rs.client.visual.controller;

import org.pixie.rs.client.game.OSRSGame;
import org.pixie.rs.client.game.RS3Game;
import org.pixie.rs.client.visual.model.MainModel;
import org.pixie.rs.client.visual.view.MainView;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Project JHook
 * Created by Francis on 5/01/2015.
 */
public class MainController extends Controller<MainView, MainModel> {

    public MainController() {
        init();
    }

    @Override
    public void init() {
        view.init();
        show();
    }

    @Override
    public void link() {
        final MainView view = new MainView(this);
        final MainModel model = new MainModel(this);
        set(view, model);
    }

    @Override
    public void show() {
        view.frame.setVisible(true);
    }

    @Override
    public void hide() {
        view.frame.setVisible(false);
    }

    public final ActionListener rs3Action = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            model.game = new RS3Game();
            model.game.prepare();
            model.game.init();
            view.frame.add(model.game.getApplet());
            view.frame.pack();
        }
    };

    public final ActionListener osrsAction = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            model.game = new OSRSGame();
        }
    };

}
