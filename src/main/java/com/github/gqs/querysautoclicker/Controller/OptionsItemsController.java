// Copyright© by getQueryString/Fin

package com.github.gqs.querysautoclicker.Controller;

import com.github.gqs.querysautoclicker.Main.*;
import com.github.gqs.querysautoclicker.Main.Auto.Start;
import com.github.gqs.querysautoclicker.Main.Settings.Loader;
import com.github.gqs.querysautoclicker.Main.Settings.Use;
import com.github.gqs.querysautoclicker.Personalization.Sounds;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.ScrollEvent;

import java.net.URL;
import java.util.ResourceBundle;

public class OptionsItemsController implements Initializable, IController {

    public OptionsItemsController() {
        ControllerRepository.getInstance().register(this);
    }

    public CheckBox checkBoxStartHotkey;

    public RadioButton radioButtonAutoClicker;
    public RadioButton radioButtonAutoText;
    public RadioButton radioButtonQuantity;
    public RadioButton radioButtonDuration;
    public RadioButton radioButtonHoldHotkey;
    public RadioButton radioButtonSpeed;
    public RadioButton radioButtonInterval;

    public Label labelOptions;
    public Label labelStartInterval;
    public Label labelStartIntervalDays;
    public Label labelStartIntervalHours;
    public Label labelStartIntervalMinutes;
    public Label labelStartIntervalSeconds;
    public Label labelDurationDays;
    public Label labelDurationHours;
    public Label labelDurationMinutes;
    public Label labelDurationSeconds;
    public Label labelAutoSpeed;
    public Label labelIntervalDays;
    public Label labelIntervalHours;
    public Label labelIntervalMinutes;
    public Label labelIntervalSeconds;
    public Label labelIntervalMilliseconds;

    public TextField textFieldStartHotkey;
    public TextField textFieldStartIntervalDays;
    public TextField textFieldStartIntervalHours;
    public TextField textFieldStartIntervalMinutes;
    public TextField textFieldStartIntervalSeconds;
    public TextField textFieldQuantity;
    public TextField textFieldDurationDays;
    public TextField textFieldDurationHours;
    public TextField textFieldDurationMinutes;
    public TextField textFieldDurationSeconds;
    public TextField textFieldSpeed;
    public TextField textFieldIntervalDays;
    public TextField textFieldIntervalHours;
    public TextField textFieldIntervalMinutes;
    public TextField textFieldIntervalSeconds;
    public TextField textFieldIntervalMilliseconds;

    /**
     * Set Start/Stop hotkey
     */
    public void setStartHotkeyActive() {
        Sounds.playClickSound();
        this.textFieldStartHotkey.setDisable(!this.textFieldStartHotkey.isDisabled());
    }

    @Deprecated
    public void setStartHotkey(KeyEvent e) {
        Start.setStartHotkey(e);
    }

    /**
     * Choice between AutoClicker & AutoText
     */
    public void useAutoClicker() {
        Sounds.playClickSound();
        Use.autoClicker();
    }

    public void useAutoText() {
        Sounds.playClickSound();
        Use.autoText();
    }

    /**
     * Choice between Quantity, Duration and HoldHotkey
     */
    public void useQuantity() {
        Sounds.playClickSound();
        Use.quantity();
    }

    public void useDuration() {
        Sounds.playClickSound();
        Use.duration();
    }

    public void useHoldHotkey() {
        Sounds.playClickSound();
        Use.holdHotkey();
    }

    /**
     * Choice between Speed and Interval
     */
    public void useSpeed() {
        Sounds.playClickSound();
        Use.speed();
    }

    public void useInterval() {
        Sounds.playClickSound();
        Use.interval();
    }

    /**
     * Increase or decrease the value of Options TextFields inputs when scrolled
     *
     * @param e
     */
    public void incrementOnScroll(ScrollEvent e) {
        Loader.incrementOnScroll(e);
    }

    /**
     * Mark default values of Options TextFields if the default value is still contains
     */
    public void selectStandardValue() {
        Check.selectStandardValue();
    }

    /**
     * Functions to be executed by the {@link OptionsItemsController} when the program starts
     */
    public void initialize(URL url, ResourceBundle rb) {
        // Disable StartHotkey when StartHotkey is no longer focused
        Check.startHotkey();

        Loader.addTextFieldToGroup();

        Check.addTextFieldToGroup();
        Check.checkTextFieldInputs();
    }
}