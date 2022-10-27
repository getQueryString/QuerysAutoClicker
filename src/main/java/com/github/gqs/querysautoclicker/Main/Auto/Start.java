// Copyright© by getQueryString/Fin

package com.github.gqs.querysautoclicker.Main.Auto;

import com.github.gqs.querysautoclicker.Contributors.ContributorsWindow;
import com.github.gqs.querysautoclicker.Controller.AutoTextItemsController;
import com.github.gqs.querysautoclicker.Controller.ControllerRepository;
import com.github.gqs.querysautoclicker.Controller.MainController;
import com.github.gqs.querysautoclicker.Controller.OptionsItemsController;
import com.github.gqs.querysautoclicker.Main.Main;
import com.github.gqs.querysautoclicker.Main.Settings.Disable;
import com.github.gqs.querysautoclicker.Personalization.MainWindow;
import javafx.scene.input.KeyEvent;

import java.awt.*;
import java.util.concurrent.TimeUnit;

public class Start {

    private static final Main gMI = Main.getInstance();

    private static final MainController mC = (MainController) ControllerRepository.getInstance().getController(MainController.class);
    private static final OptionsItemsController oIC = (OptionsItemsController) ControllerRepository.getInstance().getController(OptionsItemsController.class);
    private static final AutoTextItemsController aTIC = (AutoTextItemsController) ControllerRepository.getInstance().getController(AutoTextItemsController.class);

    private static int START_HOTKEY_CODE = 117;
    private static final int START_DELAY = 20;

    // Start delay
    private static boolean isStartDelayEnabled = false;

    /**
     * Start AutoClicker/AutoText
     *
     * @throws InterruptedException
     * @throws AWTException
     */
    @Deprecated
    public static void querysAutoClicker() throws InterruptedException, AWTException {
        if ((!isStartDelayEnabled() && !ContributorsWindow.isContributorsWindowShowing() && !oIC.checkBoxStartHotkey.isSelected())
                || AutoClicker.isHoldHotkeyEnabled()) {
            setStartDelayEnabled(true);
            gMI.threadPool.schedule(() -> setStartDelayEnabled(false), START_DELAY, TimeUnit.MILLISECONDS);

            Disable.allItems();

            if (oIC.radioButtonAutoClicker.isSelected()) {
                if (AutoClicker.isPickClickPositionEnabled())
                    Disable.pickClickPositionState();
                if (mC.labelErrorMessage.isVisible())
                    mC.labelErrorMessage.setVisible(false);
                AutoClicker.start();
            } else if (oIC.radioButtonAutoText.isSelected())
                if (aTIC.textAreaTextEntry.getText().isEmpty())
                    MainWindow.error(MainWindow.getErrorMessageAutoTextTextInputIsEmpty());
                else {
                    mC.labelErrorMessage.setVisible(false);
                    AutoText.start();
                }
        }
    }

    /**
     * Set hotkey to start AutoClicker or AutoText
     */
    @Deprecated
    public static void setStartHotkey(KeyEvent e) {
        if (oIC.checkBoxStartHotkey.isSelected() && oIC.checkBoxStartHotkey.isFocused()) {
            switch (e.getCode()) {
                case TAB, WINDOWS, SPACE, LEFT, RIGHT, UP, DOWN, ENTER, F5 -> {
                    return;
                }
                case ESCAPE -> oIC.textFieldStartHotkey.setText("Esc");
                case CAPS -> oIC.textFieldStartHotkey.setText("Caps Lock");
                case SHIFT -> oIC.textFieldStartHotkey.setText("Shift");
                case CONTROL -> oIC.textFieldStartHotkey.setText("Ctrl");
                case ALT -> oIC.textFieldStartHotkey.setText("Alt");
                case ALT_GRAPH -> oIC.textFieldStartHotkey.setText("Alt Gr");
                case CONTEXT_MENU -> oIC.textFieldStartHotkey.setText("C. M.");
                case F1 -> oIC.textFieldStartHotkey.setText("F1");
                case F2 -> oIC.textFieldStartHotkey.setText("F2");
                case F3 -> oIC.textFieldStartHotkey.setText("F3");
                case F4 -> oIC.textFieldStartHotkey.setText("F4");
                case F6 -> oIC.textFieldStartHotkey.setText("F6");
                case F7 -> oIC.textFieldStartHotkey.setText("F7");
                case F8 -> oIC.textFieldStartHotkey.setText("F8");
                case F9 -> oIC.textFieldStartHotkey.setText("F9");
                case F10 -> oIC.textFieldStartHotkey.setText("F10");
                case F11 -> oIC.textFieldStartHotkey.setText("F11");
                case F12 -> oIC.textFieldStartHotkey.setText("F12");
                case PAUSE -> oIC.textFieldStartHotkey.setText("Pause");
                case INSERT -> oIC.textFieldStartHotkey.setText("Insert");
                case DELETE -> oIC.textFieldStartHotkey.setText("Delete");
                case BACK_SPACE -> oIC.textFieldStartHotkey.setText("Backspace");
                case NUM_LOCK -> oIC.textFieldStartHotkey.setText("Num Lock");
                default -> oIC.textFieldStartHotkey.setText(e.getText().toUpperCase());
            }
        }
        oIC.checkBoxStartHotkey.setSelected(false);
        Disable.startHotkeyTextField();
    }

    /**
     * @return isStartDelayEnabled
     */
    public static boolean isStartDelayEnabled() {
        return isStartDelayEnabled;
    }

    /**
     * When StartDelay is enabled: isStartDelayEnabled = true
     * <p>
     * When StartDelay is disabled: isStartDelayEnabled = false
     * </p>
     *
     * @param isStartDelayEnabled
     */
    public static void setStartDelayEnabled(boolean isStartDelayEnabled) {
        Start.isStartDelayEnabled = isStartDelayEnabled;
    }

    /**
     * @return START_HOTKEY_CODE
     */
    public static int getStartHotkeyCode() {
        return START_HOTKEY_CODE;
    }

    /**
     * Set hotkey to start AutoClicker or AutoText
     *
     * @param START_HOTKEY_CODE
     */
    public static void setStartHotkeyCode(int START_HOTKEY_CODE) {
        Start.START_HOTKEY_CODE = START_HOTKEY_CODE;
    }
}