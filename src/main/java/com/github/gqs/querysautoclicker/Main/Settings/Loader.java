// Copyright© by getQueryString/Fin

package com.github.gqs.querysautoclicker.Main.Settings;

import com.github.gqs.querysautoclicker.Controller.ControllerRepository;
import com.github.gqs.querysautoclicker.Controller.OptionsItemsController;
import javafx.scene.control.TextField;
import javafx.scene.input.ScrollEvent;

import java.util.ArrayList;
import java.util.HashMap;

public class Loader {

    public static HashMap<String, String> autoClickerValues = new HashMap<>();
    public static HashMap<String, String> autoTextValues = new HashMap<>();

    public static ArrayList<TextField> textFieldToGroup = new ArrayList<>();

    private static final String[] keys = {"StartIntervalDays", "StartIntervalHours", "StartIntervalMinutes", "StartIntervalSeconds",
            "Quantity", "DurationDays", "DurationHours", "DurationMinutes", "DurationSeconds",
            "Speed", "IntervalDays", "IntervalHours", "IntervalMinutes", "IntervalSeconds", "IntervalMilliseconds"};

    private static final OptionsItemsController oIC = (OptionsItemsController) ControllerRepository.getInstance().getController(OptionsItemsController.class);

    /**
     * Add StartInterval, Quantity, Duration, Speed and Interval TextFields to ArrayList textFieldToGroup
     */
    public static void addTextFieldToGroup() {
        textFieldToGroup.add(oIC.textFieldStartIntervalDays);
        textFieldToGroup.add(oIC.textFieldStartIntervalHours);
        textFieldToGroup.add(oIC.textFieldStartIntervalMinutes);
        textFieldToGroup.add(oIC.textFieldStartIntervalSeconds);
        textFieldToGroup.add(oIC.textFieldQuantity);
        textFieldToGroup.add(oIC.textFieldDurationDays);
        textFieldToGroup.add(oIC.textFieldDurationHours);
        textFieldToGroup.add(oIC.textFieldDurationMinutes);
        textFieldToGroup.add(oIC.textFieldDurationSeconds);
        textFieldToGroup.add(oIC.textFieldSpeed);
        textFieldToGroup.add(oIC.textFieldIntervalDays);
        textFieldToGroup.add(oIC.textFieldIntervalHours);
        textFieldToGroup.add(oIC.textFieldIntervalMinutes);
        textFieldToGroup.add(oIC.textFieldIntervalSeconds);
        textFieldToGroup.add(oIC.textFieldIntervalMilliseconds);
    }

    /**
     * Auto clicker values
     */
    public static void autoClickerOptionValues() {
        saveAutoTextValues();
        if (autoClickerValues.size() == 0) {
            for (TextField textField : textFieldToGroup) {
                textField.setText("0");
            }
            oIC.textFieldQuantity.setText("-1");
            oIC.textFieldSpeed.setText("5");
        } else {
            for (int i = 0; i < keys.length; i++) {
                textFieldToGroup.get(i).setText(autoClickerValues.get(keys[i]));
            }
        }
    }

    /**
     * AutoText values
     */
    public static void autoTextOptionValues() {
        saveAutoClickerValues();
        if (autoTextValues.size() == 0) {
            for (TextField textField : textFieldToGroup) {
                textField.setText("0");
            }
            oIC.textFieldQuantity.setText("-1");
            oIC.textFieldSpeed.setText("5");
        } else {
            for (int i = 0; i < keys.length; i++) {
                textFieldToGroup.get(i).setText(autoTextValues.get(keys[i]));
            }
        }
    }

    /**
     * Increase or decrease the value of Options TextFields inputs when scrolled
     *
     * @param e
     */
    public static void incrementOnScroll(ScrollEvent e) {
        double delta = e.getDeltaY();
        for (TextField textField : textFieldToGroup) {
            if (textField.isHover()) {
                if (textField.isDisabled() || !textField.isVisible() || !textField.isEditable()
                        || (Integer.parseInt(textField.getText()) <= -1 && delta < 0) || delta == 0.0) return;
                int increment = delta < 0 ? -1 : +1;
                textField.setText(String.valueOf(Integer.parseInt(textField.getText()) + increment));
            }
        }
    }

    /**
     * Save text field input from AutoClicker
     */
    private static void saveAutoClickerValues() {
        for (int i = 0; i < keys.length; i++) {
            autoClickerValues.put(keys[i], textFieldToGroup.get(i).getText());
        }
    }

    /**
     * Save text field input from AutoText
     */
    private static void saveAutoTextValues() {
        for (int i = 0; i < keys.length; i++) {
            autoTextValues.put(keys[i], textFieldToGroup.get(i).getText());
        }
    }
}