package org.rs.analysis.game.applet;

import java.applet.Applet;
import java.applet.AppletContext;
import java.applet.AppletStub;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Map;

/**
 * Project rsclient
 * Created by Francis on 26/08/2015.
 */
public class RSAppletStub implements AppletStub {

    private RSAppletContext context;

    private final String codebase;
    private final Map<String, String> parameters;

    public RSAppletStub(final Applet applet, final String codebase, final Map<String, String> parameters) {
        this.codebase = codebase;
        this.parameters = parameters;
        this.context = new RSAppletContext(applet);
    }

    @Override
    public boolean isActive() {
        return true;
    }

    @Override
    public URL getDocumentBase() {
        try {
            return new URL(codebase);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public URL getCodeBase() {
        try {
            return new URL(codebase);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public String getParameter(final String name) {
        return parameters.get(name);
    }

    @Override
    public AppletContext getAppletContext() {
        return context;
    }

    @Override
    public void appletResize(int width, int height) {
    }
}
