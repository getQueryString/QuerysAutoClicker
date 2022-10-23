// Copyright© by Fin

package com.github.gqs.querysautoclicker.Personalization;

import com.github.gqs.querysautoclicker.Controller.ControllerRepository;
import com.github.gqs.querysautoclicker.Controller.MainController;
import com.github.gqs.querysautoclicker.Main.Main;
import javafx.scene.control.ToggleGroup;

public class Design {

    private static String selectedDesign;

    public static final String designHBox = "-fx-background-color: linear-gradient(to top left, white 0%, #D4D4D4 75%);";
    public static final String blueDesign = "-fx-background-color: linear-gradient(to top left, #0063F5 15%, #44C1F9 85%);";
    public static final String grayDesign = "-fx-background-color: linear-gradient(to top left, #454545 15%, #949494 85%);";
    public static final String greenDesign = "-fx-background-color: linear-gradient(to top left, #0CB800 15%, #10F000 85%);";
    public static final String orangeDesign = "-fx-background-color: linear-gradient(to top left, #E67700 15%, #FFBB00 85%);";
    public static final String pinkDesign = "-fx-background-color: linear-gradient(to top left, #CC0080 15%, #FF70F3 85%);";
    public static final String redDesign = "-fx-background-color: linear-gradient(to top left, #9F0909 15%, red 85%);";
    public static final String hackerDesign = "-fx-background-color: black;";

    private static boolean isBorderRadiusEnabled = false;
    private static boolean isBlueDesignEnabled = false;
    private static boolean isGrayDesignEnabled = false;
    private static boolean isGreenDesignEnabled = false;
    private static boolean isOrangeDesignEnabled = false;
    private static boolean isPinkDesignEnabled = false;
    private static boolean isRedDesignEnabled = false;
    private static boolean isHackerDesignEnabled = false;

    private static final Main gMI = Main.getInstance();

    private static final MainController mC = (MainController) ControllerRepository.getInstance().getController(MainController.class);

    private static final ToggleGroup toggleGroupDesign = new ToggleGroup();

    /**
     * Set Design ToggleGroup
     */
    public static void setToggleGroup() {
        mC.radioMenuItemDesignBlue.setToggleGroup(toggleGroupDesign);
        mC.radioMenuItemDesignGray.setToggleGroup(toggleGroupDesign);
        mC.radioMenuItemDesignGreen.setToggleGroup(toggleGroupDesign);
        mC.radioMenuItemDesignOrange.setToggleGroup(toggleGroupDesign);
        mC.radioMenuItemDesignPink.setToggleGroup(toggleGroupDesign);
        mC.radioMenuItemDesignRed.setToggleGroup(toggleGroupDesign);
        mC.radioMenuItemDesignHacker.setToggleGroup(toggleGroupDesign);
    }

    private static void setBackgroundColor(String design) {
        mC.mainHBox.setStyle(designHBox);
        mC.optionsAnchorPane.setStyle(design);
        mC.autoClickerAnchorPane.setStyle(design);
        mC.autoTextAnchorPane.setStyle(design);
    }

    /**
     * Enable/Disable BorderRadius/Hacker
     */
    public static void loadStyleSheets() {
        gMI.scene.getStylesheets().remove(Design.class.getResource("/Style/Design/BorderRadiusAndDesignHacker.css").toExternalForm());
        gMI.scene.getStylesheets().remove(Design.class.getResource("/Style/Design/BorderRadius.css").toExternalForm());
        gMI.scene.getStylesheets().remove(Design.class.getResource("/Style/Design/DesignHacker.css").toExternalForm());
        if (isBorderRadiusEnabled && isHackerDesignEnabled())
            gMI.scene.getStylesheets().add(Design.class.getResource("/Style/Design/BorderRadiusAndDesignHacker.css").toExternalForm());
        else if (isBorderRadiusEnabled())
            gMI.scene.getStylesheets().add(Design.class.getResource("/Style/Design/BorderRadius.css").toExternalForm());
        else if (isHackerDesignEnabled()) {
            gMI.scene.getStylesheets().add(Design.class.getResource("/Style/Design/DesignHacker.css").toExternalForm());
        }
    }

    /**
     * Set Design to "Blue"
     */
    public static void blueDesign() {
        setSelectedDesign("blue");
        setGrayDesignEnabled(false);
        setGreenDesignEnabled(false);
        setOrangeDesignEnabled(false);
        setPinkDesignEnabled(false);
        setRedDesignEnabled(false);
        setHackerDesignEnabled(false);
        setBlueDesignEnabled(true);
        mC.radioMenuItemDesignBlue.setSelected(true);
        setBackgroundColor(blueDesign);
        loadStyleSheets();
    }

    /**
     * Set design to "Gray"
     */
    public static void grayDesign() {
        setSelectedDesign("gray");
        setBlueDesignEnabled(false);
        setGreenDesignEnabled(false);
        setOrangeDesignEnabled(false);
        setPinkDesignEnabled(false);
        setRedDesignEnabled(false);
        setHackerDesignEnabled(false);
        setGrayDesignEnabled(true);
        mC.radioMenuItemDesignGray.setSelected(true);
        setBackgroundColor(grayDesign);
        loadStyleSheets();
    }

    /**
     * Set design to green
     */
    public static void greenDesign() {
        setSelectedDesign("green");
        setBlueDesignEnabled(false);
        setGrayDesignEnabled(false);
        setOrangeDesignEnabled(false);
        setPinkDesignEnabled(false);
        setRedDesignEnabled(false);
        setHackerDesignEnabled(false);
        setGreenDesignEnabled(true);
        mC.radioMenuItemDesignGreen.setSelected(true);
        setBackgroundColor(greenDesign);
        loadStyleSheets();
    }

    /**
     * Set design to "Orange"
     */
    public static void orangeDesign() {
        setSelectedDesign("orange");
        setBlueDesignEnabled(false);
        setGrayDesignEnabled(false);
        setGreenDesignEnabled(false);
        setPinkDesignEnabled(false);
        setRedDesignEnabled(false);
        setHackerDesignEnabled(false);
        setOrangeDesignEnabled(true);
        mC.radioMenuItemDesignOrange.setSelected(true);
        setBackgroundColor(orangeDesign);
        loadStyleSheets();
    }

    /**
     * Set design to "Pink"
     */
    public static void pinkDesign() {
        setSelectedDesign("pink");
        setBlueDesignEnabled(false);
        setGrayDesignEnabled(false);
        setGreenDesignEnabled(false);
        setOrangeDesignEnabled(false);
        setRedDesignEnabled(false);
        setHackerDesignEnabled(false);
        setPinkDesignEnabled(true);
        mC.radioMenuItemDesignPink.setSelected(true);
        setBackgroundColor(pinkDesign);
        loadStyleSheets();
    }

    /**
     * Set design to "Red"
     */
    public static void redDesign() {
        setSelectedDesign("red");
        setBlueDesignEnabled(false);
        setGrayDesignEnabled(false);
        setGreenDesignEnabled(false);
        setOrangeDesignEnabled(false);
        setPinkDesignEnabled(false);
        setHackerDesignEnabled(false);
        setRedDesignEnabled(true);
        mC.radioMenuItemDesignRed.setSelected(true);
        setBackgroundColor(redDesign);
        loadStyleSheets();
    }

    /**
     * Set design to "Hacker"
     */
    public static void hackerDesign() {
        setSelectedDesign("hacker");
        setBlueDesignEnabled(false);
        setGrayDesignEnabled(false);
        setGreenDesignEnabled(false);
        setOrangeDesignEnabled(false);
        setPinkDesignEnabled(false);
        setRedDesignEnabled(false);
        setHackerDesignEnabled(true);
        mC.radioMenuItemDesignHacker.setSelected(true);
        setBackgroundColor(hackerDesign);
        loadStyleSheets();
    }

    /**
     * @return isBorderRadiusEnabled
     */
    public static boolean isBorderRadiusEnabled() {
        return isBorderRadiusEnabled;
    }

    /**
     * Enable/disable BorderRadius
     *
     * @param isBorderRadiusEnabled
     */
    public static void setBorderRadiusEnabled(boolean isBorderRadiusEnabled) {
        Design.isBorderRadiusEnabled = isBorderRadiusEnabled;
    }

    /**
     * @return isBlueDesignEnabled
     */
    public static boolean isBlueDesignEnabled() {
        return isBlueDesignEnabled;
    }

    /**
     * Set the design of the window to "Blue"
     *
     * @param isBlueDesignEnabled
     */
    public static void setBlueDesignEnabled(boolean isBlueDesignEnabled) {
        Design.isBlueDesignEnabled = isBlueDesignEnabled;
    }

    /**
     * @return isGrayDesignEnabled
     */
    public static boolean isGrayDesignEnabled() {
        return isGrayDesignEnabled;
    }

    /**
     * Set the window design to "Gray"
     *
     * @param isGrayDesignEnabled
     */
    public static void setGrayDesignEnabled(boolean isGrayDesignEnabled) {
        Design.isGrayDesignEnabled = isGrayDesignEnabled;
    }

    /**
     * @return isGreenDesignEnabled
     */
    public static boolean isGreenDesignEnabled() {
        return isGreenDesignEnabled;
    }

    /**
     * Set the window design to "Green"
     *
     * @param isGreenDesignEnabled
     */
    public static void setGreenDesignEnabled(boolean isGreenDesignEnabled) {
        Design.isGreenDesignEnabled = isGreenDesignEnabled;
    }

    /**
     * @return isOrangeDesignEnabled
     */
    public static boolean isOrangeDesignEnabled() {
        return isOrangeDesignEnabled;
    }

    /**
     * Set the window design to "Orange"
     *
     * @param isOrangeDesignEnabled
     */
    public static void setOrangeDesignEnabled(boolean isOrangeDesignEnabled) {
        Design.isOrangeDesignEnabled = isOrangeDesignEnabled;
    }

    /**
     * @return isPinkDesignEnabled
     */
    public static boolean isPinkDesignEnabled() {
        return isPinkDesignEnabled;
    }

    /**
     * Set the window design to "Pink"
     *
     * @param isPinkDesignEnabled
     */
    public static void setPinkDesignEnabled(boolean isPinkDesignEnabled) {
        Design.isPinkDesignEnabled = isPinkDesignEnabled;
    }

    /**
     * @return isRedDesignEnabled
     */
    public static boolean isRedDesignEnabled() {
        return isRedDesignEnabled;
    }

    /**
     * Set the window design to "Red"
     *
     * @param isRedDesignEnabled
     */
    public static void setRedDesignEnabled(boolean isRedDesignEnabled) {
        Design.isRedDesignEnabled = isRedDesignEnabled;
    }

    /**
     * Set the window design to "Hacker"
     *
     * @param isHackerDesignEnabled
     */
    public static void setHackerDesignEnabled(boolean isHackerDesignEnabled) {
        Design.isHackerDesignEnabled = isHackerDesignEnabled;
    }

    /**
     * @return isRedDesignEnabled
     */
    public static boolean isHackerDesignEnabled() {
        return isHackerDesignEnabled;
    }

    /**
     * @return selectedDesign
     */
    public static String getSelectedDesign() {
        return selectedDesign;
    }

    /**
     * Set the abbreviation of the currently selected design to selectedDesign
     *
     * @param selectedDesign
     */
    public static void setSelectedDesign(String selectedDesign) {
        Design.selectedDesign = selectedDesign;
    }
}