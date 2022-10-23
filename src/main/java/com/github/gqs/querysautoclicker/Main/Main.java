/* Copyright© by getQueryString/Fin
   Icons from https://www.flaticon.com and Technocracy
   Originally programmed for Jovanth
*/

package com.github.gqs.querysautoclicker.Main;

import com.github.gqs.querysautoclicker.Main.Auto.AutoText;
import com.github.gqs.querysautoclicker.Main.JNativeHook.JNativeHook;
import com.github.gqs.querysautoclicker.Main.Net.Update;
import com.github.gqs.querysautoclicker.Personalization.PersonalizationConfig;
import com.github.gqs.querysautoclicker.Utils.UtilsOS;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.awt.*;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

import static com.github.gqs.querysautoclicker.Utils.UtilsOS.OS.LINUX;
import static com.github.gqs.querysautoclicker.Utils.UtilsOS.OS.WINDOWS;
import static java.awt.event.KeyEvent.VK_CONTROL;
import static java.awt.event.KeyEvent.VK_META;

public class Main extends Application {

    public Stage primaryStage;
    public Scene scene;
    public Parent root;
    private static Main instance;

    private final int SEARCH_FOR_UPDATE_DELAY = 250;

    // ThreadPool
    public final ScheduledExecutorService threadPool = Executors.newScheduledThreadPool(2);

    // Version code
    public final String programVersion = "v1.0.0";

    private final Timer searchForUpdateTimer = new Timer();

    /**
     * Set {@link Main} instance
     *
     * @throws IOException
     * @throws URISyntaxException
     * @throws AWTException
     */
    public Main() throws IOException, URISyntaxException, AWTException {
        instance = this;
    }

    /**
     * Get instance of {@link Main}
     *
     * @return instance
     */
    public static Main getInstance() {
        return instance;
    }

    /**
     * @param stage the primary stage for this application, onto which
     *              the application scene can be set.
     *              Applications may create other stages, if needed, but they will not be
     *              primary stages.
     * @throws Exception
     */
    @Deprecated
    @Override
    public void start(Stage stage) throws Exception {
        // Warn if the operating system is Linux or macOS
        switch (UtilsOS.getOs()) {
            case LINUX, MACOS -> System.out.println("Warning!: QAC for Linux and macOS still has bugs!");
            case INCOMPATIBLE -> System.exit(1);
        }

        // Configuration for personalization
        if (!PersonalizationConfig.personalizationConfig.exists())
            new PersonalizationConfig().createValues();

        primaryStage = new Stage();
        FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource("Views/MainWindow/Main.fxml"));
        root = loader.load();
        scene = new Scene(root);
        scene.setFill(Color.TRANSPARENT);
        primaryStage.setTitle("QuerysAutoClicker");
        primaryStage.setResizable(false);
        primaryStage.setAlwaysOnTop(true);
        primaryStage.setScene(scene);
        primaryStage.initStyle(StageStyle.TRANSPARENT);
        primaryStage.show();

        // Register JNativeHook
        JNativeHook.register();

        // Get Personalization settings
        switch (UtilsOS.getOs()) {
            case WINDOWS -> new PersonalizationConfig().getValues();
            case LINUX, MACOS -> new PersonalizationConfig().applyPersonalizationToNonWindowsWindow();
        }

        AutoText.setControlKey(UtilsOS.getOs() == WINDOWS ? VK_CONTROL
                : UtilsOS.getOs() == LINUX ? VK_CONTROL
                : VK_META);

        // Check for new update
        if (Update.isAutoCheckForUpdatesEnabled()) {
            searchForUpdateTimer.schedule(new TimerTask() {
                @Override
                public void run() {
                    Platform.runLater(() -> {
                        try {
                            Update.search();
                        } catch (Exception ignored) {
                        }
                    });
                }
            }, SEARCH_FOR_UPDATE_DELAY);
        }
    }

    /**
     * Launch QuerysAutoClicker program
     *
     * @param args
     */
    static void bootstrap(String[] args) {
        launch(args);
    }
}