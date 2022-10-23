// Copyright© by getQueryString/Fin

package com.github.gqs.querysautoclicker.Main;

import com.github.gqs.querysautoclicker.Controller.AutoTextItemsController;
import com.github.gqs.querysautoclicker.Controller.ControllerRepository;
import com.github.gqs.querysautoclicker.Controller.OptionsItemsController;
import com.github.gqs.querysautoclicker.Main.Auto.AutoText;
import com.github.gqs.querysautoclicker.Main.Settings.Disable;
import com.github.gqs.querysautoclicker.Personalization.MainWindow;
import com.github.gqs.querysautoclicker.Personalization.Sounds;
import javafx.scene.control.TextField;

import java.util.ArrayList;

public class Check {

    private static final OptionsItemsController oIC = (OptionsItemsController) ControllerRepository.getInstance().getController(OptionsItemsController.class);

    private static final int WARNING_AUTOTEXT_TEXT_INPUT_LENGTH = 500000;
    private static final int MAX_AUTOTEXT_TEXT_INPUT_LENGTH = 524288; // 2^19 = 524,288
    private static final int MAX_TEXTAREA_SPLIT_INPUT_LENGTH = 256; // 2^8 = 256

    private static boolean isDurationEmpty = false;
    private static boolean isIntervalEmpty = false;

    private static final ArrayList<TextField> textFieldToGroup = new ArrayList<>();

    /**
     * Disable setting of StartHotkey when checkBoxStartHotkey is no longer focused.
     */
    public static void startHotkey() {
        oIC.checkBoxStartHotkey.focusedProperty().addListener((observable, noLongerFocused, focused) -> {
            if (noLongerFocused) {
                oIC.checkBoxStartHotkey.setSelected(false);
                Disable.startHotkeyTextField();
            }
        });
    }

    /**
     * Add StartInterval, Duration and Interval TextFields to ArrayList textFieldToGroup
     */
    public static void addTextFieldToGroup() {
        textFieldToGroup.add(oIC.textFieldStartIntervalDays);
        textFieldToGroup.add(oIC.textFieldStartIntervalHours);
        textFieldToGroup.add(oIC.textFieldStartIntervalMinutes);
        textFieldToGroup.add(oIC.textFieldStartIntervalSeconds);
        textFieldToGroup.add(oIC.textFieldDurationDays);
        textFieldToGroup.add(oIC.textFieldDurationHours);
        textFieldToGroup.add(oIC.textFieldDurationMinutes);
        textFieldToGroup.add(oIC.textFieldDurationSeconds);
        textFieldToGroup.add(oIC.textFieldIntervalDays);
        textFieldToGroup.add(oIC.textFieldIntervalHours);
        textFieldToGroup.add(oIC.textFieldIntervalMinutes);
        textFieldToGroup.add(oIC.textFieldIntervalSeconds);
        textFieldToGroup.add(oIC.textFieldIntervalMilliseconds);
    }

    /**
     * Check TextField inputs
     */
    public static void checkTextFieldInputs() {
        quantity();
        speed();
        timeTextFieldInput();
        setStandardValueInEmptyTimeTextField();
    }

    /**
     * Check Quantity TextField input
     */
    private static void quantity() {
        oIC.textFieldQuantity.textProperty().addListener((observable, oldValue, newValue) -> {
            try {
                if (!newValue.matches("^-?\\d{0,8}$")
                        || oIC.textFieldQuantity.getText().startsWith("0")
                        || oIC.textFieldQuantity.getText().startsWith("-0")
                        || Integer.parseInt(oIC.textFieldQuantity.getText()) < -1)
                    oIC.textFieldQuantity.setText(oldValue);
            } catch (NumberFormatException ignored) {
            }
        });
        // Set standard value
        oIC.textFieldQuantity.focusedProperty().addListener((observable, wasFocused, isNowFocused) -> {
            if (wasFocused && oIC.textFieldQuantity.getText().isEmpty() || oIC.textFieldQuantity.getText().equals("-"))
                oIC.textFieldQuantity.setText("-1");
        });
    }

    /**
     * Check Speed TextField input
     */
    private static void speed() {
        oIC.textFieldSpeed.textProperty().addListener((observable, oldValue, newValue) -> {
            try {
                if (!newValue.matches("^\\d{0,3}$") || oIC.textFieldSpeed.getText().startsWith("0"))
                    oIC.textFieldSpeed.setText(oldValue);
                if (Integer.parseInt(oIC.textFieldSpeed.getText()) >= 200)
                    oIC.textFieldSpeed.setStyle("-fx-text-fill: red;");
                else oIC.textFieldSpeed.setStyle("-fx-focus-decoration: none;");
            } catch (NumberFormatException ignored) {
            }
        });
        // Set standard value
        oIC.textFieldSpeed.focusedProperty().addListener((observable, wasFocused, isNowFocused) -> {
            if (wasFocused && oIC.textFieldSpeed.getLength() == 0)
                oIC.textFieldSpeed.setText("5");
        });
    }

    /**
     * Check entries in the text fields
     */
    private static void timeTextFieldInput() {
        for (TextField textField : textFieldToGroup) {
            textField.textProperty().addListener((observable, oldValue, newValue) -> {
                try {
                    if (!newValue.matches("^\\d{0,8}$") || (textField.getText().startsWith("0") && textField.getLength() > 1))
                        textField.setText(oldValue);
                    if (Integer.parseInt(oIC.textFieldIntervalDays.getText()) == 0
                            && Integer.parseInt(oIC.textFieldIntervalHours.getText()) == 0
                            && Integer.parseInt(oIC.textFieldIntervalMinutes.getText()) == 0
                            && Integer.parseInt(oIC.textFieldIntervalSeconds.getText()) == 0
                            && Integer.parseInt(oIC.textFieldIntervalMilliseconds.getText()) <= 5
                            && Integer.parseInt(oIC.textFieldIntervalMilliseconds.getText()) > 0)
                        oIC.textFieldIntervalMilliseconds.setStyle("-fx-text-fill: red;");
                    else oIC.textFieldIntervalMilliseconds.setStyle("-fx-focus-decoration: none;");
                } catch (NumberFormatException ignored) {
                }
            });
        }
    }

    /**
     * Set standard value in empty text boxes
     */
    private static void setStandardValueInEmptyTimeTextField() {
        for (TextField textField : textFieldToGroup) {
            textField.focusedProperty().addListener((observable, wasFocused, isNowFocused) -> {
                if (wasFocused && textField.getText().isEmpty())
                    textField.setText("0");
            });
        }
    }

    /**
     * Mark default values of Options TextFields if the default value is still contains
     */
    public static void selectStandardValue() {
        try {
            selectStandardQuantityValue();
            selectStandardSpeedValue();
            for (TextField textField : textFieldToGroup) {
                if (textField.isFocused() && Integer.parseInt(textField.getText()) == 0)
                    textField.selectAll();
            }
        } catch (NumberFormatException ignored) {
        }
    }

    /**
     * Mark default values of Quantity TextField
     */
    private static void selectStandardQuantityValue() {
        if (oIC.textFieldQuantity.isFocused() && Integer.parseInt(oIC.textFieldQuantity.getText()) == -1)
            oIC.textFieldQuantity.selectAll();
    }

    /**
     * Mark default values of Speed TextField
     */
    private static void selectStandardSpeedValue() {
        if (oIC.textFieldSpeed.isFocused() && Integer.parseInt(oIC.textFieldSpeed.getText()) == 5)
            oIC.textFieldSpeed.selectAll();
    }

    /**
     * Check text input from textAreaSplit for characters that occur more than once if textAreaSplit is not empty and the Replace option "Individual Letters" is selected
     *
     * @param aTIC
     */
    public static void splitKeyTyped(AutoTextItemsController aTIC) {
        if (!aTIC.textAreaSplit.getText().isEmpty() && aTIC.choiceBoxReplaceOptions.getSelectionModel().getSelectedIndex() == 2) {
            aTIC.textAreaSplit.setStyle("-fx-focus-decoration: none;");
            int charCount;

            // Converts given string into character array
            char[] splitInput = aTIC.textAreaSplit.getText().toCharArray();

            // Counts each character present in the string
            for (int i = 0; i < splitInput.length; i++) {
                charCount = 1;
                for (int j = i + 1; j < splitInput.length; j++) {
                    if (splitInput[i] == splitInput[j]) {
                        charCount++;
                        // Set splitInput[j] to 0 to avoid printing visited character
                        splitInput[j] = '0';
                    }
                }
                // A character is considered as duplicate if count is greater than 1
                if (charCount > 1 || aTIC.textAreaSplit.getLength() > MAX_TEXTAREA_SPLIT_INPUT_LENGTH) {
                    Sounds.playWarnSound();
                    aTIC.textAreaSplit.deletePreviousChar();
                    aTIC.textAreaSplit.setStyle("-fx-focus-color: red;");
                }
            }
        } else aTIC.textAreaSplit.setStyle("-fx-focus-decoration: none;");
    }

    /**
     * Set {@link AutoText}.setReplaceEnabled() to true if the Replace option is not "None" and textAreaSplit is not empty
     *
     * @param aTIC
     */
    public static void autoTextReplace(AutoTextItemsController aTIC) {
        aTIC.choiceBoxReplaceOptions.setOnAction((v) -> {
            AutoText.setReplaceEnabled(aTIC.choiceBoxReplaceOptions.getSelectionModel().getSelectedIndex() > 0
                    && !aTIC.textAreaSplit.getText().isEmpty());
            if (aTIC.choiceBoxReplaceOptions.getSelectionModel().getSelectedIndex() != 2)
                aTIC.textAreaSplit.setStyle("-fx-focus-decoration: none;");
            splitKeyTyped(aTIC);
        });
        aTIC.textAreaSplit.textProperty().addListener((observable, oV, nV) ->
                AutoText.setReplaceEnabled(aTIC.choiceBoxReplaceOptions.getSelectionModel().getSelectedIndex() > 0
                        && !aTIC.textAreaSplit.getText().isEmpty()));
    }

    /**
     * Set maximum number of characters in textAreaTextEntry to 524,288
     *
     * @param aTIC
     */
    public static void autoTextInput(AutoTextItemsController aTIC) {
        aTIC.textAreaTextEntry.textProperty().addListener((observable, oldValue, newValue) -> {
            aTIC.labelAutoTextInputCharCount.setText(aTIC.textAreaTextEntry.getText().length() + "/" + MAX_AUTOTEXT_TEXT_INPUT_LENGTH);

            if (aTIC.textAreaTextEntry.getText().length() > WARNING_AUTOTEXT_TEXT_INPUT_LENGTH)
                aTIC.labelAutoTextInputCharCount.setStyle("-fx-text-fill: darkred;");
            else aTIC.labelAutoTextInputCharCount.setStyle("-fx-text-fill: black;");

            if (aTIC.textAreaTextEntry.getText().length() > MAX_AUTOTEXT_TEXT_INPUT_LENGTH) {
                aTIC.textAreaTextEntry.setText(oldValue);
                aTIC.textAreaTextEntry.setScrollTop(Double.MAX_VALUE);
            }
        });
    }

    /**
     * Do not start AutoText/AutoStart if the text box inputs of options are inadmissible
     *
     * @throws InterruptedException
     */
    public static void options(int DURATION_DAYS, int DURATION_HOURS, int DURATION_MINUTES, int DURATION_SECONDS, int INTERVAL_DAYS, int INTERVAL_HOURS, int INTERVAL_MINUTES, int INTERVAL_SECONDS, int INTERVAL_MILLISECONDS) throws InterruptedException {
        if (oIC.radioButtonDuration.isSelected() && DURATION_DAYS == 0 && DURATION_HOURS == 0 && DURATION_MINUTES == 0 && DURATION_SECONDS == 0)
            setDurationEmpty(true);
        if (oIC.radioButtonInterval.isSelected() && INTERVAL_DAYS == 0 && INTERVAL_HOURS == 0 && INTERVAL_MINUTES == 0 && INTERVAL_SECONDS == 0 && INTERVAL_MILLISECONDS == 0)
            setIntervalEmpty(true);
        if (isDurationEmpty() && isIntervalEmpty()) {
            Check.setDurationEmpty(false);
            Check.setIntervalEmpty(false);
            MainWindow.error(MainWindow.getErrorMessageDurationAndIntervalIsEmpty());
        } else if (isDurationEmpty()) {
            Check.setDurationEmpty(false);
            MainWindow.error(MainWindow.getErrorMessageDurationIsEmpty());
        } else if (isIntervalEmpty()) {
            Check.setIntervalEmpty(false);
            MainWindow.error(MainWindow.getErrorMessageIntervalIsEmpty());
        }
    }

    /**
     * @return isDurationEmpty
     */
    public static boolean isDurationEmpty() {
        return isDurationEmpty;
    }

    /**
     * When the TextFields of Duration are empty: isDurationEmpty == true
     * <p>
     * When the TextFields of Duration are not empty: isDurationEmpty == false
     * </p>
     */
    public static void setDurationEmpty(boolean isDurationEmpty) {
        Check.isDurationEmpty = isDurationEmpty;
    }

    /**
     * @return isIntervalEmpty
     */
    public static boolean isIntervalEmpty() {
        return isIntervalEmpty;
    }

    /**
     * When the TextFields of Interval are empty: isIntervalEmpty == true
     * <p>
     * When the TextFields of Interval are not empty: isIntervalEmpty == false
     * </p>
     */
    public static void setIntervalEmpty(boolean isIntervalEmpty) {
        Check.isIntervalEmpty = isIntervalEmpty;
    }
}