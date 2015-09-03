package org.pixie.rs.client;

import org.pixie.rs.client.game.RS3Game;
import org.pixie.rs.client.visual.VisualManager;

import javax.swing.*;

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
    }

}
