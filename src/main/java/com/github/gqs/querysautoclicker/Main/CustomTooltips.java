// Copyright© by getQueryString/Fin

package com.github.gqs.querysautoclicker.Main;

import com.github.gqs.querysautoclicker.Controller.*;
import com.github.gqs.querysautoclicker.Personalization.Language;
import javafx.scene.control.*;
import javafx.util.Duration;

import java.util.Locale;
import java.util.ResourceBundle;

public class CustomTooltips {

    private static final MainController mC = (MainController) ControllerRepository.getInstance().getController(MainController.class);
    private static final OptionsItemsController oIC = (OptionsItemsController) ControllerRepository.getInstance().getController(OptionsItemsController.class);
    private static final AutoClickerItemsController aCIC = (AutoClickerItemsController) ControllerRepository.getInstance().getController(AutoClickerItemsController.class);
    private static final AutoTextItemsController aTIC = (AutoTextItemsController) ControllerRepository.getInstance().getController(AutoTextItemsController.class);

    private static final int TOOLTIP_SHOW_DELAY = 250;
    private static final int TOOLTIP_SHOW_DURATION = 20000;
    private static final int TOOLTIP_HIDE_DELAY = 50;

    private static boolean isTipsEnabled = false;

    // Tooltips
    private static Tooltip[] allTooltipContainers;
    private static Button[] buttonTooltips;
    private static CheckBox[] checkBoxTooltips;
    private static ChoiceBox[] choiceBoxTooltips;
    private static RadioButton[] radioButtonTooltips;
    private static TextArea[] textAreaTooltips;
    private static TextField[] textFieldTooltips;

    // MainController
    private static final Tooltip buttonStartTooltip = new Tooltip();
    private static final Tooltip buttonResetOptionsTooltip = new Tooltip();
    private static final Tooltip buttonResetAutoClickerTooltip = new Tooltip();
    private static final Tooltip buttonResetAutoTextTooltip = new Tooltip();

    // OptionsItemsController
    private static final Tooltip checkBoxStartHotkeyTooltip = new Tooltip();
    private static final Tooltip textFieldStartHotkeyTooltip = new Tooltip();
    private static final Tooltip textFieldStartIntervalDaysTooltip = new Tooltip();
    private static final Tooltip textFieldStartIntervalHoursTooltip = new Tooltip();
    private static final Tooltip textFieldStartIntervalMinutesTooltip = new Tooltip();
    private static final Tooltip textFieldStartIntervalSecondsTooltip = new Tooltip();
    private static final Tooltip textFieldQuantityTooltip = new Tooltip();
    private static final Tooltip textFieldDurationDaysTooltip = new Tooltip();
    private static final Tooltip textFieldDurationHoursTooltip = new Tooltip();
    private static final Tooltip textFieldDurationMinutesTooltip = new Tooltip();
    private static final Tooltip textFieldDurationSecondsTooltip = new Tooltip();
    private static final Tooltip textFieldSpeedTooltip = new Tooltip();
    private static final Tooltip textFieldIntervalDaysTooltip = new Tooltip();
    private static final Tooltip textFieldIntervalHoursTooltip = new Tooltip();
    private static final Tooltip textFieldIntervalMinutesTooltip = new Tooltip();
    private static final Tooltip textFieldIntervalSecondsTooltip = new Tooltip();
    private static final Tooltip textFieldIntervalMillisecondsTooltip = new Tooltip();
    private static final Tooltip radioButtonAutoClickerTooltip = new Tooltip();
    private static final Tooltip radioButtonAutoTextTooltip = new Tooltip();
    private static final Tooltip radioButtonQuantityTooltip = new Tooltip();
    private static final Tooltip radioButtonDurationTooltip = new Tooltip();
    private static final Tooltip radioButtonHoldHotkeyTooltip = new Tooltip();
    private static final Tooltip radioButtonSpeedTooltip = new Tooltip();
    private static final Tooltip radioButtonIntervalTooltip = new Tooltip();

    // AutoClickerItemsController
    private static final Tooltip buttonPickClickPositionTooltip = new Tooltip();
    private static final Tooltip checkBoxHoldClickTooltip = new Tooltip();
    private static final Tooltip choiceBoxClickTypeTooltip = new Tooltip();
    private static final Tooltip choiceBoxMouseKeyTooltip = new Tooltip();
    private static final Tooltip radioButtonMouseKeyTooltip = new Tooltip();
    private static final Tooltip radioButtonF5KeyTooltip = new Tooltip();
    private static final Tooltip textFieldXCoordinateTooltip = new Tooltip();
    private static final Tooltip textFieldYCoordinateTooltip = new Tooltip();

    // AutoTextItemsController
    private static final Tooltip checkBoxPasteTextTooltip = new Tooltip();
    private static final Tooltip checkBoxPasteTextLineForLineTooltip = new Tooltip();
    private static final Tooltip choiceBoxReplaceOptionsTooltip = new Tooltip();
    private static final Tooltip textAreaSplitTooltip = new Tooltip();
    private static final Tooltip textAreaSplitToTooltip = new Tooltip();
    private static final Tooltip textAreaTextEntryTooltip = new Tooltip();

    /**
     * Add Containers to ArrayLists
     */
    public static void addContainersToGroup() {
        allTooltipContainers = new Tooltip[]
                {
                        // Button
                        buttonStartTooltip,
                        buttonResetOptionsTooltip,
                        buttonResetAutoClickerTooltip,
                        buttonResetAutoTextTooltip,
                        buttonPickClickPositionTooltip,

                        // CheckBox
                        checkBoxStartHotkeyTooltip,
                        checkBoxHoldClickTooltip,
                        checkBoxPasteTextTooltip,
                        checkBoxPasteTextLineForLineTooltip,

                        // ChoiceBox
                        choiceBoxClickTypeTooltip,
                        choiceBoxMouseKeyTooltip,
                        choiceBoxReplaceOptionsTooltip,

                        // RadioButton
                        radioButtonAutoClickerTooltip,
                        radioButtonAutoTextTooltip,
                        radioButtonQuantityTooltip,
                        radioButtonDurationTooltip,
                        radioButtonHoldHotkeyTooltip,
                        radioButtonSpeedTooltip,
                        radioButtonIntervalTooltip,
                        radioButtonMouseKeyTooltip,
                        radioButtonF5KeyTooltip,

                        // TextArea
                        textAreaSplitTooltip,
                        textAreaSplitToTooltip,
                        textAreaTextEntryTooltip,

                        // TextField
                        textFieldStartHotkeyTooltip,
                        textFieldStartIntervalDaysTooltip,
                        textFieldStartIntervalHoursTooltip,
                        textFieldStartIntervalMinutesTooltip,
                        textFieldStartIntervalSecondsTooltip,
                        textFieldQuantityTooltip,
                        textFieldDurationDaysTooltip,
                        textFieldDurationHoursTooltip,
                        textFieldDurationMinutesTooltip,
                        textFieldDurationSecondsTooltip,
                        textFieldSpeedTooltip,
                        textFieldIntervalDaysTooltip,
                        textFieldIntervalHoursTooltip,
                        textFieldIntervalMinutesTooltip,
                        textFieldIntervalSecondsTooltip,
                        textFieldIntervalMillisecondsTooltip,
                        textFieldXCoordinateTooltip,
                        textFieldYCoordinateTooltip
                };

        buttonTooltips = new Button[]
                {
                        mC.buttonStart,
                        mC.buttonResetOptions,
                        mC.buttonResetAutoClicker,
                        mC.buttonResetAutoText,
                        aCIC.buttonPickClickPosition
                };

        checkBoxTooltips = new CheckBox[]{
                oIC.checkBoxStartHotkey,
                aCIC.checkBoxHoldClick,
                aTIC.checkBoxPasteText,
                aTIC.checkBoxPasteTextLineForLine
        };

        choiceBoxTooltips = new ChoiceBox[]{
                aCIC.choiceBoxClickType,
                aCIC.choiceBoxMouseKey,
                aTIC.choiceBoxReplaceOptions
        };

        radioButtonTooltips = new RadioButton[]{
                oIC.radioButtonAutoClicker,
                oIC.radioButtonAutoText,
                oIC.radioButtonQuantity,
                oIC.radioButtonDuration,
                oIC.radioButtonHoldHotkey,
                oIC.radioButtonSpeed,
                oIC.radioButtonInterval,
                aCIC.radioButtonMouseKey,
                aCIC.radioButtonF5
        };

        textAreaTooltips = new TextArea[]{
                aTIC.textAreaSplit,
                aTIC.textAreaSplitTo,
                aTIC.textAreaTextEntry
        };

        textFieldTooltips = new TextField[]{
                oIC.textFieldStartIntervalDays,
                oIC.textFieldStartIntervalHours,
                oIC.textFieldStartIntervalMinutes,
                oIC.textFieldStartIntervalSeconds,
                oIC.textFieldQuantity,
                oIC.textFieldDurationDays,
                oIC.textFieldDurationHours,
                oIC.textFieldDurationMinutes,
                oIC.textFieldDurationSeconds,
                oIC.textFieldSpeed,
                oIC.textFieldIntervalDays,
                oIC.textFieldIntervalHours,
                oIC.textFieldIntervalMinutes,
                oIC.textFieldIntervalSeconds,
                oIC.textFieldIntervalMilliseconds,
                aCIC.textFieldPositionXCoordinate,
                aCIC.textFieldPositionYCoordinate
        };
    }

    /**
     * Enable/Disable CustomTooltips
     *
     * @param isTipsEnabled
     */
    public static void set(boolean isTipsEnabled) {
        if (isTipsEnabled) {
            setTooltipProperties();
            setTooltips();
            setLanguage(Language.getSelectedLanguage());
        } else
            remove();
    }

    /**
     * Disable CustomTooltips
     */
    public static void remove() {
        setTipsEnabled(false);
        for (Button removeTooltips : buttonTooltips) {
            removeTooltips.setTooltip(null);
        }
        for (CheckBox removeTooltips : checkBoxTooltips) {
            removeTooltips.setTooltip(null);
        }
        for (ChoiceBox removeTooltips : choiceBoxTooltips) {
            removeTooltips.setTooltip(null);
        }
        for (RadioButton removeTooltips : radioButtonTooltips) {
            removeTooltips.setTooltip(null);
        }
        for (TextArea removeTooltips : textAreaTooltips) {
            removeTooltips.setTooltip(null);
        }
        for (TextField removeTooltips : textFieldTooltips) {
            removeTooltips.setTooltip(null);
        }
    }

    /**
     * Set Tooltip properties
     */
    public static void setTooltipProperties() {
        for (Tooltip tooltip : allTooltipContainers) {
            tooltip.setShowDelay(Duration.millis(TOOLTIP_SHOW_DELAY));
            tooltip.setShowDuration(Duration.millis(TOOLTIP_SHOW_DURATION));
            tooltip.setHideDelay(Duration.millis(TOOLTIP_HIDE_DELAY));
            tooltip.setStyle("-fx-background-color: white;" +
                    "-fx-font-family: \"Arial\";" +
                    "-fx-font-weight: normal;" +
                    "-fx-text-fill: black;" +
                    "-fx-font-size: 12px;" +
                    "-fx-padding: 8px;" +
                    "-fx-background-radius: 5px;");
        }
    }

    /**
     * Set the language of Tooltip text
     *
     * @param locale
     */
    public static void setLanguage(String locale) {
        Language.languageLocale = new Locale(locale);
        Language.languageResourceBundle = ResourceBundle.getBundle("Languages/lang", Language.languageLocale);

        RadioMenuItem radioMenuItem = Language.languageToGroup.get(locale);
        if (radioMenuItem.isSelected())
            setTooltipText(Language.languageResourceBundle);
    }

    /**
     * Set tootips to related containers
     */
    public static void setTooltips() {
        // Button
        mC.buttonStart.setTooltip(buttonStartTooltip);
        mC.buttonResetOptions.setTooltip(buttonResetOptionsTooltip);
        mC.buttonResetAutoClicker.setTooltip(buttonResetAutoClickerTooltip);
        mC.buttonResetAutoText.setTooltip(buttonResetAutoTextTooltip);
        aCIC.buttonPickClickPosition.setTooltip(buttonPickClickPositionTooltip);

        // CheckBox
        oIC.checkBoxStartHotkey.setTooltip(checkBoxStartHotkeyTooltip);
        aCIC.checkBoxHoldClick.setTooltip(checkBoxHoldClickTooltip);
        aTIC.checkBoxPasteText.setTooltip(checkBoxPasteTextTooltip);
        aTIC.checkBoxPasteTextLineForLine.setTooltip(checkBoxPasteTextLineForLineTooltip);

        // ChoiceBox
        aCIC.choiceBoxClickType.setTooltip(choiceBoxClickTypeTooltip);
        aCIC.choiceBoxMouseKey.setTooltip(choiceBoxMouseKeyTooltip);
        aTIC.choiceBoxReplaceOptions.setTooltip(choiceBoxReplaceOptionsTooltip);

        // RadioButton
        oIC.radioButtonAutoClicker.setTooltip(radioButtonAutoClickerTooltip);
        oIC.radioButtonAutoText.setTooltip(radioButtonAutoTextTooltip);

        oIC.radioButtonQuantity.setTooltip(radioButtonQuantityTooltip);
        oIC.radioButtonDuration.setTooltip(radioButtonDurationTooltip);
        oIC.radioButtonHoldHotkey.setTooltip(radioButtonHoldHotkeyTooltip);

        oIC.radioButtonSpeed.setTooltip(radioButtonSpeedTooltip);
        oIC.radioButtonInterval.setTooltip(radioButtonIntervalTooltip);

        aCIC.radioButtonMouseKey.setTooltip(radioButtonMouseKeyTooltip);
        aCIC.radioButtonF5.setTooltip(radioButtonF5KeyTooltip);

        // TextArea
        aTIC.textAreaSplit.setTooltip(textAreaSplitTooltip);
        aTIC.textAreaSplitTo.setTooltip(textAreaSplitToTooltip);
        aTIC.textAreaTextEntry.setTooltip(textAreaTextEntryTooltip);

        // TextField
        oIC.textFieldStartHotkey.setTooltip(textFieldStartHotkeyTooltip);
        oIC.textFieldStartIntervalDays.setTooltip(textFieldStartIntervalDaysTooltip);
        oIC.textFieldStartIntervalHours.setTooltip(textFieldStartIntervalHoursTooltip);
        oIC.textFieldStartIntervalMinutes.setTooltip(textFieldStartIntervalMinutesTooltip);
        oIC.textFieldStartIntervalSeconds.setTooltip(textFieldStartIntervalSecondsTooltip);
        oIC.textFieldQuantity.setTooltip(textFieldQuantityTooltip);
        oIC.textFieldDurationDays.setTooltip(textFieldDurationDaysTooltip);
        oIC.textFieldDurationHours.setTooltip(textFieldDurationHoursTooltip);
        oIC.textFieldDurationMinutes.setTooltip(textFieldDurationMinutesTooltip);
        oIC.textFieldDurationSeconds.setTooltip(textFieldDurationSecondsTooltip);
        oIC.textFieldSpeed.setTooltip(textFieldSpeedTooltip);
        oIC.textFieldIntervalDays.setTooltip(textFieldIntervalDaysTooltip);
        oIC.textFieldIntervalHours.setTooltip(textFieldIntervalHoursTooltip);
        oIC.textFieldIntervalMinutes.setTooltip(textFieldIntervalMinutesTooltip);
        oIC.textFieldIntervalSeconds.setTooltip(textFieldIntervalSecondsTooltip);
        oIC.textFieldIntervalMilliseconds.setTooltip(textFieldIntervalMillisecondsTooltip);
        aCIC.textFieldPositionXCoordinate.setTooltip(textFieldXCoordinateTooltip);
        aCIC.textFieldPositionYCoordinate.setTooltip(textFieldYCoordinateTooltip);
    }

    /**
     * Set Tooltip text
     *
     * @param langB
     */
    public static void setTooltipText(ResourceBundle langB) {
        buttonStartTooltip.setText(langB.getString("buttonStartTooltip.text"));
        buttonResetOptionsTooltip.setText(langB.getString("buttonResetOptionsTooltip.text"));
        buttonResetAutoClickerTooltip.setText(langB.getString("buttonResetAutoClickerTooltip.text"));
        buttonResetAutoTextTooltip.setText(langB.getString("buttonResetAutoTextTooltip.text"));
        buttonPickClickPositionTooltip.setText(langB.getString("buttonPickClickPositionTooltip.text"));

        checkBoxStartHotkeyTooltip.setText(langB.getString("checkBoxStartHotkeyTooltip.text"));
        checkBoxHoldClickTooltip.setText(langB.getString("checkBoxHoldClickTooltip.text"));
        checkBoxPasteTextTooltip.setText(langB.getString("checkBoxPasteTextTooltip.text"));
        checkBoxPasteTextLineForLineTooltip.setText(langB.getString("checkBoxPasteTextLineForLineTooltip.text"));

        choiceBoxClickTypeTooltip.setText(langB.getString("choiceBoxClickTypeTooltip.text"));
        choiceBoxMouseKeyTooltip.setText(langB.getString("choiceBoxMouseKeyTooltip.text"));
        choiceBoxReplaceOptionsTooltip.setText(langB.getString("choiceBoxReplaceOptionsTooltip.text"));

        radioButtonAutoClickerTooltip.setText(langB.getString("radioButtonAutoClickerTooltip.text"));
        radioButtonAutoTextTooltip.setText(langB.getString("radioButtonAutoTextTooltip.text"));

        radioButtonQuantityTooltip.setText(langB.getString("radioButtonQuantityTooltip.text"));
        radioButtonDurationTooltip.setText(langB.getString("radioButtonDurationTooltip.text"));
        radioButtonHoldHotkeyTooltip.setText(langB.getString("radioButtonHoldHotkeyTooltip.text"));

        radioButtonSpeedTooltip.setText(langB.getString("radioButtonSpeedTooltip.text"));
        radioButtonIntervalTooltip.setText(langB.getString("radioButtonIntervalTooltip.text"));

        radioButtonMouseKeyTooltip.setText(langB.getString("radioButtonMouseKeyTooltip.text"));
        radioButtonF5KeyTooltip.setText(langB.getString("radioButtonF5KeyTooltip.text"));

        textAreaSplitTooltip.setText(langB.getString("textAreaSplitTooltip.text"));
        textAreaSplitToTooltip.setText(langB.getString("textAreaSplitToTooltip.text"));
        textAreaTextEntryTooltip.setText(langB.getString("textAreaTextEntryTooltip.text"));

        textFieldStartHotkeyTooltip.setText(langB.getString("textFieldStartHotkeyTooltip.text"));

        textFieldStartIntervalDaysTooltip.setText(langB.getString("textFieldStartIntervalDaysTooltip.text"));
        textFieldStartIntervalHoursTooltip.setText(langB.getString("textFieldStartIntervalHoursTooltip.text"));
        textFieldStartIntervalMinutesTooltip.setText(langB.getString("textFieldStartIntervalMinutesTooltip.text"));
        textFieldStartIntervalSecondsTooltip.setText(langB.getString("textFieldStartIntervalSecondsTooltip.text"));

        textFieldQuantityTooltip.setText(langB.getString("textFieldQuantityTooltip.text"));

        textFieldDurationDaysTooltip.setText(langB.getString("textFieldDurationDaysTooltip.text"));
        textFieldDurationHoursTooltip.setText(langB.getString("textFieldDurationHoursTooltip.text"));
        textFieldDurationMinutesTooltip.setText(langB.getString("textFieldDurationMinutesTooltip.text"));
        textFieldDurationSecondsTooltip.setText(langB.getString("textFieldDurationSecondsTooltip.text"));

        textFieldSpeedTooltip.setText(langB.getString("textFieldSpeedTooltip.text"));

        textFieldIntervalDaysTooltip.setText(langB.getString("textFieldIntervalDaysTooltip.text"));
        textFieldIntervalHoursTooltip.setText(langB.getString("textFieldIntervalHoursTooltip.text"));
        textFieldIntervalMinutesTooltip.setText(langB.getString("textFieldIntervalMinutesTooltip.text"));
        textFieldIntervalSecondsTooltip.setText(langB.getString("textFieldIntervalSecondsTooltip.text"));
        textFieldIntervalMillisecondsTooltip.setText(langB.getString("textFieldIntervalMillisecondsTooltip.text"));

        textFieldXCoordinateTooltip.setText(langB.getString("textFieldXCoordinateTooltip.text"));
        textFieldYCoordinateTooltip.setText(langB.getString("textFieldYCoordinateTooltip.text"));
    }

    /**
     * @return isTipsEnabled
     */
    public static boolean isTipsEnabled() {
        return isTipsEnabled;
    }

    /**
     * When CustomTooltips is enabled: isTipsEnabled == true
     * <p>
     * When CustomTooltips is disabled: isTipsEnabled == false
     * </p>
     *
     * @param isTipsEnabled
     */
    public static void setTipsEnabled(boolean isTipsEnabled) {
        CustomTooltips.isTipsEnabled = isTipsEnabled;
    }
}
