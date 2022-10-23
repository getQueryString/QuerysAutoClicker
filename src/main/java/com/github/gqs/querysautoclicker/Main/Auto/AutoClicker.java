// Copyright© by getQueryString/Fin

package com.github.gqs.querysautoclicker.Main.Auto;

import com.github.gqs.querysautoclicker.Controller.AutoClickerItemsController;
import com.github.gqs.querysautoclicker.Controller.ControllerRepository;
import com.github.gqs.querysautoclicker.Controller.OptionsItemsController;
import com.github.gqs.querysautoclicker.Main.Check;
import com.github.gqs.querysautoclicker.Main.Main;
import com.github.gqs.querysautoclicker.Personalization.MainWindow;

import java.awt.*;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.TimeUnit;

public class AutoClicker {

    private static final Main gMI = Main.getInstance();

    private static final OptionsItemsController oIC = (OptionsItemsController) ControllerRepository.getInstance().getController(OptionsItemsController.class);
    private static final AutoClickerItemsController aCIC = (AutoClickerItemsController) ControllerRepository.getInstance().getController(AutoClickerItemsController.class);

    private static int START_INTERVAL_DAYS;
    private static int START_INTERVAL_HOURS;
    private static int START_INTERVAL_MINUTES;
    private static int START_INTERVAL_SECONDS;

    private static int QUANTITY;

    private static int DURATION_DAYS;
    private static int DURATION_HOURS;
    private static int DURATION_MINUTES;
    private static int DURATION_SECONDS;

    private static int SPEED;

    private static int INTERVAL_DAYS;
    private static int INTERVAL_HOURS;
    private static int INTERVAL_MINUTES;
    private static int INTERVAL_SECONDS;
    private static int INTERVAL_MILLISECONDS;

    private static int X_COORD;
    private static int Y_COORD;

    private static int DURATION;
    private static int CLICK_TYPE;
    private static final int MOVE_MOUSE_DELAY = 100;

    // Click type
    private static int CLICK_TYPE_INDEX;
    private static int MOUSE_BUTTON_INDEX;

    // Click position
    private static int CLICK_POSITION_X;
    private static int CLICK_POSITION_Y;

    private static int CLICK_COUNT;

    private static int MOUSE_BUTTON;

    private static boolean isAutoClickerRunning = false;
    private static boolean isHoldClickEnabled = false;
    private static boolean isHoldHotkeyEnabled = false;
    private static boolean isPickClickPositionEnabled = false;

    public static Robot autoClickerRobot;

    public static Thread autoClickerThread;
    public static Thread holdHotkeyThread;

    private static Timer durationTimer = new Timer();

    /**
     * Start AutoClicker
     *
     * @throws AWTException
     */
    public static void start() throws AWTException {
        autoClickerRobot = new Robot();
        setAutoClickerRunning(true);
        autoClickerThread = new Thread(() -> {
            try {
                START_INTERVAL_DAYS = Integer.parseInt(oIC.textFieldStartIntervalDays.getText());
                START_INTERVAL_HOURS = Integer.parseInt(oIC.textFieldStartIntervalHours.getText());
                START_INTERVAL_MINUTES = Integer.parseInt(oIC.textFieldStartIntervalMinutes.getText());
                START_INTERVAL_SECONDS = Integer.parseInt(oIC.textFieldStartIntervalSeconds.getText());

                QUANTITY = Integer.parseInt(oIC.textFieldQuantity.getText());

                DURATION_DAYS = Integer.parseInt(oIC.textFieldDurationDays.getText());
                DURATION_HOURS = Integer.parseInt(oIC.textFieldDurationHours.getText());
                DURATION_MINUTES = Integer.parseInt(oIC.textFieldDurationMinutes.getText());
                DURATION_SECONDS = Integer.parseInt(oIC.textFieldDurationSeconds.getText());

                SPEED = Integer.parseInt(oIC.textFieldSpeed.getText());

                INTERVAL_DAYS = Integer.parseInt(oIC.textFieldIntervalDays.getText());
                INTERVAL_HOURS = Integer.parseInt(oIC.textFieldIntervalHours.getText());
                INTERVAL_MINUTES = Integer.parseInt(oIC.textFieldIntervalMinutes.getText());
                INTERVAL_SECONDS = Integer.parseInt(oIC.textFieldIntervalSeconds.getText());
                INTERVAL_MILLISECONDS = Integer.parseInt(oIC.textFieldIntervalMilliseconds.getText());

                Check.options(DURATION_DAYS, DURATION_HOURS, DURATION_MINUTES, DURATION_SECONDS, INTERVAL_DAYS, INTERVAL_HOURS, INTERVAL_MINUTES, INTERVAL_SECONDS, INTERVAL_MILLISECONDS);

                if (!isHoldHotkeyEnabled()) {
                    TimeUnit.DAYS.sleep(START_INTERVAL_DAYS);
                    TimeUnit.HOURS.sleep(START_INTERVAL_HOURS);
                    TimeUnit.MINUTES.sleep(START_INTERVAL_MINUTES);
                    TimeUnit.SECONDS.sleep(START_INTERVAL_SECONDS);
                }

                chooseFunctions();

            } catch (NumberFormatException | InterruptedException exception) {
                MainWindow.error("" + exception);
            }
        });
        startAutoClickerThread();
    }

    /**
     * Check details and choose which functions to use with the AutoClicker.
     *
     * @throws InterruptedException
     */
    @Deprecated
    private static void chooseFunctions() throws InterruptedException {
        // Fix click position if x- and y-coordinates are not empty
        if (!(aCIC.textFieldPositionXCoordinate.getText().equals("") || aCIC.textFieldPositionYCoordinate.getText().equals(""))) {
            X_COORD = Integer.parseInt(aCIC.textFieldPositionXCoordinate.getText());
            Y_COORD = Integer.parseInt(aCIC.textFieldPositionYCoordinate.getText());
            fixMousePosition();
        }

        // Set click type (single, double or triple)
        setClickType();
        if (isHoldHotkeyEnabled()) {
            setMouseButton();
            startAutoClickerHoldHotkey();
            return;
        }

        // Start Duration timer if Duration RadioButton is selected
        if (oIC.radioButtonDuration.isSelected()) {
            startAutoClickerTimer();
        }

        // Start AutoClicker with HoldClick
        if (aCIC.radioButtonMouseKey.isSelected() && aCIC.checkBoxHoldClick.isSelected()) {
            setMouseButton();
            startAutoClickerHoldClick();
            // Start AutoClicker without HoldClick
        } else if (aCIC.radioButtonMouseKey.isSelected()) {
            setMouseButton();
            startAutoClicker();
        } else if (aCIC.radioButtonF5.isSelected()) {
            startAutoClicker();
        }
    }

    /**
     * Set click type
     */
    private static void setClickType() {
        if (aCIC.choiceBoxClickType.getSelectionModel().isSelected(0))
            CLICK_TYPE = 1;
        else if (aCIC.choiceBoxClickType.getSelectionModel().isSelected(1))
            CLICK_TYPE = 2;
        else if (aCIC.choiceBoxClickType.getSelectionModel().isSelected(2))
            CLICK_TYPE = 3;
    }

    /**
     * Set input event button
     */
    @Deprecated
    private static void setMouseButton() {
        if (aCIC.choiceBoxMouseKey.getSelectionModel().isSelected(0))
            setMouseInputKey(InputEvent.BUTTON1_MASK);
        else if (aCIC.choiceBoxMouseKey.getSelectionModel().isSelected(1))
            setMouseInputKey(InputEvent.BUTTON2_MASK);
        else if (aCIC.choiceBoxMouseKey.getSelectionModel().isSelected(2))
            setMouseInputKey(InputEvent.BUTTON3_MASK);
    }

    /**
     * Fix mouse position during AutoClicker
     */
    private static void fixMousePosition() {
        gMI.threadPool.submit(() -> {
            while (isAutoClickerRunning()) {
                autoClickerRobot.mouseMove(X_COORD, Y_COORD);
                autoClickerRobot.delay(MOVE_MOUSE_DELAY);
            }
        });
    }

    /**
     * Start AutoClicker timer
     */
    @Deprecated
    private static void startAutoClickerTimer() {
        DURATION = (DURATION_DAYS * 86400000) + (DURATION_HOURS * 3600000) + (DURATION_MINUTES * 60000) + (DURATION_SECONDS * 1000);
        durationTimer.cancel();
        durationTimer = new Timer();
        durationTimer.schedule(new TimerTask() {
            @Override
            public void run() {
                Stop.querysAutoClicker();
            }
        }, DURATION);
    }

    /**
     * AutoClicker delay
     *
     * @throws InterruptedException
     */
    private static void delay() throws InterruptedException {
        if (oIC.radioButtonSpeed.isSelected()) {
            TimeUnit.MILLISECONDS.sleep(1000 / SPEED);
        } else if (oIC.radioButtonInterval.isSelected()) {
            autoClickerRobot.delay((INTERVAL_DAYS * 86400000) + (INTERVAL_HOURS * 3600000) + (INTERVAL_MINUTES * 60000) + (INTERVAL_SECONDS * 1000) + INTERVAL_MILLISECONDS);
        }
    }

    /**
     * Start AutoClicker with HoldClick
     */
    @Deprecated
    private static void startAutoClickerHoldClick() {
        autoClickerRobot.mousePress(getMouseInputKey());
    }

    /**
     * Start AutoClicker with StartHotkey
     */
    public static void startAutoClickerHoldHotkey() {
        holdHotkeyThread = new Thread(() -> {
            while (isHoldHotkeyEnabled()) {
                for (int i = 0; i < CLICK_TYPE; i++) {
                    autoClickerRobot.mousePress(getMouseInputKey());
                    autoClickerRobot.mouseRelease(getMouseInputKey());
                }
                try {
                    delay();
                } catch (InterruptedException interruptedException) {
                    MainWindow.error("" + interruptedException);
                }
            }
        });
        holdHotkeyThread.start();
    }

    /**
     * Start AutoClicker
     *
     * @throws InterruptedException
     */
    @Deprecated
    private static void startAutoClicker() throws InterruptedException {
        while (isAutoClickerRunning()) {
            for (int i = 0; i < CLICK_TYPE; i++) {
                if (aCIC.radioButtonMouseKey.isSelected()) {
                    autoClickerRobot.mousePress(getMouseInputKey());
                    autoClickerRobot.mouseRelease(getMouseInputKey());
                } else if (aCIC.radioButtonF5.isSelected()) {
                    autoClickerRobot.keyPress(KeyEvent.VK_F5);
                    autoClickerRobot.keyRelease(KeyEvent.VK_F5);
                }
            }
            delay();
            setClickCount(getClickCount() + 1);
            if (oIC.radioButtonQuantity.isSelected() && getClickCount() == QUANTITY)
                Stop.querysAutoClicker();
        }
    }

    /**
     * Start thread from AutoClicker
     */
    public static void startAutoClickerThread() {
        autoClickerThread.start();
    }

    /**
     * Stop thread from AutoClicker
     */
    @Deprecated
    public static void stopAutoClickerThread() {
        autoClickerThread.stop();
    }

    /**
     * @return isAutoClickerRunning
     */
    public static boolean isAutoClickerRunning() {
        return isAutoClickerRunning;
    }

    /**
     * When AutoClicker is running:: isAutoClickerRunning == true
     * <p>
     * When AutoClicker is not running:: isAutoClickerRunning == false
     * </p>
     *
     * @param isAutoClickerRunning
     */
    public static void setAutoClickerRunning(boolean isAutoClickerRunning) {
        AutoClicker.isAutoClickerRunning = isAutoClickerRunning;
    }

    /**
     * @return CLICK_COUNT
     */
    public static int getClickCount() {
        return CLICK_COUNT;
    }

    /**
     * Set CLICK_COUNT to the number of clicks made
     *
     * @param CLICK_COUNT
     */
    public static void setClickCount(int CLICK_COUNT) {
        AutoClicker.CLICK_COUNT = CLICK_COUNT;
    }

    /**
     * @return isHoldClickEnabled
     */
    public static boolean isHoldClickEnabled() {
        return isHoldClickEnabled;
    }

    /**
     * When HoldClick is enabled: isHoldClickEnabled == true
     * <p>
     * When HoldClick is disabled: isHoldClickEnabled == false
     * </p>
     *
     * @param isHoldClickEnabled
     */
    public static void setHoldClickEnabled(boolean isHoldClickEnabled) {
        AutoClicker.isHoldClickEnabled = isHoldClickEnabled;
    }

    /**
     * @return isHoldHotkeyEnabled
     */
    public static boolean isHoldHotkeyEnabled() {
        return isHoldHotkeyEnabled;
    }

    /**
     * When HoldHotkey is enabled: isHoldHotkeyEnabled == true
     * <p>
     * When HoldHotkey is disabled: isHoldHotkeyEnabled == false
     * </p>
     *
     * @param isHoldHotkeyEnabled
     */
    public static void setHoldHotkeyEnabled(boolean isHoldHotkeyEnabled) {
        AutoClicker.isHoldHotkeyEnabled = isHoldHotkeyEnabled;
    }

    /**
     * @return CLICK_TYPE_INDEX
     */
    public static int getClickTypeIndex() {
        return CLICK_TYPE_INDEX;
    }

    /**
     * Set the value of the choiceBoxClickType
     *
     * @param CLICK_TYPE_INDEX
     */
    public static void setClickTypeIndex(int CLICK_TYPE_INDEX) {
        AutoClicker.CLICK_TYPE_INDEX = CLICK_TYPE_INDEX;
    }

    /**
     * @return MOUSE_BUTTON_INDEX
     */
    public static int getMouseButtonIndex() {
        return MOUSE_BUTTON_INDEX;
    }

    /**
     * Set the value of the choiceBoxMouseKey
     *
     * @param MOUSE_BUTTON_INDEX
     */
    public static void setMouseButtonIndex(int MOUSE_BUTTON_INDEX) {
        AutoClicker.MOUSE_BUTTON_INDEX = MOUSE_BUTTON_INDEX;
    }

    /**
     * @return isPickClickPositionEnabled
     */
    public static boolean isPickClickPositionEnabled() {
        return isPickClickPositionEnabled;
    }

    /**
     * When PickClickPosition is enabled: isPickClickPositionEnabled == true
     * <p>
     * When PickClickPosition is disabled: isPickClickPositionEnabled == false
     * </p>
     *
     * @param isPickClickPositionEnabled
     */
    public static void setPickClickPositionEnabled(boolean isPickClickPositionEnabled) {
        AutoClicker.isPickClickPositionEnabled = isPickClickPositionEnabled;
    }

    /**
     * @return CLICK_POSITION_X
     */
    public static int getClickPositionX() {
        return CLICK_POSITION_X;
    }

    /**
     * Set X value of click position
     *
     * @param CLICK_POSITION_X
     */
    public static void setClickPositionX(int CLICK_POSITION_X) {
        AutoClicker.CLICK_POSITION_X = CLICK_POSITION_X;
    }

    /**
     * @return CLICK_POSITION_Y
     */
    public static int getClickPositionY() {
        return CLICK_POSITION_Y;
    }

    /**
     * Set Y value of click position
     *
     * @param CLICK_POSITION_Y
     */
    public static void setClickPositionY(int CLICK_POSITION_Y) {
        AutoClicker.CLICK_POSITION_Y = CLICK_POSITION_Y;
    }

    /**
     * @return MOUSE_BUTTON
     */
    public static int getMouseInputKey() {
        return MOUSE_BUTTON;
    }

    /**
     * Which mouse button to click at AutoClicker
     *
     * @param MOUSE_BUTTON
     */
    public static void setMouseInputKey(int MOUSE_BUTTON) {
        AutoClicker.MOUSE_BUTTON = MOUSE_BUTTON;
    }
}