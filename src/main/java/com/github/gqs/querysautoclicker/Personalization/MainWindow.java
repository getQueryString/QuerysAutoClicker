// Copyright© by Fin

package com.github.gqs.querysautoclicker.Personalization;

import com.github.gqs.querysautoclicker.Controller.ControllerRepository;
import com.github.gqs.querysautoclicker.Controller.MainController;
import com.github.gqs.querysautoclicker.Main.Main;
import com.github.gqs.querysautoclicker.Main.Auto.Stop;
import com.github.kwhat.jnativehook.GlobalScreen;
import com.github.kwhat.jnativehook.NativeHookException;
import javafx.application.Platform;
import javafx.scene.Node;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;

public class MainWindow extends PersonalizationConfig {

    private static final Main gMI = Main.getInstance();

    private static final MainController mC = (MainController) ControllerRepository.getInstance().getController(MainController.class);

    private static final int ERROR_TIMER_DELAY = 4000;

    // Move window with MouseDragged & MousePressed on HBox
    private static double xOffset = 0, yOffset = 0;

    private static boolean wasStageAlwaysOnTop = false;

    public static String errorMessageDurationIsEmpty;
    public static String errorMessageIntervalIsEmpty;
    public static String errorMessageDurationAndIntervalIsEmpty;
    public static String errorMessageAutoTextTextInputIsEmpty;
    public static String errorMessageInvalidRegexInput;

    public static Timer errorTimer = new Timer();

    /**
     * Move window
     */
    public static void mousePressed(MouseEvent e) {
        setXOffset(e.getSceneX());
        setYOffset(e.getSceneY());
    }

    /**
     * Set window position to cursor position
     *
     * @param e
     */
    public static void mouseDragged(MouseEvent e) {
        Stage stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
        stage.setX(e.getScreenX() - getXOffset());
        stage.setY(e.getScreenY() - getYOffset());
    }

    /**
     * Set MainWindow to alwaysOnTop
     */
    public static void alwaysOnTop() {
        setStageAlwaysOnTop(!getStage().isAlwaysOnTop());
        mC.imageViewAlwaysOnTopPinFalse.setVisible(!mC.imageViewAlwaysOnTopPinFalse.isVisible());
        mC.imageViewAlwaysOnTopPinTrue.setVisible(!mC.imageViewAlwaysOnTopPinTrue.isVisible());
    }

    /**
     * Set and save alwaysOnTop status
     *
     * @throws IOException
     */
    public static void setAlwaysOnTopState() throws IOException {
        alwaysOnTop();
        System.out.println(getStage().isAlwaysOnTop());
        setValues();
    }

    /**
     * If the MainWindow was previously set to alwaysOnTop = true and an alert is created, the MainWindow
     * will be placed in the background, otherwise the alert will not be visible.
     * <p>
     * If the alert is closed, the MainWindow is reset to alwaysOnTop = true.
     * </p>
     */
    public static void setStageWasAlwaysOnTop() {
        if (getStage().isAlwaysOnTop()) {
            wasStageAlwaysOnTop = true;
            alwaysOnTop();
        } else if (wasStageAlwaysOnTop()) {
            wasStageAlwaysOnTop = false;
            alwaysOnTop();
        }
    }

    /**
     * Minimize MainWindow
     *
     * @param e
     */
    public static void minimize(MouseEvent e) {
        ((Stage) (((ImageView) e.getSource()).getScene().getWindow())).setIconified(true);
    }

    /**
     * Exit QuerysAutoClicker
     *
     * @param status
     * @throws NativeHookException
     */
    public static void exit(int status) throws NativeHookException {
        GlobalScreen.unregisterNativeHook();
        Platform.exit();
        System.exit(status);
    }

    /**
     * Set error message to labelErrorMessage
     *
     * @param exceptionMessage
     */
    public static void error(String exceptionMessage) {
        mC.labelErrorMessage.setVisible(true);
        Sounds.playWarnSound();
        Platform.runLater(() -> mC.labelErrorMessage.setText(exceptionMessage));
        if (errorTimer != null)
            errorTimer.cancel();
        errorTimer = new Timer();
        errorTimer.schedule(new TimerTask() {
            @Override
            public void run() {
                hideErrorMessage();
                errorTimer = null;
            }
        }, ERROR_TIMER_DELAY);
        Stop.querysAutoClicker();
    }

    public static void hideErrorMessage() {
        mC.labelErrorMessage.setVisible(false);
    }

    /**
     * @return xOffset
     */
    public static double getXOffset() {
        return xOffset;
    }

    /**
     * Set window position to X position of cursor
     *
     * @param xOffset
     */
    public static void setXOffset(double xOffset) {
        MainWindow.xOffset = xOffset;
    }

    /**
     * @return yOffset
     */
    public static double getYOffset() {
        return yOffset;
    }

    /**
     * Set window position to Y position of cursor
     *
     * @param yOffset
     */
    public static void setYOffset(double yOffset) {
        MainWindow.yOffset = yOffset;
    }

    /**
     * @return primaryStage
     */
    public static Stage getStage() {
        return gMI.primaryStage;
    }

    public static void setStageAlwaysOnTop(boolean isAlwaysOnTop) {
        gMI.primaryStage.setAlwaysOnTop(isAlwaysOnTop);
    }

    /**
     * @return wasStageAlwaysOnTop
     */
    public static boolean wasStageAlwaysOnTop() {
        return wasStageAlwaysOnTop;
    }

    /**
     * @return errorMessageDurationIsEmpty
     */
    public static String getErrorMessageDurationIsEmpty() {
        return errorMessageDurationIsEmpty;
    }

    /**
     * Set the language of the text errorMessageDurationIsEmpty to labelErrorMessage to the selected language.
     *
     * @param errorMessageDurationIsEmpty
     */
    public static void setErrorMessageDurationIsEmpty(String errorMessageDurationIsEmpty) {
        MainWindow.errorMessageDurationIsEmpty = errorMessageDurationIsEmpty;
    }

    /**
     * @return errorMessageIntervalIsEmpty
     */
    public static String getErrorMessageIntervalIsEmpty() {
        return errorMessageIntervalIsEmpty;
    }

    /**
     * Set the language of the text errorMessageIntervalIsEmpty to labelErrorMessage to the selected language.
     *
     * @param errorMessageIntervalIsEmpty
     */
    public static void setErrorMessageIntervalIsEmpty(String errorMessageIntervalIsEmpty) {
        MainWindow.errorMessageIntervalIsEmpty = errorMessageIntervalIsEmpty;
    }

    /**
     * @return errorMessageDurationAndIntervalIsEmpty
     */
    public static String getErrorMessageDurationAndIntervalIsEmpty() {
        return errorMessageDurationAndIntervalIsEmpty;
    }

    /**
     * Set the language of the text errorMessageDurationAndIntervalIsEmpty to labelErrorMessage to the selected language.
     *
     * @param errorMessageDurationAndIntervalIsEmpty
     */
    public static void setErrorMessageDurationAndIntervalIsEmpty(String errorMessageDurationAndIntervalIsEmpty) {
        MainWindow.errorMessageDurationAndIntervalIsEmpty = errorMessageDurationAndIntervalIsEmpty;
    }

    /**
     * @return errorMessageAutoTextTextInputIsEmpty
     */
    public static String getErrorMessageAutoTextTextInputIsEmpty() {
        return errorMessageAutoTextTextInputIsEmpty;
    }

    /**
     * Set the language of the text errorMessageAutoTextTextInputIsEmpty to labelErrorMessage to the selected language.
     *
     * @param errorMessageAutoTextTextInputIsEmpty
     */
    public static void setErrorMessageAutoTextTextInputIsEmpty(String errorMessageAutoTextTextInputIsEmpty) {
        MainWindow.errorMessageAutoTextTextInputIsEmpty = errorMessageAutoTextTextInputIsEmpty;
    }

    /**
     * @return errorMessageInvalidRegexInput
     */
    public static String getErrorMessageInvalidRegexInput() {
        return errorMessageInvalidRegexInput;
    }

    /**
     * Set the language of the text errorMessageInvalidRegexInput to labelErrorMessage to the selected language.
     *
     * @param errorMessageInvalidRegexInput
     */
    public static void setErrorMessageInvalidRegexInput(String errorMessageInvalidRegexInput) {
        MainWindow.errorMessageInvalidRegexInput = errorMessageInvalidRegexInput;
    }
}