package org.rs.analysis.visual.model;


import org.rs.analysis.visual.controller.Controller;
import org.rs.analysis.visual.view.View;

/**
 * Project JHook
 * Created by Francis on 5/01/2015.
 */
public abstract class Model<V extends View, C extends Controller> {

    public V view;
    public C controller;

    public Model(final C controller) {
        this.controller = controller;
    }

    public void link() {
        this.view = (V) controller.view;
    }
}
