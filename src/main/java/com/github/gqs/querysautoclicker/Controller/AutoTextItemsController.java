// Copyright© by getQueryString/Fin

package com.github.gqs.querysautoclicker.Controller;

import com.github.gqs.querysautoclicker.Main.Auto.AutoText;
import com.github.gqs.querysautoclicker.Main.Check;
import com.github.gqs.querysautoclicker.Main.Settings.Use;
import com.github.gqs.querysautoclicker.Personalization.Sounds;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;

public class AutoTextItemsController implements IController {

    public AutoTextItemsController() {
        ControllerRepository.getInstance().register(this);
    }

    public CheckBox checkBoxPasteText;
    public CheckBox checkBoxPasteTextLineForLine;

    public Label labelAutoText;
    public Label labelAutoTextReplace;
    public Label labelAutoTextInputCharCount;

    public TextArea textAreaSplit;
    public TextArea textAreaSplitTo;
    public TextArea textAreaTextEntry;

    public ChoiceBox<String> choiceBoxReplaceOptions;

    /**
     * Check the textAreaSplit input
     */
    @Deprecated
    public void checkSplitTextAreaInput() {
        Check.splitKeyTyped(this);
    }

    /**
     * Use InstantType
     */
    public void instantType() {
        Sounds.playClickSound();
        Use.instantType();
    }

    /**
     * Use LineForLine
     */
    public void lineForLine() {
        Sounds.playClickSound();
        AutoText.setPasteTextLineForLineEnabled(!AutoText.isPasteTextLineForLineEnabled());
    }

    /**
     * Functions to be executed by the {@link AutoTextItemsController} when the program starts
     */
    public void initialize() {
        Check.autoTextReplace(this);
        Check.autoTextInput(this);
    }
}