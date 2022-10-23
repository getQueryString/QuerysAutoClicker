// Copyright© by Fin

package com.github.gqs.querysautoclicker.Personalization;

import com.github.gqs.querysautoclicker.Controller.*;
import com.github.gqs.querysautoclicker.Main.Auto.AutoClicker;
import com.github.gqs.querysautoclicker.Main.Auto.AutoText;
import com.github.gqs.querysautoclicker.Main.CustomTooltips;
import com.github.gqs.querysautoclicker.Main.Net.Update;
import com.github.gqs.querysautoclicker.Main.RecommendQAC;
import javafx.scene.control.RadioMenuItem;
import javafx.scene.control.ToggleGroup;

import java.io.IOException;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.ResourceBundle;

public class Language {

    private static String selectedLanguage;

    public static final Map<String, RadioMenuItem> languageToGroup = new HashMap<>();

    private static final MainController mC = (MainController) ControllerRepository.getInstance().getController(MainController.class);
    private static final OptionsItemsController oIC = (OptionsItemsController) ControllerRepository.getInstance().getController(OptionsItemsController.class);
    private static final AutoClickerItemsController aCIC = (AutoClickerItemsController) ControllerRepository.getInstance().getController(AutoClickerItemsController.class);
    private static final AutoTextItemsController aTIC = (AutoTextItemsController) ControllerRepository.getInstance().getController(AutoTextItemsController.class);

    private static final ToggleGroup toggleGroupLanguage = new ToggleGroup();

    public static Locale languageLocale;
    public static ResourceBundle languageResourceBundle;

    /**
     * Set language ToggleGroup
     */
    public static void setLanguageToggleGroup() {
        languageToGroup.values().forEach(t -> t.setToggleGroup(toggleGroupLanguage));
    }

    /**
     * Add languages to ArrayList languageToGroup
     */
    public static void addLanguageToGroup() {
        languageToGroup.put("eng", mC.radioMenuItemLanguageEng);
        languageToGroup.put("fre", mC.radioMenuItemLanguageFre);
        languageToGroup.put("ger", mC.radioMenuItemLanguageGer);
        languageToGroup.put("rus", mC.radioMenuItemLanguageRus);
        languageToGroup.put("spa", mC.radioMenuItemLanguageSpa);
    }

    /**
     * Change language
     *
     * @param language
     * @throws IOException
     */
    public static void changeLanguage(String language) throws IOException {
        if (!language.equals(getSelectedLanguage())) {
            RecommendQAC.hideCopiedMessage();
            MainWindow.hideErrorMessage();
            set(language);
            PersonalizationConfig.setValues();
        }
    }

    /**
     * Set selected language
     *
     * @param language
     */
    public static void set(String language) {
        if (!language.equals(getSelectedLanguage())) {
            setSelectedLanguage(language);
            RadioMenuItem radioMenuItem = languageToGroup.get(language);
            if (!radioMenuItem.isSelected())
                radioMenuItem.setSelected(true);
            loadWindowLanguage(language);
        }
    }

    /**
     * Apply selected language to the QuerysAutoClicker window
     *
     * @param locale
     */
    private static void loadWindowLanguage(String locale) {
        languageLocale = new Locale(locale);
        languageResourceBundle = ResourceBundle.getBundle("Languages/lang", languageLocale);
        setText(languageResourceBundle);
        if (CustomTooltips.isTipsEnabled())
            CustomTooltips.setTooltipText(languageResourceBundle);
    }

    /**
     * Set language
     *
     * @param langB
     */
    private static void setText(ResourceBundle langB) {
        setCheckForUpdatesAlertLanguage(langB);
        setContainersLanguage(langB);
    }

    /**
     * Set language of {@link Update}.alertCheckForUpdate
     *
     * @param langB
     */
    private static void setCheckForUpdatesAlertLanguage(ResourceBundle langB) {
        Update.alertCheckForUpdatesHeaderText = langB.getString("alertCheckForUpdatesHeaderText.text");
        Update.alertCheckForUpdatesNewUpdateHeaderText = langB.getString("alertCheckForUpdatesNewUpdateHeaderText.text");
        Update.alertCheckForUpdatesNewUpdateContentText = langB.getString("alertCheckForUpdatesNewUpdateContentText.text");
        Update.alertCheckForUpdatesCurrentVersionText = langB.getString("alertCheckForUpdatesCurrentVersionText.text");
    }

    /**
     * Set language of Containers
     *
     * @param langB
     */
    private static void setContainersLanguage(ResourceBundle langB) {
        mC.buttonStart.setText(langB.getString("buttonStart.text"));
        mC.buttonStop.setText(langB.getString("buttonStop.text"));
        mC.buttonResetOptions.setText(langB.getString("buttonResetOptions.text"));
        mC.buttonResetAutoClicker.setText(langB.getString("buttonResetAutoClicker.text"));
        mC.buttonResetAutoText.setText(langB.getString("buttonResetAutoText.text"));
        aCIC.buttonPickClickPosition.setText(langB.getString("buttonPickClickPosition.text"));

        oIC.checkBoxStartHotkey.setText(langB.getString("checkBoxStartHotkey.text"));
        aCIC.checkBoxHoldClick.setText(langB.getString("checkBoxHoldClick.text"));
        aTIC.checkBoxPasteText.setText(langB.getString("checkBoxAutoTextPaste.text"));
        aTIC.checkBoxPasteTextLineForLine.setText(langB.getString("checkBoxPasteTextLineForLine.text"));

        mC.checkMenuItemTips.setText(langB.getString("checkMenuItemTips.text"));
        mC.checkMenuItemSounds.setText(langB.getString("checkMenuItemSounds.text"));
        mC.checkMenuItemAutoCheckForUpdates.setText(langB.getString("autoCheckForUpdates.text"));

        // ChoiceBox: Click type
        AutoClicker.setClickTypeIndex(aCIC.choiceBoxClickType.getSelectionModel().getSelectedIndex());

        aCIC.choiceBoxClickType.getItems().clear();
        aCIC.choiceBoxClickType.getItems().addAll(
                langB.getString("choiceBoxClickTypeSingle.text"),
                langB.getString("choiceBoxClickTypeDouble.text"),
                langB.getString("choiceBoxClickTypeTriple.text")
        );

        if (AutoClicker.getClickTypeIndex() >= 0) {
            aCIC.choiceBoxClickType.getSelectionModel().select(AutoClicker.getClickTypeIndex());
        } else if (aCIC.choiceBoxClickType.getValue() == null) {
            aCIC.choiceBoxClickType.getSelectionModel().selectFirst();
        }

        // ChoiceBox: Mouse button
        AutoClicker.setMouseButtonIndex(aCIC.choiceBoxMouseKey.getSelectionModel().getSelectedIndex());

        aCIC.choiceBoxMouseKey.getItems().clear();
        aCIC.choiceBoxMouseKey.getItems().addAll(
                langB.getString("choiceBoxMouseKeyLeft.text"),
                langB.getString("choiceBoxMouseKeyWheel.text"),
                langB.getString("choiceBoxMouseKeyRight.text")
        );

        if (AutoClicker.getMouseButtonIndex() >= 0) {
            aCIC.choiceBoxMouseKey.getSelectionModel().select(AutoClicker.getMouseButtonIndex());
        } else if (aCIC.choiceBoxMouseKey.getValue() == null) {
            aCIC.choiceBoxMouseKey.getSelectionModel().selectFirst();
        }

        // ChoiceBox: Replace
        AutoText.setReplaceIndex(aTIC.choiceBoxReplaceOptions.getSelectionModel().getSelectedIndex());

        aTIC.choiceBoxReplaceOptions.getItems().clear();
        aTIC.choiceBoxReplaceOptions.getItems().addAll(
                langB.getString("choiceBoxReplaceOptionsNone.text"),
                langB.getString("choiceBoxReplaceOptionsString.text"),
                langB.getString("choiceBoxReplaceOptionsIndividualCharacters.text")
        );

        if (AutoText.getReplaceIndex() >= 0) {
            aTIC.choiceBoxReplaceOptions.getSelectionModel().select(AutoText.getReplaceIndex());
        } else if (aTIC.choiceBoxReplaceOptions.getValue() == null) {
            aTIC.choiceBoxReplaceOptions.getSelectionModel().selectFirst();
        }

        oIC.labelOptions.setText(langB.getString("labelOptions.text"));
        oIC.labelStartInterval.setText(langB.getString("labelStartInterval.text"));
        oIC.labelStartIntervalDays.setText(langB.getString("labelStartIntervalDays.text"));
        oIC.labelStartIntervalHours.setText(langB.getString("labelStartIntervalHours.text"));
        oIC.labelStartIntervalMinutes.setText(langB.getString("labelStartIntervalMinutes.text"));
        oIC.labelStartIntervalSeconds.setText(langB.getString("labelStartIntervalSeconds.text"));

        oIC.labelDurationDays.setText(langB.getString("labelDurationDays.text"));
        oIC.labelDurationHours.setText(langB.getString("labelDurationHours.text"));
        oIC.labelDurationMinutes.setText(langB.getString("labelDurationMinutes.text"));
        oIC.labelDurationSeconds.setText(langB.getString("labelDurationSeconds.text"));

        oIC.labelIntervalDays.setText(langB.getString("labelIntervalDays.text"));
        oIC.labelIntervalHours.setText(langB.getString("labelIntervalHours.text"));
        oIC.labelIntervalMinutes.setText(langB.getString("labelIntervalMinutes.text"));
        oIC.labelIntervalSeconds.setText(langB.getString("labelIntervalSeconds.text"));
        oIC.labelIntervalMilliseconds.setText(langB.getString("labelIntervalMilliseconds.text"));

        aCIC.labelSettings.setText(langB.getString("labelSettings.text"));
        aCIC.labelClickType.setText(langB.getString("labelClickType.text"));
        aCIC.labelPosition.setText(langB.getString("labelPosition.text"));
        aCIC.labelKey.setText(langB.getString("labelKey.text"));
        aTIC.labelAutoTextReplace.setText(langB.getString("labelAutoTextReplace.text"));

        mC.menuFile.setText(langB.getString("menuFile.text"));
        mC.menuWindow.setText(langB.getString("menuWindow.text"));
        mC.menuWindowDesign.setText(langB.getString("menuWindowDesign.text"));
        mC.menuChangeLanguage.setText(langB.getString("menuChangeLanguage.text"));
        mC.menuHelp.setText(langB.getString("menuHelp.text"));
        mC.labelRecommendQAC.setText(langB.getString("labelRecommendQAC.text"));
        RecommendQAC.setRecommendText(langB.getString("recommendText.text"));
        MainWindow.setErrorMessageDurationIsEmpty(langB.getString("errorMessageDurationIsEmpty.text"));
        MainWindow.setErrorMessageIntervalIsEmpty(langB.getString("errorMessageIntervalIsEmpty.text"));
        MainWindow.setErrorMessageDurationAndIntervalIsEmpty(langB.getString("errorMessageDurationAndIntervalIsEmpty.text"));
        MainWindow.setErrorMessageAutoTextTextInputIsEmpty(langB.getString("errorMessageAutoTextTextInputIsEmpty.text"));
        MainWindow.setErrorMessageInvalidRegexInput(langB.getString("errorMessageInvalidRegexInput.text"));

        mC.menuItemSourceCode.setText(langB.getString("menuItemSourceCode.text"));
        mC.menuItemExit.setText(langB.getString("menuItemExit.text"));
        mC.menuItemRecommendQAC.setText(langB.getString("menuItemRecommendQAC.text"));

        oIC.radioButtonQuantity.setText(langB.getString("radioButtonQuantity.text"));
        oIC.radioButtonDuration.setText(langB.getString("radioButtonDuration.text"));
        oIC.radioButtonHoldHotkey.setText(langB.getString("radioButtonHoldHotkey.text"));
        oIC.radioButtonSpeed.setText(langB.getString("radioButtonSpeed.text"));
        oIC.radioButtonInterval.setText(langB.getString("radioButtonInterval.text"));
        aCIC.radioButtonMouseKey.setText(langB.getString("radioButtonMouseKey.text"));

        mC.checkMenuItemDesignBorderRadius.setText(langB.getString("checkMenuItemDesignBorderRadius.text"));
        mC.radioMenuItemDesignBlue.setText(langB.getString("radioMenuItemDesignBlue.text"));
        mC.radioMenuItemDesignGray.setText(langB.getString("radioMenuItemDesignGray.text"));
        mC.radioMenuItemDesignGreen.setText(langB.getString("radioMenuItemDesignGreen.text"));
        mC.radioMenuItemDesignOrange.setText(langB.getString("radioMenuItemDesignOrange.text"));
        mC.radioMenuItemDesignPink.setText(langB.getString("radioMenuItemDesignPink.text"));
        mC.radioMenuItemDesignRed.setText(langB.getString("radioMenuItemDesignRed.text"));
        mC.radioMenuItemDesignHacker.setText(langB.getString("radioMenuItemDesignHacker.text"));

        mC.radioMenuItemLanguageEng.setText(langB.getString("radioMenuItemLanguageEng.text"));
        mC.radioMenuItemLanguageFre.setText(langB.getString("radioMenuItemLanguageFre.text"));
        mC.radioMenuItemLanguageGer.setText(langB.getString("radioMenuItemLanguageGer.text"));
        mC.radioMenuItemLanguageRus.setText(langB.getString("radioMenuItemLanguageRus.text"));
        mC.radioMenuItemLanguageSpa.setText(langB.getString("radioMenuItemLanguageSpa.text"));

        aCIC.textFieldPositionXCoordinate.setPromptText(langB.getString("textFieldPositionXCoordinate.promptText"));
        aCIC.textFieldPositionYCoordinate.setPromptText(langB.getString("textFieldPositionYCoordinate.promptText"));

        aTIC.textAreaTextEntry.setPromptText(langB.getString("textAreaTextEntry.promptText"));
        aTIC.textAreaSplit.setPromptText(langB.getString("textAreaSplit.promptText"));
        aTIC.textAreaSplitTo.setPromptText(langB.getString("textAreaSplitTo.promptText"));
    }

    /**
     * @return selectedLanguage
     */
    public static String getSelectedLanguage() {
        return selectedLanguage;
    }

    /**
     * Set the abbreviation of the currently selected language to selectedLanguage
     *
     * @param selectedLanguage
     */
    public static void setSelectedLanguage(String selectedLanguage) {
        Language.selectedLanguage = selectedLanguage;
    }
}