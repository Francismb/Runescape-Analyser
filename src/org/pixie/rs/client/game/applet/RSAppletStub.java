package org.pixie.rs.client.game.applet;

import java.applet.AppletContext;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Map;

/**
 * Project rsclient
 * Created by Francis on 26/08/2015.
 */
public class RSAppletStub implements java.applet.AppletStub {

    private final String codebase;
    private final Map<String, String> parameters;

    public RSAppletStub(final String codebase, final Map<String, String> parameters) {
        this.codebase = codebase;
        this.parameters = parameters;
    }

    @Override
    public boolean isActive() {
        return true;
    }

    @Override
    public URL getDocumentBase() {
        try {
            System.out.println("");
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
        return null;
    }

    @Override
    public void appletResize(int width, int height) {

    }
}
