// Copyright© by getQueryString/Fin

package com.github.gqs.querysautoclicker.Main.JNativeHook;

import com.github.gqs.querysautoclicker.Controller.ControllerRepository;
import com.github.gqs.querysautoclicker.Controller.OptionsItemsController;
import com.github.gqs.querysautoclicker.Main.Auto.AutoClicker;
import com.github.gqs.querysautoclicker.Main.Auto.AutoText;
import com.github.gqs.querysautoclicker.Main.Settings.Reset;
import com.github.gqs.querysautoclicker.Main.Auto.Start;
import com.github.gqs.querysautoclicker.Main.Auto.Stop;
import com.github.gqs.querysautoclicker.Personalization.MainWindow;
import com.github.kwhat.jnativehook.keyboard.NativeKeyEvent;
import com.github.kwhat.jnativehook.keyboard.NativeKeyListener;
import javafx.application.Platform;

import java.awt.*;

import static com.github.kwhat.jnativehook.keyboard.NativeKeyEvent.*;

public class GlobalKeyListener implements NativeKeyListener {

    private final OptionsItemsController oC = (OptionsItemsController) ControllerRepository.getInstance().getController(OptionsItemsController.class);
    private final OptionsItemsController oIC = (OptionsItemsController) ControllerRepository.getInstance().getController(OptionsItemsController.class);

    private int HOLD_HOTKEY_PRESSED_COUNT = 0;

    /**
     * When a key is pressed
     *
     * @param e the native key event.
     */
    @Deprecated
    public void nativeKeyPressed(NativeKeyEvent e) {
        // Check if the pressed key corresponds to the saved hotkey
        if (Start.getStartHotkeyCode() == e.getRawCode()) {
            if (!oIC.radioButtonHoldHotkey.isSelected()) {
                Platform.runLater(() -> {
                    if ((!AutoClicker.isAutoClickerRunning() && oC.radioButtonAutoClicker.isSelected())
                            || (!AutoText.isAutoTextRunning() && oC.radioButtonAutoText.isSelected())) {
                        try {
                            Start.querysAutoClicker();
                        } catch (InterruptedException | AWTException exception) {
                            MainWindow.error("" + exception);
                        }
                    } else {
                        Stop.querysAutoClicker();
                    }
                });
            } else {
                HOLD_HOTKEY_PRESSED_COUNT++;
                try {
                    if (HOLD_HOTKEY_PRESSED_COUNT == 1) {
                        AutoClicker.setHoldHotkeyEnabled(true);
                        Start.querysAutoClicker();
                    }
                } catch (AWTException | InterruptedException exception) {
                    MainWindow.error("" + exception);
                }
            }
        }
        setHoldKey(e);
    }

    /**
     * When a key is released
     *
     * @param e the native key event.
     */
    @Deprecated
    public void nativeKeyReleased(NativeKeyEvent e) {
        if (Start.getStartHotkeyCode() == e.getRawCode() && oIC.radioButtonHoldHotkey.isSelected()) {
            if (AutoClicker.holdHotkeyThread != null)
                AutoClicker.holdHotkeyThread.stop();
            if (AutoClicker.autoClickerThread != null)
                Stop.querysAutoClicker();
            HOLD_HOTKEY_PRESSED_COUNT = 0;
            AutoClicker.setHoldHotkeyEnabled(false);
        }
    }

    /**
     * Change StartHotkey
     */
    private void setHoldKey(NativeKeyEvent e) {
        switch (e.getKeyCode()) {
            case VC_TAB, VC_META, VC_SPACE, VC_LEFT, VC_RIGHT, VC_UP, VC_DOWN, VC_ENTER, VC_F5 -> {
                return;
            }
        }

        switch (e.getRawCode()) {
            case 44, 255 -> {
                Reset.startHotkey();
                return;
            }
        }

        if (oC.checkBoxStartHotkey.isSelected() && oC.checkBoxStartHotkey.isFocused())
            Start.setStartHotkeyCode(e.getRawCode());
    }
}