// Copyright© by getQueryString/Fin

package com.github.gqs.querysautoclicker.Main.JNativeHook;

import com.github.gqs.querysautoclicker.Controller.AutoClickerItemsController;
import com.github.gqs.querysautoclicker.Controller.ControllerRepository;
import com.github.gqs.querysautoclicker.Main.Settings.Disable;
import com.github.gqs.querysautoclicker.Main.Auto.AutoClicker;
import com.github.kwhat.jnativehook.mouse.NativeMouseEvent;
import com.github.kwhat.jnativehook.mouse.NativeMouseInputListener;

public class GlobalMouseListener implements NativeMouseInputListener {

    AutoClickerItemsController aCIC = (AutoClickerItemsController) ControllerRepository.getInstance().getController(AutoClickerItemsController.class);

    @Override
    public void nativeMouseClicked(NativeMouseEvent nME) {
        if (AutoClicker.isPickClickPositionEnabled()) {
            Disable.pickClickPosition();

            AutoClicker.setClickPositionX(nME.getX());
            AutoClicker.setClickPositionY(nME.getY());

            aCIC.textFieldPositionXCoordinate.setText(Integer.toString(AutoClicker.getClickPositionX()));
            aCIC.textFieldPositionYCoordinate.setText(Integer.toString(AutoClicker.getClickPositionY()));
        }
    }
}