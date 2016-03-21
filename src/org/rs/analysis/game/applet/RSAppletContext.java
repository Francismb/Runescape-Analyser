package org.rs.analysis.game.applet;

import javax.imageio.ImageIO;
import java.applet.Applet;
import java.applet.AppletContext;
import java.applet.AudioClip;
import java.awt.*;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.*;

/**
 * Created by Francis on 20/03/16.
 */
public class RSAppletContext implements AppletContext {

    private final Applet applet;

    private final Map<String, Image> imageCache = new HashMap<>();
    private final Map<String, InputStream> inputCache = new HashMap<>();

    public RSAppletContext(final Applet applet) {
        this.applet = applet;
    }

    @Override
    public AudioClip getAudioClip(URL url) {
        return new RSAudioClip(url);
    }

    @Override
    public Image getImage(final URL imageUrl) {
        final String url = imageUrl.toString();
        if (imageCache.containsKey(url)) {
            return imageCache.get(url);
        }
        try {
            return imageCache.put(url, ImageIO.read(imageUrl));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Applet getApplet(String name) {
        return applet;
    }

    @Override
    public Enumeration<Applet> getApplets() {
        final Vector<Applet> applets = new Vector<>();
        applets.add(applet);
        return applets.elements();
    }

    @Override
    public void showDocument(URL url) {
        showDocument(url, "");
    }

    @Override
    public void showDocument(URL url, String target) {
        System.out.println("Showing document with url - " + url + " and target - " + target);
    }

    @Override
    public void showStatus(String status) {
        System.out.println("Showing status - " + status);
    }

    @Override
    public void setStream(String key, InputStream stream) throws IOException {
        inputCache.put(key, stream);
    }

    @Override
    public InputStream getStream(String key) {
        return inputCache.get(key);
    }

    @Override
    public Iterator<String> getStreamKeys() {
        return inputCache.keySet().iterator();
    }
}
