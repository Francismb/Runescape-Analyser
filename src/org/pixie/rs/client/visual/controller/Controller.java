package org.pixie.rs.client.visual.controller;


import org.pixie.rs.client.visual.model.Model;
import org.pixie.rs.client.visual.view.View;

/**
 * Project JHook
 * Created by Francis on 5/01/2015.
 */
public abstract class Controller<V extends View, M extends Model> {

    int b = 5;

    public V view;
    public M model;

    public Controller() {
        link();
    }

    public abstract void link();
    public abstract void init();
    public abstract void show();
    public abstract void hide();

    protected void set(final V view, final M model) {
        this.view = view;
        this.model = model;
        model.link();
        view.link();
    }
}
