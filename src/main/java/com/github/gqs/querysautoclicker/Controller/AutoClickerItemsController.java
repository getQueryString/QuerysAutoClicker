// Copyright© by getQueryString/Fin

package com.github.gqs.querysautoclicker.Controller;

import com.github.gqs.querysautoclicker.Main.Auto.AutoClicker;
import com.github.gqs.querysautoclicker.Main.Settings.Disable;
import com.github.gqs.querysautoclicker.Main.Settings.Enable;
import com.github.gqs.querysautoclicker.Main.Settings.Use;
import com.github.gqs.querysautoclicker.Personalization.Sounds;
import javafx.scene.control.*;

public class AutoClickerItemsController implements IController {

    public AutoClickerItemsController() {
        ControllerRepository.getInstance().register(this);
    }

    public Button buttonPickClickPosition;

    public CheckBox checkBoxHoldClick;

    public Label labelAutoClicker;
    public Label labelSettings;
    public Label labelClickType;
    public Label labelKey;
    public Label labelPosition;
    public Label labelPositionX;
    public Label labelPositionY;

    public RadioButton radioButtonMouseKey;
    public RadioButton radioButtonF5;

    public TextField textFieldPositionXCoordinate;
    public TextField textFieldPositionYCoordinate;

    public ChoiceBox<String> choiceBoxClickType;
    public ChoiceBox<String> choiceBoxMouseKey;

    /**
     * Enable/Disable HoldClick
     */
    public void holdClick() {
        Sounds.playClickSound();
        AutoClicker.setHoldClickEnabled(!AutoClicker.isHoldClickEnabled());
        if (AutoClicker.isHoldClickEnabled()) {
            Use.mouseKey();
            Enable.holdClick();
        } else
            Disable.holdClick();
    }

    /**
     * Pick click position
     */
    public void pickClickPosition() {
        Sounds.playClickSound();
        Enable.pickClickPosition();
    }

    /**
     * Choice between MouseKey and F5Key
     */
    public void useMouseKey() {
        Sounds.playClickSound();
        Use.mouseKey();
    }

    public void useF5() {
        Sounds.playClickSound();
        Use.f5Key();
    }

    /**
     * Functions to be executed by the {@link AutoClickerItemsController} when the program starts
     */
    public void initialize() {
    }
}