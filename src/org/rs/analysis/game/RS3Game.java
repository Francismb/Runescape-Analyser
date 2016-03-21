package org.rs.analysis.game;

import org.rs.analysis.game.applet.RSAppletStub;
import org.rs.analysis.utility.http.GameCrawler;
import org.rs.analysis.utility.reflection.Reflection;

import java.applet.Applet;
import java.applet.AppletStub;
import java.lang.reflect.Field;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.Vector;

/**
 * Project rsclient
 * Created by Francis on 26/08/2015.
 *
 * This represents the RuneScape 3 game
 */
public class RS3Game extends Game {

    private Applet applet;
    private RSAppletStub stub;
    private ClassLoader classLoader;

    private static final String GAME_URL = "http://world2.runescape.com/";

    @Override
    public void prepare() {
        // Create a crawler and crawl for information
        final GameCrawler crawler = new GameCrawler(GAME_URL);
        crawler.crawl();

        try {
            // Create a class loader and create a new instance of the applet class
            final ClassLoader classLoader1 = new URLClassLoader(new URL[]{new URL(GAME_URL + crawler.archive)});
            final Class<?> clazz = classLoader1.loadClass(crawler.initialClass);
            applet = (Applet) clazz.newInstance();

            // Create an rs applet stub
            stub = new RSAppletStub(applet, GAME_URL, crawler.parameters);

            // Search through the applet class to find a field which contains the correct class loader
            for (final Field field : applet.getClass().getDeclaredFields()) {
                if (field.getType().equals(Class.class)) {
                    final Object game = Reflection.getValue(applet.getClass(), field, applet);
                    if (game != null) {
                        classLoader = game.getClass().getClassLoader();
                    }
                }
            }
        } catch (final Throwable t) {
            t.printStackTrace();
        }
    }

    @Override
    public Applet getApplet() {
        if (applet == null) {
            throw new NullPointerException("Applet has not been prepared");
        }
        return applet;
    }

    @Override
    public AppletStub getAppletStub() {
        if (stub == null) {
            throw new NullPointerException("Applet stub has not been prepared");
        }
        return stub;
    }

    @Override
    public Class<?> getClass(String name) {
        if (classLoader == null) {
            throw new NullPointerException("Game class loader has not been prepared");
        }
        try {
            return classLoader.loadClass(name);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Class<?>[] getClasses() {
        if (classLoader == null) {
            throw new NullPointerException("Game class loader has not been prepared");
        }
        // We find all the classes in a private vector inside the
        // class loader class which contains all the loaded classes
        final Vector<Class> classes = (Vector<Class>) Reflection.getValue(ClassLoader.class, "classes", classLoader);
        return classes.toArray(new Class[classes.size()]);
    }


}
