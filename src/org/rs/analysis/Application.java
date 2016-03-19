package org.rs.analysis;

import org.rs.analysis.visual.VisualManager;
import org.rs.analysis.visual.controller.MainController;
import sun.applet.Main;

import java.awt.*;

/**
 * Project rsclient
 * Created by Francis on 24/08/2015.
 */
public class Application {

    public static void main(final String[] args) {
        /*final RS3Game game = new RS3Game();
        game.prepare();
        game.init();
        final JFrame frame = new JFrame();
        frame.getContentPane().add(game.getApplet());
        frame.pack();(*/
        VisualManager.init();
        VisualManager.getController(MainController.class).show();
    }

}
