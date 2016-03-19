package org.rs.analysis.visual.model;


import org.rs.analysis.game.Game;
import org.rs.analysis.visual.controller.MainController;
import org.rs.analysis.visual.view.MainView;

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
