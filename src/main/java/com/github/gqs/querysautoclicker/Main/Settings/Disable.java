// Copyright© by getQueryString/Fin

package com.github.gqs.querysautoclicker.Main.Settings;

import com.github.gqs.querysautoclicker.Controller.*;
import com.github.gqs.querysautoclicker.Main.Auto.AutoClicker;
import com.github.gqs.querysautoclicker.Main.Main;

public class Disable {

    private static final Main gMI = Main.getInstance();

    private static final MainController mC = (MainController) ControllerRepository.getInstance().getController(MainController.class);
    private static final OptionsItemsController oIC = (OptionsItemsController) ControllerRepository.getInstance().getController(OptionsItemsController.class);
    private static final AutoClickerItemsController aCIC = (AutoClickerItemsController) ControllerRepository.getInstance().getController(AutoClickerItemsController.class);
    private static final AutoTextItemsController aTIC = (AutoTextItemsController) ControllerRepository.getInstance().getController(AutoTextItemsController.class);

    /**
     * Disables MainController items, OptionsAnchorPane, AutoClickerAnchorPane and AutoTextAnchorPane
     */
    public static void allItems() {
        mainControllerItems();
        mC.optionsAnchorPane.setDisable(true);
        mC.autoClickerAnchorPane.setDisable(true);
        mC.autoTextAnchorPane.setDisable(true);
    }

    /**
     * Disables MainController items
     */
    private static void mainControllerItems() {
        mC.mainHBox.setDisable(true);
        mC.imageViewClose.setDisable(true);
        mC.imageViewMinimize.setDisable(true);
        mC.imageViewAlwaysOnTopPinTrue.setDisable(true);
        mC.imageViewAlwaysOnTopPinFalse.setDisable(true);
        mC.mainImageViewDeveloperImage.setDisable(true);

        startButton();
        mC.buttonStop.setDisable(false);
        mC.buttonResetOptions.setDisable(true);
        mC.buttonResetAutoClicker.setDisable(true);
        mC.buttonResetAutoText.setDisable(true);
    }

    /**
     * Disables Start Button
     */
    public static void startButton() {
        mC.buttonStart.setDisable(true);
    }

    /**
     * Disables AutoClicker AnchorPane
     */
    public static void autoClicker() {
        mC.autoClickerAnchorPane.setDisable(true);
    }

    /**
     * Disables AutoText AnchorPane
     */
    public static void autoText() {
        mC.autoTextAnchorPane.setDisable(true);
    }

    /**
     * Disables Speed and Interval elements
     */
    public static void speedAndInterval() {
        useSpeed();
        speedTextField();
        useInterval();
        intervalTextField();
    }

    /**
     * Disables StartHotkey TextField
     */
    public static void startHotkeyTextField() {
        oIC.textFieldStartHotkey.setDisable(true);
    }

    /**
     * Disables Quantity RadioButton
     */
    public static void quantity() {
        oIC.radioButtonQuantity.setDisable(true);
    }

    /**
     * Disables Quantity TextField
     */
    public static void quantityTextField() {
        oIC.textFieldQuantity.setDisable(true);
    }

    /**
     * Disables Duration TextField
     */
    public static void durationTextField() {
        oIC.textFieldDurationDays.setDisable(true);
        oIC.textFieldDurationHours.setDisable(true);
        oIC.textFieldDurationMinutes.setDisable(true);
        oIC.textFieldDurationSeconds.setDisable(true);
    }

    /**
     * Disables HoldHotkey RadioButton
     */
    public static void holdHotkey() {
        oIC.radioButtonHoldHotkey.setDisable(true);
    }

    /**
     * Disables Speed RadioButton
     */
    public static void useSpeed() {
        oIC.radioButtonSpeed.setDisable(true);
    }

    /**
     * Disables Speed TextField
     */
    public static void speedTextField() {
        oIC.textFieldSpeed.setDisable(true);
    }

    /**
     * Disables Interval RadioButton
     */
    public static void useInterval() {
        oIC.radioButtonInterval.setDisable(true);
    }

    /**
     * Disables Interval TextField
     */
    public static void intervalTextField() {
        oIC.textFieldIntervalDays.setDisable(true);
        oIC.textFieldIntervalHours.setDisable(true);
        oIC.textFieldIntervalMinutes.setDisable(true);
        oIC.textFieldIntervalSeconds.setDisable(true);
        oIC.textFieldIntervalMilliseconds.setDisable(true);
    }

    /**
     * Disables HoldCLick
     */
    public static void holdClick() {
        if (AutoClicker.isHoldClickEnabled())
            AutoClicker.setHoldClickEnabled(false);
        if (aCIC.checkBoxHoldClick.isSelected())
            aCIC.checkBoxHoldClick.setSelected(false);
        if (oIC.radioButtonSpeed.isSelected())
            Use.speed();
        else if (oIC.radioButtonInterval.isSelected())
            Use.interval();
        Enable.useSpeed();
        Enable.useInterval();
    }

    /**
     * Disables the PickClickPosition state
     */
    public static void pickClickPositionState() {
        AutoClicker.setPickClickPositionEnabled(false);
        gMI.root.setMouseTransparent(false);
    }

    /**
     * Disables the PickClickPosition state and items
     */
    public static void pickClickPosition() {
        pickClickPositionState();
        aCIC.buttonPickClickPosition.setDisable(false);
        aCIC.textFieldPositionXCoordinate.setDisable(false);
        aCIC.textFieldPositionYCoordinate.setDisable(false);
    }

    /**
     * Disables click position items: Position button, X coordinate TextField, Y coordinate TextField
     */
    public static void clickPositionItems() {
        aCIC.buttonPickClickPosition.setDisable(true);
        aCIC.textFieldPositionXCoordinate.setDisable(true);
        aCIC.textFieldPositionYCoordinate.setDisable(true);
    }

    /**
     * Disables Mouse ChoiceBox
     */
    public static void mouseChoiceBox() {
        aCIC.choiceBoxMouseKey.setDisable(true);
    }

    /**
     * Disables LineForLine CheckBox
     */
    public static void lineForLineCheckBox() {
        aTIC.checkBoxPasteTextLineForLine.setDisable(true);
    }
}