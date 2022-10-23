package com.github.gqs.querysautoclicker.Controller;

import java.util.HashMap;
import java.util.Map;

interface IController {
}

public class ControllerRepository {
    private static final ControllerRepository instance = new ControllerRepository();

    private final Map<Class, IController> controllers;

    protected ControllerRepository() {
        this.controllers = new HashMap<>();
    }

    public static ControllerRepository getInstance() {
        return instance;
    }

    public void register(IController controller) {
        Class key = controller.getClass();

        if (!controllers.containsKey(key)) {
            controllers.put(key, controller);
        }
    }

    public IController getController(Class type) {
        return controllers.get(type);
    }
}