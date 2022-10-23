// Copyright© by getQueryString/Fin

package com.github.gqs.querysautoclicker.Controller;

import com.github.gqs.querysautoclicker.Contributors.ContributorsWindow;
import com.github.gqs.querysautoclicker.Main.*;
import com.github.gqs.querysautoclicker.Main.Auto.Start;
import com.github.gqs.querysautoclicker.Main.Auto.Stop;
import com.github.gqs.querysautoclicker.Main.Net.OpenWebsite;
import com.github.gqs.querysautoclicker.Main.Net.Update;
import com.github.gqs.querysautoclicker.Main.Settings.Reset;
import com.github.gqs.querysautoclicker.Main.Settings.Use;
import com.github.gqs.querysautoclicker.Personalization.Design;
import com.github.gqs.querysautoclicker.Personalization.Language;
import com.github.gqs.querysautoclicker.Personalization.MainWindow;
import com.github.gqs.querysautoclicker.Personalization.PersonalizationConfig;
import com.github.gqs.querysautoclicker.Personalization.Sounds;
import com.github.kwhat.jnativehook.NativeHookException;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;

import java.awt.*;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ResourceBundle;

public class MainController implements Initializable, IController {

    public MainController() {
        ControllerRepository.getInstance().register(this);
    }

    public AnchorPane mainAnchorPane;
    public AnchorPane optionsAnchorPane;
    public AnchorPane autoClickerAnchorPane;
    public AnchorPane autoTextAnchorPane;

    public Button buttonStart;
    public Button buttonStop;
    public Button buttonResetOptions;
    public Button buttonResetAutoClicker;
    public Button buttonResetAutoText;

    public CheckMenuItem checkMenuItemTips;
    public CheckMenuItem checkMenuItemSounds;
    public CheckMenuItem checkMenuItemDesignBorderRadius;
    public CheckMenuItem checkMenuItemAutoCheckForUpdates;

    public HBox mainHBox;

    public ImageView mainImageViewDeveloperImage;
    public ImageView imageViewAlwaysOnTopPinTrue;
    public ImageView imageViewAlwaysOnTopPinFalse;
    public ImageView imageViewMinimize;
    public ImageView imageViewEnlarge;
    public ImageView imageViewClose;

    public ImageView imageViewSourceCode;
    public ImageView imageViewExit;
    public ImageView imageViewTips;
    public ImageView imageViewSounds;
    public ImageView imageViewDesign;
    public ImageView imageViewChangeLanguage;
    public ImageView imageViewEng;
    public ImageView imageViewFre;
    public ImageView imageViewGer;
    public ImageView imageViewRus;
    public ImageView imageViewSpa;
    public ImageView imageViewCheckForUpdates;
    public ImageView imageViewRecommendQAC;

    public Label labelPartingLineUpper;
    public Label labelPartingLineLower;

    public Label labelRecommendQAC;
    public Label labelErrorMessage;

    public Menu menuFile;
    public Menu menuWindow;
    public Menu menuWindowDesign;
    public Menu menuChangeLanguage;
    public Menu menuHelp;

    public MenuBar mainMenuBar;

    public MenuItem menuItemSourceCode;
    public MenuItem menuItemExit;
    public MenuItem menuItemRecommendQAC;

    public RadioMenuItem radioMenuItemDesignBlue;
    public RadioMenuItem radioMenuItemDesignGray;
    public RadioMenuItem radioMenuItemDesignGreen;
    public RadioMenuItem radioMenuItemDesignOrange;
    public RadioMenuItem radioMenuItemDesignPink;
    public RadioMenuItem radioMenuItemDesignRed;
    public RadioMenuItem radioMenuItemDesignHacker;
    public RadioMenuItem radioMenuItemLanguageEng;
    public RadioMenuItem radioMenuItemLanguageFre;
    public RadioMenuItem radioMenuItemLanguageGer;
    public RadioMenuItem radioMenuItemLanguageRus;
    public RadioMenuItem radioMenuItemLanguageSpa;

    /**
     * Move MainWindow
     *
     * @param e
     */
    public void mousePressedOnHBox(MouseEvent e) {
        MainWindow.mousePressed(e);
    }

    public void mouseDraggedOnHBox(MouseEvent e) {
        MainWindow.mouseDragged(e);
    }

    /**
     * Open the source code
     *
     * @throws Exception
     */
    public void openSourceCode() throws URISyntaxException, IOException {
        OpenWebsite.sourceCode();
    }

    /**
     * Enable/Disable custom Tooltips
     */
    public void setCustomTooltips() {
        CustomTooltips.setTipsEnabled(!CustomTooltips.isTipsEnabled());
        CustomTooltips.set(CustomTooltips.isTipsEnabled());
    }

    /**
     * Enable/Disable Sounds
     *
     * @throws IOException
     */
    public void windowSounds() throws IOException {
        Sounds.set(!Sounds.isSoundsEnabled());
        PersonalizationConfig.setValues();
    }

    /**
     * Enable/Disable BorderRadius
     */
    public void borderRadius() throws IOException {
        Design.setBorderRadiusEnabled(!Design.isBorderRadiusEnabled());
        Design.loadStyleSheets();
        PersonalizationConfig.setValues();
    }

    /**
     * Set the Design to "Blue"
     *
     * @throws IOException
     */
    public void blueDesign() throws IOException {
        if (!Design.isBlueDesignEnabled()) {
            Design.blueDesign();
            PersonalizationConfig.setValues();
        }
    }

    /**
     * Set the Design to "Gray"
     *
     * @throws IOException
     */
    public void grayDesign() throws IOException {
        if (!Design.isGrayDesignEnabled()) {
            Design.grayDesign();
            PersonalizationConfig.setValues();
        }
    }

    /**
     * Set the Design to "Green"
     *
     * @throws IOException
     */
    public void greenDesign() throws IOException {
        if (!Design.isGreenDesignEnabled()) {
            Design.greenDesign();
            PersonalizationConfig.setValues();
        }
    }

    /**
     * Set the Design to orange
     *
     * @throws IOException
     */
    public void orangeDesign() throws IOException {
        if (!Design.isOrangeDesignEnabled()) {
            Design.orangeDesign();
            PersonalizationConfig.setValues();
        }
    }

    /**
     * Set the Design to "Pink"
     *
     * @throws IOException
     */
    public void pinkDesign() throws IOException {
        if (!Design.isPinkDesignEnabled()) {
            Design.pinkDesign();
            PersonalizationConfig.setValues();
        }
    }

    /**
     * Set the Design to "Red"
     *
     * @throws IOException
     */
    public void redDesign() throws IOException {
        if (!Design.isRedDesignEnabled()) {
            Design.redDesign();
            PersonalizationConfig.setValues();
        }
    }

    /**
     * Set the Design to "Hacker"
     *
     * @throws IOException
     */
    public void hackerDesign() throws IOException {
        if (!Design.isHackerDesignEnabled()) {
            Design.hackerDesign();
            PersonalizationConfig.setValues();
        }
    }

    /**
     * Change the language
     *
     * @throws IOException
     */
    public void english() throws IOException {
        Language.changeLanguage("eng");
    }

    public void french() throws IOException {
        Language.changeLanguage("fre");
    }

    public void german() throws IOException {
        Language.changeLanguage("ger");
    }

    public void russian() throws IOException {
        Language.changeLanguage("rus");
    }

    public void spanish() throws IOException {
        Language.changeLanguage("spa");
    }

    /**
     * Enable/Disable automatically check for QAC updates on startup
     */
    public void autoCheckForUpdates() throws IOException {
        Update.setAutoCheckForUpdatesEnabled(!Update.isAutoCheckForUpdatesEnabled());
        PersonalizationConfig.setValues();
    }

    /**
     * Recommend QuerysAutoClicker
     */
    public void recommendQAC() {
        RecommendQAC.recommend();
    }

    /**
     * Open {@link ContributorsWindow}
     *
     * @param e
     * @throws IOException
     */
    public void openContributorsWindow(MouseEvent e) throws IOException {
        new ContributorsWindow().open(Language.getSelectedLanguage());
    }

    /**
     * Changes the status of whether the window should be in the foreground or in the background.
     *
     * @throws IOException
     */
    public void alwaysOnTop() throws IOException {
        MainWindow.setAlwaysOnTopState();
    }

    /**
     * Start QuerysAutoClicker
     *
     * @throws InterruptedException
     * @throws AWTException
     */
    @Deprecated
    public void startQuerysAutoClicker() throws InterruptedException, AWTException {
        Sounds.playClickSound();
        Start.querysAutoClicker();
    }

    /**
     * Stop QuerysAutoClicker
     */
    @Deprecated
    public void stopQuerysAutoClicker() {
        Sounds.playClickSound();
        Stop.querysAutoClicker();
    }

    /**
     * Reset Options settings
     */
    public void resetOptionsSettings() {
        Sounds.playClickSound();
        Reset.optionsSettings();
    }

    /**
     * Reset AutoClicker settings
     */
    public void resetAutoClickerSettings() {
        Sounds.playClickSound();
        Reset.autoClickerSettings();
    }

    /**
     * Reset AutoText settings
     */
    public void resetAutoTextSettings() {
        Sounds.playClickSound();
        Reset.autoTextSettings();
    }

    /**
     * Minimize MainWindow
     *
     * @param e
     */
    public void minimizeWindow(MouseEvent e) {
        MainWindow.minimize(e);
    }

    /**
     * Exit program
     *
     * @throws NativeHookException
     * @throws IOException
     */
    public void exitProgram() throws NativeHookException, IOException {
        MainWindow.exit(0);
    }

    /**
     * Functions to be executed by the {@link MainController} when the program starts
     */
    public void initialize(URL url, ResourceBundle rb) {
        Design.setToggleGroup();

        Language.addLanguageToGroup();
        Language.setLanguageToggleGroup();

        Use.setToggleGroups();

        CustomTooltips.addContainersToGroup();
    }
}