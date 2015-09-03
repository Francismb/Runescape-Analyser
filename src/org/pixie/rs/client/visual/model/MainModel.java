package org.pixie.rs.client.visual.model;


import org.pixie.rs.client.game.Game;
import org.pixie.rs.client.visual.VisualManager;
import org.pixie.rs.client.visual.controller.MainController;
import org.pixie.rs.client.visual.view.MainView;

/**
 * Project JHook
 * Created by Francis on 5/01/2015.
 */
public class MainModel extends Model<MainView, MainController> {

    public Game game;

    public MainModel(final MainController controller) {
        super(controller);
    }

}
