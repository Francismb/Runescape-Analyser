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
        VisualManager.init();
        VisualManager.getController(MainController.class).show();
    }

}
