package org.pixie.rs.client.game;

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
     * @return the games {@link java.lang.ClassLoader}.
     */
    public abstract ClassLoader getClassLoader();

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

    /**
     * Loads a class with the games {@link java.lang.ClassLoader}.
     * @param name the name of the class to be loaded.
     * @return <code>null</code> if it could not find the class else
     * it returns the {@link java.lang.Class} with the corresponding
     */
    public Class<?> loadClass(final String name) {
        try {
            return getClassLoader().loadClass(name);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

}
