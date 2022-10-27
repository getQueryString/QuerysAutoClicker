// Copyright© by getQueryString/Fin

package com.github.gqs.querysautoclicker.Main.Auto;

import com.github.gqs.querysautoclicker.Controller.AutoTextItemsController;
import com.github.gqs.querysautoclicker.Controller.ControllerRepository;
import com.github.gqs.querysautoclicker.Controller.OptionsItemsController;
import com.github.gqs.querysautoclicker.Main.Check;
import com.github.gqs.querysautoclicker.Personalization.MainWindow;

import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.TimeUnit;
import java.util.regex.PatternSyntaxException;

import static java.awt.event.KeyEvent.*;

public class AutoText {

    private static final OptionsItemsController oIC = (OptionsItemsController) ControllerRepository.getInstance().getController(OptionsItemsController.class);
    private static final AutoTextItemsController aTIC = (AutoTextItemsController) ControllerRepository.getInstance().getController(AutoTextItemsController.class);

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

    private static int DURATION;

    private static int TEXT_COUNT;

    private static int REPLACE_INDEX;

    private static int controlKey;

    private static boolean isAutoTextRunning;
    private static boolean isPasteTextEnabled;
    private static boolean isPasteTextLineForLineEnabled;
    private static boolean isReplaceEnabled;

    private static String autoTextInput;

    private static String[] inputLine;

    public static Robot autoTextRobot;

    public static Thread autoTextThread;

    private static final Clipboard autoTextClipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
    private static StringSelection autoTextStringSelection;

    private static Timer durationTimer = new Timer();

    /**
     * Start AutoText
     *
     * @throws AWTException
     */
    @Deprecated
    public static void start() throws AWTException {
        autoTextRobot = new Robot();

        setAutoTextRunning(true);
        autoTextThread = new Thread(() -> {
            try {
                autoTextInput = aTIC.textAreaTextEntry.getText();

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

                TimeUnit.DAYS.sleep(START_INTERVAL_DAYS);
                TimeUnit.HOURS.sleep(START_INTERVAL_HOURS);
                TimeUnit.MINUTES.sleep(START_INTERVAL_MINUTES);
                TimeUnit.SECONDS.sleep(START_INTERVAL_SECONDS);

                chooseFunctions();
            } catch (InterruptedException exception) {
                MainWindow.error("" + exception);
            }
        });
        startAutoTextThread();
    }

    @Deprecated
    private static void chooseFunctions() throws InterruptedException {
        // Start Duration timer if Duration RadioButton is selected
        if (oIC.radioButtonDuration.isSelected()) {
            startAutoTextTimer();
        }
        if (isReplaceEnabled())
            replaceCharacters();
        else
            quantity();
    }

    /**
     * Specify how many times the text input should be written repeatedly by the robot
     *
     * @throws InterruptedException
     */
    @Deprecated
    private static void quantity() throws InterruptedException {
        // Split autoTextInput when InstantType is enabled
        if (isPasteTextEnabled())
            inputLine = autoTextInput.split("[\r\n]+");

        // Infinite quantity
        if (QUANTITY == -1) {
            for (int i = 0; i > QUANTITY; i++) {
                chooseAutoTextMethod();
            }
            // Limited quantity
        } else if (QUANTITY > 0) {
            for (int i = 0; i < QUANTITY; i++) {
                chooseAutoTextMethod();
            }
        }
    }

    /**
     * Choose the AutoText method (Paste the entered text [line by line])
     *
     * @throws InterruptedException
     */
    private static void chooseAutoTextMethod() throws InterruptedException {
        if (isPasteTextEnabled() && !isPasteTextLineForLineEnabled()) {
            startAutoTextPasteText();
        } else if (isPasteTextEnabled()) {
            startAutoTextPasteTextLineForLine();
        } else {
            startAutoText();
        }
    }

    /**
     * AutoText with replacement: String or individual letters
     */
    @Deprecated
    private static void replaceCharacters() {
        try {
            if (aTIC.choiceBoxReplaceOptions.getSelectionModel().isSelected(1)) {
                autoTextInput = autoTextInput.replaceAll(aTIC.textAreaSplit.getText(), aTIC.textAreaSplitTo.getText());
            } else if (aTIC.choiceBoxReplaceOptions.getSelectionModel().isSelected(2)) {
                autoTextInput = autoTextInput.replaceAll("[" + aTIC.textAreaSplit.getText() + "]", aTIC.textAreaSplitTo.getText());
            }
            quantity();
        } catch (PatternSyntaxException patternSyntaxException) {
            MainWindow.error(MainWindow.getErrorMessageInvalidRegexInput());
        } catch (InterruptedException interruptedException) {
            MainWindow.error("" + interruptedException);
        }
    }

    /**
     * Start AutoText timer
     */
    @Deprecated
    private static void startAutoTextTimer() {
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
     * AutoText delay
     *
     * @throws InterruptedException
     */
    private static void delay() throws InterruptedException {
        if (oIC.radioButtonSpeed.isSelected()) {
            TimeUnit.MILLISECONDS.sleep(1000 / SPEED);
        } else if (oIC.radioButtonInterval.isSelected()) {
            autoTextRobot.delay((INTERVAL_DAYS * 86400000) + (INTERVAL_HOURS * 3600000) + (INTERVAL_MINUTES * 60000) + (INTERVAL_SECONDS * 1000) + INTERVAL_MILLISECONDS);
        }
    }

    /**
     * Start AutoText
     */
    @Deprecated
    private static void startAutoText() throws InterruptedException {
        for (char ch : autoTextInput.toCharArray()) {
            typeText(ch);
            delay();
        }
        setTextCount(getTextCount() + 1);
        if (getTextCount() == QUANTITY)
            Stop.querysAutoClicker();
    }

    /**
     * Start AutoText with paste text: Inserts the entered text
     */
    @Deprecated
    private static void startAutoTextPasteText() throws InterruptedException {
        try {
            autoTextStringSelection = new StringSelection(autoTextInput);
            autoTextClipboard.setContents(autoTextStringSelection, null);

            autoTextRobot.keyPress(getControlKey());
            autoTextRobot.keyPress(VK_V);
            autoTextRobot.keyRelease(getControlKey());
            autoTextRobot.keyRelease(VK_V);

            autoTextRobot.keyPress(VK_ENTER);
            autoTextRobot.keyRelease(VK_ENTER);

            delay();

            setTextCount(getTextCount() + 1);
            if (getTextCount() == QUANTITY)
                Stop.querysAutoClicker();
        } catch (IllegalStateException illegalStateException) {
            MainWindow.error("" + illegalStateException);
        }
    }

    /**
     * Start AutoText with paste text LineForLine: Inserts the entered text line by line
     *
     * @throws InterruptedException
     */
    @Deprecated
    private static void startAutoTextPasteTextLineForLine() throws InterruptedException {
        for (String str : inputLine) {
            try {
                autoTextStringSelection = new StringSelection(str);
                autoTextClipboard.setContents(autoTextStringSelection, null);

                autoTextRobot.keyPress(getControlKey());
                autoTextRobot.keyPress(VK_V);
                autoTextRobot.keyRelease(getControlKey());
                autoTextRobot.keyRelease(VK_V);

                autoTextRobot.keyPress(VK_ENTER);
                autoTextRobot.keyRelease(VK_ENTER);

                delay();
            } catch (IllegalStateException illegalStateException) {
                MainWindow.error("" + illegalStateException);
            }
        }
        setTextCount(getTextCount() + 1);
        if (getTextCount() == QUANTITY)
            Stop.querysAutoClicker();
    }

    /**
     * Types the entered text letter by letter
     *
     * @param characterKey
     */
    private static void typeText(char characterKey) {
        if (String.valueOf(characterKey).equals("\n")) {
            autoTextRobot.keyPress(VK_ENTER);
            autoTextRobot.keyRelease(VK_ENTER);
        } else if (String.valueOf(characterKey).equals(" ")) {
            autoTextRobot.keyPress(VK_SPACE);
            autoTextRobot.keyRelease(VK_SPACE);
        } else {
            autoTextRobot.keyPress(KeyEvent.VK_ALT);
            for (int i = 3; i >= 0; --i) {
                // extracts a single decade of the key-code and adds
                // an offset to get the required VK_NUMPAD key-code
                int numpad_kc = (int) characterKey / (int) (Math.pow(10, i)) % 10 + KeyEvent.VK_NUMPAD0;
                autoTextRobot.keyPress(numpad_kc);
                autoTextRobot.keyRelease(numpad_kc);
            }
            autoTextRobot.keyRelease(KeyEvent.VK_ALT);
        }
    }


    /**
     * Start thread from AutoText
     */
    public static void startAutoTextThread() {
        autoTextThread.start();
    }

    /**
     * Stop thread from AutoText
     */
    @Deprecated
    public static void stopAutoTextThread() {
        autoTextThread.stop();
    }

    /**
     * @return isAutoTextRunning
     */
    public static boolean isAutoTextRunning() {
        return isAutoTextRunning;
    }

    /**
     * When AutoText is running:: isAutoTextRunning = true
     * <p>
     * When AutoText is not running:: isAutoTextRunning = false
     * </p>
     *
     * @param isAutoTextRunning
     */
    public static void setAutoTextRunning(boolean isAutoTextRunning) {
        AutoText.isAutoTextRunning = isAutoTextRunning;
    }

    /**
     * @return TEXT_COUNT
     */
    public static int getTextCount() {
        return TEXT_COUNT;
    }

    /**
     * Set TEXT_COUNT to the number of textAreaTextEntry inputs written
     *
     * @param TEXT_COUNT
     */
    public static void setTextCount(int TEXT_COUNT) {
        AutoText.TEXT_COUNT = TEXT_COUNT;
    }

    /**
     * @return isPasteTextEnabled
     */
    public static boolean isPasteTextEnabled() {
        return isPasteTextEnabled;
    }

    /**
     * When PasteText is enabled: isPasteTextEnabled = true
     * <p>
     * When PasteText is disabled: isPasteTextEnabled = false
     * </p>
     *
     * @param isPasteTextEnabled
     */
    public static void setPasteTextEnabled(boolean isPasteTextEnabled) {
        AutoText.isPasteTextEnabled = isPasteTextEnabled;
    }

    /**
     * @return isPasteTextLineForLineEnabled
     */
    public static boolean isPasteTextLineForLineEnabled() {
        return isPasteTextLineForLineEnabled;
    }

    /**
     * When PasteTextLineForLine is enabled: isPasteTextLineForLineEnabled = true
     * <p>
     * When PasteTextLineForLine is disabled: isPasteTextLineForLineEnabled = false
     * </p>
     *
     * @param isPasteTextLineForLineEnabled
     */
    public static void setPasteTextLineForLineEnabled(boolean isPasteTextLineForLineEnabled) {
        AutoText.isPasteTextLineForLineEnabled = isPasteTextLineForLineEnabled;
    }

    /**
     * @return isReplaceEnabled
     */
    public static boolean isReplaceEnabled() {
        return isReplaceEnabled;
    }

    /**
     * When Replace is enabled: isReplaceEnabled = true
     * <p>
     * When Replace is disabled: isReplaceEnabled = false
     * </p>
     *
     * @param isReplaceEnabled
     */
    public static void setReplaceEnabled(boolean isReplaceEnabled) {
        AutoText.isReplaceEnabled = isReplaceEnabled;
    }

    /**
     * @return REPLACE_INDEX
     */
    public static int getReplaceIndex() {
        return REPLACE_INDEX;
    }

    /**
     * Selection whether nothing, a word or individual characters of textAreaTextEntry should be replaced
     *
     * @param REPLACE_INDEX
     */
    public static void setReplaceIndex(int REPLACE_INDEX) {
        AutoText.REPLACE_INDEX = REPLACE_INDEX;
    }

    /**
     * @return controlKey
     */
    public static int getControlKey() {
        return controlKey;
    }

    /**
     * Depending on the operating system, a different control key should be used
     *
     * @param controlKey
     */
    public static void setControlKey(int controlKey) {
        AutoText.controlKey = controlKey;
    }
}