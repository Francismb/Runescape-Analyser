package org.pixie.rs.client.visual;

import org.pixie.rs.client.visual.controller.Controller;
import org.pixie.rs.client.visual.controller.MainController;

import javax.swing.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Project JHook
 * Created by Francis on 5/01/2015.
 */
public class VisualManager {

    private static final Set<Controller> controllers = new HashSet<>();

    public static void init() {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            SwingUtilities.invokeAndWait(new Runnable() {
                @Override
                public void run() {
                    controllers.add(new MainController());
                }
            });
        } catch (final Throwable e) {
            e.printStackTrace();
        }
    }

    public static <T> T getController(final Class<T> clazz) {
        for (final Controller controller : controllers) {
            if (controller.getClass().equals(clazz)) {
                return (T) controller;
            }
        }
        return null;
    }
}
