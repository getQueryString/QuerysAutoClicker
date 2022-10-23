// Copyright© by getQueryString/Fin

package com.github.gqs.querysautoclicker.Main.Settings;

import com.github.gqs.querysautoclicker.Controller.AutoClickerItemsController;
import com.github.gqs.querysautoclicker.Controller.AutoTextItemsController;
import com.github.gqs.querysautoclicker.Controller.ControllerRepository;
import com.github.gqs.querysautoclicker.Controller.OptionsItemsController;
import com.github.gqs.querysautoclicker.Main.Auto.AutoClicker;
import com.github.gqs.querysautoclicker.Main.Auto.AutoText;
import com.github.gqs.querysautoclicker.Main.Auto.Start;
import javafx.scene.control.TextField;

public class Reset {

    private static final OptionsItemsController oIC = (OptionsItemsController) ControllerRepository.getInstance().getController(OptionsItemsController.class);
    private static final AutoClickerItemsController aCIC = (AutoClickerItemsController) ControllerRepository.getInstance().getController(AutoClickerItemsController.class);
    private static final AutoTextItemsController aTIC = (AutoTextItemsController) ControllerRepository.getInstance().getController(AutoTextItemsController.class);

    /**
     * Reset Options settings
     */
    public static void optionsSettings() {
        setDefaultValues();
        Use.quantity();
        Use.speed();
        startHotkey();
    }

    /**
     * Reset StartHotkey
     */
    public static void startHotkey() {
        Disable.startHotkeyTextField();
        Start.setStartHotkeyCode(117);
        oIC.checkBoxStartHotkey.setSelected(false);
        oIC.textFieldStartHotkey.setText("F6");
    }

    /**
     * Reset AutoClicker settings
     */
    public static void autoClickerSettings() {
        if (AutoClicker.isHoldClickEnabled()) Disable.holdClick();
        Use.mouseKey();
        aCIC.choiceBoxClickType.getSelectionModel().select(0);
        aCIC.choiceBoxMouseKey.getSelectionModel().select(0);
        aCIC.textFieldPositionXCoordinate.setText("");
        aCIC.textFieldPositionYCoordinate.setText("");
    }

    /**
     * Reset AutoText settings
     */
    public static void autoTextSettings() {
        AutoText.setPasteTextEnabled(false);
        AutoText.setPasteTextLineForLineEnabled(false);
        Disable.lineForLineCheckBox();
        Use.setSpeedAbbreviation();
        aTIC.checkBoxPasteText.setSelected(false);
        aTIC.checkBoxPasteTextLineForLine.setSelected(false);
        aTIC.choiceBoxReplaceOptions.getSelectionModel().select(0);
        aTIC.textAreaSplit.setText("");
        aTIC.textAreaSplitTo.setText("");
        aTIC.textAreaTextEntry.setText("");
    }

    /**
     * Reset AutoClicker values
     */
    private static void resetAutoClickerValues() {
        if (Loader.autoClickerValues.size() != 0) {
            Loader.autoClickerValues.clear();
        }
    }

    /**
     * Reset AutoText values
     */
    private static void resetAutoTextValues() {
        if (Loader.autoTextValues.size() != 0) {
            Loader.autoTextValues.clear();
        }
    }

    /**
     * Reset values of Options TextFields
     */
    private static void setDefaultValues() {
        if (oIC.radioButtonAutoClicker.isSelected())
            resetAutoClickerValues();
        else
            resetAutoTextValues();
        TextField[] textFieldToGroup = new TextField[]{
                oIC.textFieldStartIntervalDays,
                oIC.textFieldStartIntervalHours,
                oIC.textFieldStartIntervalMinutes,
                oIC.textFieldStartIntervalSeconds,
                oIC.textFieldDurationDays,
                oIC.textFieldDurationHours,
                oIC.textFieldDurationMinutes,
                oIC.textFieldDurationSeconds,
                oIC.textFieldIntervalDays,
                oIC.textFieldIntervalHours,
                oIC.textFieldIntervalMinutes,
                oIC.textFieldIntervalSeconds,
                oIC.textFieldIntervalMilliseconds
        };

        for (TextField textField : textFieldToGroup) {
            textField.setText("0");
        }
        oIC.textFieldQuantity.setText("-1");
        oIC.textFieldSpeed.setText("5");
    }
}