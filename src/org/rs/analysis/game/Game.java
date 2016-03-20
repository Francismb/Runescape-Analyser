package org.rs.analysis.game;

import java.applet.Applet;
import java.applet.AppletStub;

/**
 * Project rsclient
 * Created by Francis on 24/08/2015.
 *
 * Game represents a game instance and serves
 * as the interface to keep this client generic
 */
public abstract class Game {

    /**
     * Prepares the game for execution
     */
    public abstract void prepare();

    /**
     * @return the games {@link java.applet.Applet}.
     */
    public abstract Applet getApplet();

    /**
     * @return the games {@link java.applet.AppletStub} stub
     * with information collected from the webpage.
     */
    public abstract AppletStub getAppletStub();

    /**
     * @return one of the games {@link Class}
     */
    public abstract Class<?> getClass(final String name);

    /**
     * @return all of the games {@link Class}es
     */
    public abstract Class<?>[] getClasses();

    /**
     * Initializes the applet and starts the game.
     */
    public void init() {
        final Applet applet = getApplet();
        final AppletStub stub = getAppletStub();
        if (applet == null) {
            throw new NullPointerException("Applet is null");
        }
        if (stub == null) {
            throw new NullPointerException("Applet stub is null");
        }

        /* Set the applet stub of the games applet */
        applet.setStub(getAppletStub());

        /* Start the applet */
        applet.init();
        applet.start();
    }

}
