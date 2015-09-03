package org.pixie.rs.client.visual.view;

import org.pixie.rs.client.visual.controller.Controller;
import org.pixie.rs.client.visual.model.Model;

/**
 * Project JHook
 * Created by Francis on 5/01/2015.
 */
public abstract class View<M extends Model, C extends Controller> {

    public M model;
    public C controller;

    public View(final C controller) {
        this.controller = controller;
    }

    public abstract void init();

    public void link() {
        this.model = (M) controller.model;
    }
}
