// Copyright© by Fin

package com.github.gqs.querysautoclicker.Personalization;

import com.github.gqs.querysautoclicker.Main.Main;
import javafx.scene.media.AudioClip;

import java.util.concurrent.TimeUnit;

public class Sounds extends PersonalizationConfig {

    private static boolean isSoundsEnabled = true;
    private static boolean isClickSoundPlaying = false;
    private static boolean isWarnSoundPlaying = false;

    private static final Main gMI = Main.getInstance();

    private static final AudioClip clickClip = new AudioClip(Sounds.class.getResource("/Sounds/klick.wav").toExternalForm());
    private static final AudioClip warnClip = new AudioClip(Sounds.class.getResource("/Sounds/warning.wav").toExternalForm());

    /**
     * Enable/Disable Sounds
     *
     * @param isSoundsEnabled
     */
    public static void set(boolean isSoundsEnabled) {
        setSoundsEnabled(isSoundsEnabled);
    }

    /**
     * Play click sound
     */
    public static void playClickSound() {
        if (!isClickSoundPlaying() && isSoundsEnabled()) {
            setClickSoundPlaying(true);
            gMI.threadPool.schedule(() -> setClickSoundPlaying(false), 100, TimeUnit.MILLISECONDS);
            clickClip.play();
        }
    }

    /**
     * Play warn sound
     */
    public static void playWarnSound() {
        if (!isWarnSoundPlaying() && isSoundsEnabled()) {
            setWarnSoundPlaying(true);
            gMI.threadPool.schedule(() -> setWarnSoundPlaying(false), 1, TimeUnit.SECONDS);
            warnClip.play();
        }
    }

    /**
     * @return isSoundsEnabled
     */
    public static boolean isSoundsEnabled() {
        return isSoundsEnabled;
    }

    /**
     * When Sounds is enabled: isSoundsEnabled = true
     * <p>
     * When Sounds is disabled: isSoundsEnabled = false
     * </p>
     *
     * @param isSoundsEnabled
     */
    public static void setSoundsEnabled(boolean isSoundsEnabled) {
        Sounds.isSoundsEnabled = isSoundsEnabled;
    }

    /**
     * @return isClickSoundPlaying
     */
    public static boolean isClickSoundPlaying() {
        return isClickSoundPlaying;
    }

    /**
     * When ClickSound is enabled: isClickSoundPlaying = true
     * <p>
     * When ClickSound is disabled: isClickSoundPlaying = false
     * </p>
     *
     * @param isClickSoundPlaying
     */
    public static void setClickSoundPlaying(boolean isClickSoundPlaying) {
        Sounds.isClickSoundPlaying = isClickSoundPlaying;
    }

    /**
     * @return isWarnSoundPlaying
     */
    public static boolean isWarnSoundPlaying() {
        return isWarnSoundPlaying;
    }

    /**
     * When WarnSound is enabled: isWarnSoundPlaying = true
     * <p>
     * When WarnSound is disabled: isWarnSoundPlaying = false
     * </p>
     *
     * @param isWarnSoundPlaying
     */
    public static void setWarnSoundPlaying(boolean isWarnSoundPlaying) {
        Sounds.isWarnSoundPlaying = isWarnSoundPlaying;
    }
}