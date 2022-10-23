// Copyright© by Fin

package com.github.gqs.querysautoclicker.Personalization;

import com.github.gqs.querysautoclicker.Controller.ControllerRepository;
import com.github.gqs.querysautoclicker.Controller.MainController;
import com.github.gqs.querysautoclicker.Main.Net.Update;
import com.github.gqs.querysautoclicker.Utils.UtilsOS;

import java.io.*;

import static com.github.gqs.querysautoclicker.Utils.UtilsOS.OS.WINDOWS;

public class PersonalizationConfig {

    private final MainController mC = (MainController) ControllerRepository.getInstance().getController(MainController.class);

    private boolean isFileRepair = false;

    public static final File personalizationConfig = new File(System.getProperty("user.home") + "\\QuerysAutoClicker.ser");
    public static final String personalizationConfigFileName = System.getProperty("user.home") + "\\QuerysAutoClicker.ser";

    private static FileInputStream fileInputStream;
    private static ObjectInputStream objectInputStream;

    private static Save alwaysOnTopState;
    private static Save soundsState;
    private static Save borderRadiusState;
    private static Save designState;
    private static Save languageState;
    private static Save autoCheckForUpdates;

    /**
     * Create new file if file content is corrupted
     */
    public void createValues() throws IOException {
        if (UtilsOS.getOs() == WINDOWS) {
            alwaysOnTopState = new Save("alwaysOnTop", true);
            soundsState = new Save("windowSoundsEnabled", true);
            borderRadiusState = new Save("borderRadius", true);
            autoCheckForUpdates = new Save("autoCheckForUpdates", true);
            designState = new Save("design", "blue");
            languageState = new Save("language", "eng");

            // The new correct states are passed to the program if the old file had previously been corrupted and a new one had to be created.
            if (isFileRepair)
                applyPersonalizationToWindow();

            save(alwaysOnTopState, soundsState, borderRadiusState, autoCheckForUpdates, designState, languageState);
        }
    }

    /**
     * Save the personalization in a file
     *
     * @throws IOException
     */
    public static void setValues() throws IOException {
        if (UtilsOS.getOs() == WINDOWS) {
            alwaysOnTopState = new Save("alwaysOnTop", MainWindow.getStage().isAlwaysOnTop());
            soundsState = new Save("windowSoundsEnabled", Sounds.isSoundsEnabled());
            borderRadiusState = new Save("borderRadius", Design.isBorderRadiusEnabled());
            autoCheckForUpdates = new Save("autoCheckForUpdates", Update.isAutoCheckForUpdatesEnabled());
            designState = new Save("design", Design.getSelectedDesign());
            languageState = new Save("language", Language.getSelectedLanguage());
            save(alwaysOnTopState, soundsState, borderRadiusState, autoCheckForUpdates, designState, languageState);
        }
    }

    /**
     * Get saved values
     *
     * @throws Exception
     */
    public void getValues() throws Exception {
        try {
            fileInputStream = new FileInputStream(personalizationConfigFileName);
            objectInputStream = new ObjectInputStream(fileInputStream);

            alwaysOnTopState = (Save) objectInputStream.readObject();
            soundsState = (Save) objectInputStream.readObject();
            borderRadiusState = (Save) objectInputStream.readObject();
            autoCheckForUpdates = (Save) objectInputStream.readObject();
            designState = (Save) objectInputStream.readObject();
            languageState = (Save) objectInputStream.readObject();

            objectInputStream.close();
            fileInputStream.close();

            applyPersonalizationToWindow();
        } catch (Exception e) {
            if (objectInputStream != null)
                objectInputStream.close();
            if (fileInputStream != null)
                fileInputStream.close();
            // If the content of the old file is corrupted, then this file should be deleted and a new one created with the correct states.
            if (personalizationConfig.exists())
                personalizationConfig.delete();
            isFileRepair = true;
            createValues();
        }
    }

    /**
     * Apply personalization to the window
     */
    private void applyPersonalizationToWindow() {
        isFileRepair = false;
        setAlwaysOnTop(alwaysOnTopState.getBooleanValue());
        setSounds(soundsState.getBooleanValue());
        setBorderRadius(borderRadiusState.getBooleanValue());
        setAutoCheckForUpdates(autoCheckForUpdates.getBooleanValue());
        setDesign(designState.getStringValue());
        setLanguage(languageState.getStringValue());
    }

    public void applyPersonalizationToNonWindowsWindow() {
        setAlwaysOnTop(true);
        setSounds(true);
        setBorderRadius(true);
        setAutoCheckForUpdates(true);
        setDesign("blue");
        setLanguage("eng");
    }

    /**
     * Save values
     */
    public static void save(Save alwaysOnTopState, Save soundsState, Save borderRadiusState, Save autoCheckForUpdates, Save designState, Save languageState) throws IOException {
        FileOutputStream file = new FileOutputStream(personalizationConfigFileName);
        ObjectOutputStream out = new ObjectOutputStream(file);

        out.writeObject(alwaysOnTopState);
        out.writeObject(soundsState);
        out.writeObject(borderRadiusState);
        out.writeObject(autoCheckForUpdates);
        out.writeObject(designState);
        out.writeObject(languageState);

        out.close();
        file.close();
    }

    /**
     * Apply AlwaysOnTop state to the MainWindow
     */
    private void setAlwaysOnTop(boolean isStageAlwaysOnTop) {
        MainWindow.setStageAlwaysOnTop(isStageAlwaysOnTop);
        mC.imageViewAlwaysOnTopPinFalse.setVisible(!isStageAlwaysOnTop);
        mC.imageViewAlwaysOnTopPinTrue.setVisible(isStageAlwaysOnTop);
    }

    /**
     * Apply Sounds state to the MainWindow
     *
     * @param isSoundsEnabled
     */
    private void setSounds(boolean isSoundsEnabled) {
        mC.checkMenuItemSounds.setSelected(isSoundsEnabled);
        Sounds.setSoundsEnabled(isSoundsEnabled);
    }

    /**
     * Apply auto check for QAC updates status to the MainWindow
     */
    private void setAutoCheckForUpdates(boolean autoCheckForUpdates) {
        mC.checkMenuItemAutoCheckForUpdates.setSelected(autoCheckForUpdates);
        Update.setAutoCheckForUpdatesEnabled(autoCheckForUpdates);
    }

    /**
     * Apply BorderRadius state to the MainWindow
     */
    private void setBorderRadius(boolean isBorderRadiusEnabled) {
        mC.checkMenuItemDesignBorderRadius.setSelected(isBorderRadiusEnabled);
        Design.setBorderRadiusEnabled(isBorderRadiusEnabled);
        Design.loadStyleSheets();
    }

    /**
     * Apply Design state to the MainWindow
     */
    private void setDesign(String design) {
        switch (design) {
            case "gray" -> Design.grayDesign();
            case "green" -> Design.greenDesign();
            case "orange" -> Design.orangeDesign();
            case "pink" -> Design.pinkDesign();
            case "red" -> Design.redDesign();
            case "hacker" -> Design.hackerDesign();
            default -> Design.blueDesign();
        }
    }

    /**
     * Change language
     */
    private void setLanguage(String language) {
        Language.set(language);
    }
}