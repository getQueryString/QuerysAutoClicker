// Copyright© by getQueryString/Fin

package com.github.gqs.querysautoclicker.Main.Auto;

import com.github.gqs.querysautoclicker.Controller.AutoClickerItemsController;
import com.github.gqs.querysautoclicker.Controller.ControllerRepository;
import com.github.gqs.querysautoclicker.Controller.OptionsItemsController;
import com.github.gqs.querysautoclicker.Main.Settings.Disable;
import com.github.gqs.querysautoclicker.Main.Settings.Enable;
import com.github.gqs.querysautoclicker.Main.Settings.Use;
import javafx.application.Platform;
import javafx.scene.input.Clipboard;

import java.awt.event.KeyEvent;

import static java.awt.event.KeyEvent.VK_ALT;
import static java.awt.event.KeyEvent.VK_V;

public class Stop {

    private static final OptionsItemsController oIC = (OptionsItemsController) ControllerRepository.getInstance().getController(OptionsItemsController.class);
    private static final AutoClickerItemsController aCIC = (AutoClickerItemsController) ControllerRepository.getInstance().getController(AutoClickerItemsController.class);

    /**
     * Stop AutoClicker/AutoText
     */
    public static void querysAutoClicker() {
        if (oIC.radioButtonAutoClicker.isSelected()) {
            autoClicker();
        } else {
            autoText();
        }
    }

    /**
     * Stop AutoClicker
     */
    @Deprecated
    private static void autoClicker() {
        Enable.autoClickerAnchorPane();
        adjustDeactivations();
        AutoClicker.setAutoClickerRunning(false);
        AutoClicker.setClickCount(0);
        if (AutoClicker.autoClickerRobot != null) {
            if (AutoClicker.isHoldClickEnabled())
                AutoClicker.autoClickerRobot.mouseRelease(AutoClicker.getMouseInputKey());
            if (AutoClicker.autoClickerThread != null)
                AutoClicker.stopAutoClickerThread();
        }
    }

    /**
     * Stop AutoText
     */
    @Deprecated
    private static void autoText() {
        Enable.autoTextAnchorPane();
        adjustDeactivations();
        AutoText.setAutoTextRunning(false);
        AutoText.setTextCount(0);
        if (AutoText.autoTextRobot != null) {
            if (AutoText.isPasteTextEnabled())
                Platform.runLater(() -> Clipboard.getSystemClipboard().clear());
            if (AutoText.autoTextThread != null)
                AutoText.stopAutoTextThread();
        }
        if (aCIC.radioButtonF5.isSelected())
            Use.f5Key();
    }

    /**
     * Adjust specified settings
     */
    private static void adjustDeactivations() {
        Enable.all();
        Disable.startHotkeyTextField();

        if (oIC.radioButtonHoldHotkey.isSelected())
            Disable.startButton();
        if (oIC.radioButtonQuantity.isSelected())
            Disable.durationTextField();
        else if (oIC.radioButtonDuration.isSelected())
            Disable.quantityTextField();

        if (oIC.radioButtonSpeed.isSelected())
            Disable.intervalTextField();
        else if (oIC.radioButtonInterval.isSelected())
            Disable.speedTextField();

        if (AutoClicker.isHoldClickEnabled())
            Disable.speedAndInterval();
        if (AutoText.isPasteTextEnabled())
            Enable.lineForLineCheckBox();
    }
}