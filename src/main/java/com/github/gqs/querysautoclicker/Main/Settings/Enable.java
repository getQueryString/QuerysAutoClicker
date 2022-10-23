// Copyright© by getQueryString/Fin

package com.github.gqs.querysautoclicker.Main.Settings;

import com.github.gqs.querysautoclicker.Controller.*;
import com.github.gqs.querysautoclicker.Main.Auto.AutoClicker;
import com.github.gqs.querysautoclicker.Main.Main;

public class Enable {

    private static final Main gMI = Main.getInstance();

    private static final MainController mC = (MainController) ControllerRepository.getInstance().getController(MainController.class);
    private static final OptionsItemsController oIC = (OptionsItemsController) ControllerRepository.getInstance().getController(OptionsItemsController.class);
    private static final AutoClickerItemsController aCIC = (AutoClickerItemsController) ControllerRepository.getInstance().getController(AutoClickerItemsController.class);
    private static final AutoTextItemsController aTIC = (AutoTextItemsController) ControllerRepository.getInstance().getController(AutoTextItemsController.class);

    /**
     * Enables MainController items and OptionsAnchorPane
     */
    public static void all() {
        mainControllerItems();
        mC.optionsAnchorPane.setDisable(false);
    }

    /**
     * Enables MainController items
     */
    private static void mainControllerItems() {
        mC.mainHBox.setDisable(false);
        mC.imageViewClose.setDisable(false);
        mC.imageViewMinimize.setDisable(false);
        mC.imageViewAlwaysOnTopPinTrue.setDisable(false);
        mC.imageViewAlwaysOnTopPinFalse.setDisable(false);
        mC.mainImageViewDeveloperImage.setDisable(false);

        startButton();
        mC.buttonStop.setDisable(true);
        mC.buttonResetOptions.setDisable(false);
        mC.buttonResetAutoClicker.setDisable(false);
        mC.buttonResetAutoText.setDisable(false);
    }

    /**
     * Enables Start Button
     */
    public static void startButton() {
        mC.buttonStart.setDisable(false);
    }

    /**
     * Enables AutoClicker AnchorPane
     */
    public static void autoClickerAnchorPane() {
        mC.autoClickerAnchorPane.setDisable(false);
    }

    /**
     * Enables AutoText AnchorPane
     */
    public static void autoTextAnchorPane() {
        mC.autoTextAnchorPane.setDisable(false);
    }

    /**
     * Disable HoldClick if enabled and AutoClicker RadioButton is selected
     * & enable Quantity TextField
     */
    public static void quantity() {
        oIC.textFieldQuantity.setDisable(false);
    }

    /**
     * Select Duration RadioButton if HoldClick is activated
     * & enable Duration TextField
     */
    public static void duration() {
        oIC.textFieldDurationDays.setDisable(false);
        oIC.textFieldDurationHours.setDisable(false);
        oIC.textFieldDurationMinutes.setDisable(false);
        oIC.textFieldDurationSeconds.setDisable(false);
    }

    /**
     * Enables HoldHotkey RadioButton
     */
    public static void holdHotkey() {
        oIC.radioButtonHoldHotkey.setDisable(false);
    }

    /**
     * Enables Speed RadioButton
     */
    public static void useSpeed() {
        oIC.radioButtonSpeed.setDisable(false);
    }

    /**
     * Enables Speed TextField
     */
    public static void speedTextField() {
        oIC.textFieldSpeed.setDisable(false);
    }

    /**
     * Enables Interval RadioButton
     */
    public static void useInterval() {
        oIC.radioButtonInterval.setDisable(false);
    }

    /**
     * Enables Interval TextField
     */
    public static void intervalTextField() {
        oIC.textFieldIntervalDays.setDisable(false);
        oIC.textFieldIntervalHours.setDisable(false);
        oIC.textFieldIntervalMinutes.setDisable(false);
        oIC.textFieldIntervalSeconds.setDisable(false);
        oIC.textFieldIntervalMilliseconds.setDisable(false);
    }

    /**
     * Enables HoldClick
     */
    public static void holdClick() {
        if (!AutoClicker.isHoldClickEnabled())
            AutoClicker.setHoldClickEnabled(true);
        Use.duration();
        Disable.speedAndInterval();
    }

    /**
     * Enables the PickClickPosition state and items
     */
    public static void pickClickPosition() {
        AutoClicker.setPickClickPositionEnabled(true);
        gMI.root.setMouseTransparent(true);
        aCIC.buttonPickClickPosition.setDisable(true);
        aCIC.textFieldPositionXCoordinate.setDisable(true);
        aCIC.textFieldPositionYCoordinate.setDisable(true);
    }

    /**
     * Enables click position items: Position button, X coordinate TextField, Y coordinate TextField
     */
    public static void clickPositionItems() {
        aCIC.buttonPickClickPosition.setDisable(false);
        aCIC.textFieldPositionXCoordinate.setDisable(false);
        aCIC.textFieldPositionYCoordinate.setDisable(false);
    }

    /**
     * Enables Mouse ChoiceBox
     */
    public static void mouseChoiceBox() {
        aCIC.choiceBoxMouseKey.setDisable(false);
    }

    /**
     * Enables LineForLine CheckBox
     */
    public static void lineForLineCheckBox() {
        aTIC.checkBoxPasteTextLineForLine.setDisable(false);
    }
}