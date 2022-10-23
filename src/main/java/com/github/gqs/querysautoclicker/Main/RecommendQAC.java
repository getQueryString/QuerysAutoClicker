// Copyright© by getQueryString/Fin

package com.github.gqs.querysautoclicker.Main;

import com.github.gqs.querysautoclicker.Controller.ControllerRepository;
import com.github.gqs.querysautoclicker.Controller.MainController;
import javafx.scene.control.Label;

import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.util.Timer;
import java.util.TimerTask;

public class RecommendQAC {

    private static final MainController mC = (MainController) ControllerRepository.getInstance().getController(MainController.class);

    private static final int RECOMMEND_TIMER_DELAY = 3000;

    private static String recommendText;

    public static Timer recommendTimer = new Timer();

    private static final Clipboard recommendClipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
    private static StringSelection recommendStringSelection;

    private static final Label recommendPopupLabel = new Label();

    /**
     * Copy the recommendation text to the clipboard
     */
    public static void recommend() {
        recommendStringSelection = new StringSelection(getRecommendText());
        recommendClipboard.setContents(recommendStringSelection, null);
        recommendPopupLabel.setText(getRecommendText());
        showCopiedMessage();
    }

    /**
     * Show labelRecommendQAC if not invisible
     */
    private static void showCopiedMessage() {
        if (!mC.labelRecommendQAC.isVisible()) {
            mC.labelRecommendQAC.setVisible(true);
            recommendTimer.cancel();
            recommendTimer = new Timer();
            recommendTimer.schedule(new TimerTask() {
                @Override
                public void run() {
                    mC.labelRecommendQAC.setVisible(false);
                }
            }, RECOMMEND_TIMER_DELAY);
        }
    }

    /**
     * Hide labelRecommendQAC
     */
    public static void hideCopiedMessage() {
        if (recommendTimer != null)
            recommendTimer.cancel();
        mC.labelRecommendQAC.setVisible(false);
    }

    /**
     * @return recommendText
     */
    public static String getRecommendText() {
        return recommendText;
    }

    /**
     * Set the language of the text recommendText to the selected language.
     * <p>
     * This text is placed on the clipboard when menuItemRecommendQAC is clicked.
     * </p>
     *
     * @param recommendText
     */
    public static void setRecommendText(String recommendText) {
        RecommendQAC.recommendText = recommendText;
    }
}