package org.pixie.rs.client.game;

import org.pixie.rs.client.game.applet.RSAppletStub;
import org.pixie.rs.client.utility.http.GameCrawler;
import org.pixie.rs.client.utility.reflection.Reflection;

import java.applet.Applet;
import java.applet.AppletStub;
import java.lang.reflect.Field;
import java.net.URL;
import java.net.URLClassLoader;

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
    private GameCrawler crawler;

    private static final String GAME_URL = "http://world2.runescape.com/";

    @Override
    public void prepare() {
        /* Create a crawler and crawl for information */
        crawler = new GameCrawler(GAME_URL);
        crawler.crawl();

        /* Create an rs applet stub */
        stub = new RSAppletStub(GAME_URL, crawler.parameters);

        try {
            /* Create a class loader and create a new instance of the applet class */
            final ClassLoader classLoader1 = new URLClassLoader(new URL[]{new URL(GAME_URL + crawler.archive)});
            final Class<?> clazz = classLoader1.loadClass(crawler.initialClass);
            applet = (Applet) clazz.newInstance();
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
    public ClassLoader getClassLoader() {
        if (classLoader == null) {
            if (applet == null || stub == null) {
                throw new NullPointerException("Game class loader has not been prepared");
            }
            /* Search through the applet class to find a field which contains the correct class loader */
            for (final Field field : applet.getClass().getDeclaredFields()) {
                if (field.getType().equals(Class.class)) {
                    classLoader = ((Class) Reflection.getValue(applet.getClass(), field, applet)).getClassLoader();
                }
            }
        }
        return classLoader;
    }
}
