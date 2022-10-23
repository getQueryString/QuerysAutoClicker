// Copyright© by getQueryString/Fin

package com.github.gqs.querysautoclicker.Main.Settings;

import com.github.gqs.querysautoclicker.Controller.*;
import com.github.gqs.querysautoclicker.Main.Auto.AutoClicker;
import com.github.gqs.querysautoclicker.Main.Auto.AutoText;
import javafx.scene.control.ToggleGroup;

public class Use {

    private static final OptionsItemsController oIC = (OptionsItemsController) ControllerRepository.getInstance().getController(OptionsItemsController.class);
    private static final AutoClickerItemsController aCIC = (AutoClickerItemsController) ControllerRepository.getInstance().getController(AutoClickerItemsController.class);
    private static final AutoTextItemsController aTIC = (AutoTextItemsController) ControllerRepository.getInstance().getController(AutoTextItemsController.class);

    private static final ToggleGroup toggleGroupAutotype = new ToggleGroup();
    private static final ToggleGroup toggleGroupQuantity = new ToggleGroup();
    private static final ToggleGroup toggleGroupSpeed = new ToggleGroup();
    private static final ToggleGroup toggleGroupKey = new ToggleGroup();

    /**
     * Set ToggleGroups
     */
    public static void setToggleGroups() {
        setAutotypeToggleGroup();
        setQuantityToggleGroup();
        setSpeedToggleGroup();
        setKeyToggleGroup();
    }

    /**
     * Set AutoClicker and AutoText ToggleGroup
     */
    private static void setAutotypeToggleGroup() {
        oIC.radioButtonAutoClicker.setToggleGroup(toggleGroupAutotype);
        oIC.radioButtonAutoClicker.setSelected(true);
        oIC.radioButtonAutoText.setToggleGroup(toggleGroupAutotype);
    }

    /**
     * Set Quantity and Duration ToggleGroup
     */
    private static void setQuantityToggleGroup() {
        oIC.radioButtonQuantity.setToggleGroup(toggleGroupQuantity);
        oIC.radioButtonDuration.setToggleGroup(toggleGroupQuantity);
        oIC.radioButtonHoldHotkey.setToggleGroup(toggleGroupQuantity);
        oIC.radioButtonQuantity.setSelected(true);
    }

    /**
     * Set Speed and Interval ToggleGroup
     */
    private static void setSpeedToggleGroup() {
        oIC.radioButtonSpeed.setToggleGroup(toggleGroupSpeed);
        oIC.radioButtonSpeed.setSelected(true);
        oIC.radioButtonInterval.setToggleGroup(toggleGroupSpeed);
    }

    private static void setKeyToggleGroup() {
        aCIC.radioButtonMouseKey.setToggleGroup(toggleGroupKey);
        aCIC.radioButtonF5.setToggleGroup(toggleGroupKey);
        aCIC.radioButtonMouseKey.setSelected(true);
    }

    /**
     * Switch from AutoText to AutoClicker
     */
    public static void autoClicker() {
        if (oIC.radioButtonHoldHotkey.isSelected())
            Disable.startButton();
        if (AutoClicker.isHoldClickEnabled())
            Enable.holdClick();
        Disable.autoText();
        Enable.autoClickerAnchorPane();
        Enable.holdHotkey();
        Loader.autoClickerOptionValues();
        setSpeedAbbreviation();
    }

    /**
     * Switch from AutoClicker to AutoText
     */
    public static void autoText() {
        if (AutoClicker.isHoldClickEnabled()) {
            if (oIC.radioButtonSpeed.isSelected())
                Enable.speedTextField();
            else if (oIC.radioButtonInterval.isSelected())
                Enable.intervalTextField();
            Enable.useSpeed();
            Enable.useInterval();
        }
        if (AutoText.isPasteTextEnabled())
            Enable.lineForLineCheckBox();
        if (oIC.radioButtonHoldHotkey.isSelected()) {
            Use.quantity();
        }
        Disable.autoClicker();
        Disable.holdHotkey();
        Enable.startButton();
        Enable.autoTextAnchorPane();
        Loader.autoTextOptionValues();
        setSpeedAbbreviation();
    }

    public static void instantType() {
        AutoText.setPasteTextEnabled(!AutoText.isPasteTextEnabled());
        aTIC.checkBoxPasteTextLineForLine.setDisable(!AutoText.isPasteTextEnabled());
        setSpeedAbbreviation();
    }

    public static void setSpeedAbbreviation() {
        if (oIC.radioButtonAutoText.isSelected() && AutoText.isPasteTextEnabled())
            oIC.labelAutoSpeed.setText("pps"); // pastes per second
        else
            oIC.labelAutoSpeed.setText("cps"); // Clicks or characters per second
    }

    /**
     * Switch from Duration or HoldHotkey to Quantity
     */
    public static void quantity() {
        if (AutoClicker.isHoldClickEnabled() && oIC.radioButtonAutoClicker.isSelected())
            Disable.holdClick();
        if (!oIC.radioButtonQuantity.isSelected())
            oIC.radioButtonQuantity.setSelected(true);
        Disable.durationTextField();
        Enable.startButton();
        Enable.quantity();
    }

    /**
     * Switch from Quantity or HoldHotkey to Duration
     */
    public static void duration() {
        if (!oIC.radioButtonDuration.isSelected())
            oIC.radioButtonDuration.setSelected(true);
        Disable.quantityTextField();
        Enable.startButton();
        Enable.duration();
    }

    /**
     * Switch from Quantity or Duration to HoldHotkey
     */
    public static void holdHotkey() {
        if (!oIC.radioButtonHoldHotkey.isSelected())
            oIC.radioButtonHoldHotkey.setSelected(true);
        Disable.holdClick();
        Disable.startButton();
        Disable.quantityTextField();
        Disable.durationTextField();
    }

    /**
     * Switch from interval to speed
     */
    public static void speed() {
        if (!oIC.radioButtonSpeed.isSelected()) {
            oIC.radioButtonSpeed.setSelected(true);
        }
        Disable.intervalTextField();
        Enable.speedTextField();
    }

    /**
     * Switch from speed to interval
     */
    public static void interval() {
        if (!oIC.radioButtonInterval.isSelected()) {
            oIC.radioButtonInterval.setSelected(true);
        }
        Disable.speedTextField();
        Enable.intervalTextField();
    }

    /**
     * Switch from mouse key to F5 key
     */
    public static void f5Key() {
        if (AutoClicker.isHoldClickEnabled())
            Disable.holdClick();
        Disable.mouseChoiceBox();
        Disable.clickPositionItems();
    }

    /**
     * Switch from F5 key to mouse key
     */
    public static void mouseKey() {
        if (!aCIC.radioButtonMouseKey.isSelected()) {
            aCIC.radioButtonMouseKey.setSelected(true);
        }
        Enable.mouseChoiceBox();
        Enable.clickPositionItems();
    }
}