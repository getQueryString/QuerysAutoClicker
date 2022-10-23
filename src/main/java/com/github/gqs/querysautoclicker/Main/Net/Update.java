// Copyright© by getQueryString/Fin

package com.github.gqs.querysautoclicker.Main.Net;

import com.github.gqs.querysautoclicker.Main.Main;
import com.github.gqs.querysautoclicker.Personalization.MainWindow;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.net.ConnectException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpConnectTimeoutException;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.Optional;

public class Update {

    private static final Main gMI = Main.getInstance();

    private static final int TIMEOUT = 5;

    private static boolean isAutoCheckForUpdatesEnabled = false;

    private static String getNewVersionCode;

    public static String alertCheckForUpdatesHeaderText;
    public static String alertCheckForUpdatesNewUpdateHeaderText;
    public static String alertCheckForUpdatesNewUpdateContentText;
    public static String alertCheckForUpdatesCurrentVersionText;

    private static Alert alertCheckForUpdate;

    private static HttpClient httpClient;
    private static HttpRequest httpRequest;
    private static HttpResponse<String> response;
    private static JSONObject jsonObject;

    /**
     * Search for QuerysAutoClicker update
     *
     * @throws Exception
     */
    public static void search() throws Exception {
        getLatestVersion();
        if (MainWindow.getStage().isAlwaysOnTop()) {
            MainWindow.setStageWasAlwaysOnTop(true);
            MainWindow.alwaysOnTop();
        }
        showUpdateWindow();
        if (MainWindow.wasStageAlwaysOnTop()) {
            MainWindow.setStageWasAlwaysOnTop(false);
            MainWindow.alwaysOnTop();
        }
    }

    /**
     * Get latest QuerysAutoClicker version from GitHub releases
     *
     * @throws IOException
     * @throws InterruptedException
     */
    private static void getLatestVersion() throws IOException, InterruptedException {
        try {
            httpClient = HttpClient.newBuilder().connectTimeout(Duration.ofSeconds(TIMEOUT)).build();
            httpRequest = HttpRequest.newBuilder()
                    .uri(URI.create("https://api.github.com/repos/getQueryString/QuerysAutoClicker/releases/latest"))
                    .timeout(Duration.ofSeconds(TIMEOUT))
                    .GET()
                    .build();
            response = httpClient.send(httpRequest, HttpResponse.BodyHandlers.ofString(StandardCharsets.UTF_8));
            jsonObject = new JSONObject(response.body());
            getNewVersionCode = jsonObject.getString("tag_name");
        } catch (JSONException | HttpConnectTimeoutException | ConnectException ignored) {
        }
    }

    /**
     * Show update window when a new update is available
     *
     * @throws URISyntaxException
     * @throws IOException
     */
    private static void showUpdateWindow() throws URISyntaxException, IOException {
        if (!getNewVersionCode.equals(gMI.programVersion) && !getNewVersionCode.equals("Not Found") && !getNewVersionCode.startsWith("API")) {
            alertCheckForUpdate = new Alert(Alert.AlertType.CONFIRMATION);
            alertCheckForUpdate.setHeaderText(alertCheckForUpdatesNewUpdateHeaderText);
            alertCheckForUpdate.setContentText(alertCheckForUpdatesNewUpdateContentText + getNewVersionCode + "\n" + alertCheckForUpdatesCurrentVersionText + gMI.programVersion);
            alertCheckForUpdate.setResizable(false);
            alertCheckForUpdate.setTitle("QuerysAutoClicker");
            Optional<ButtonType> result = alertCheckForUpdate.showAndWait();
            if (result.isPresent() && result.get() == ButtonType.OK)
                OpenWebsite.latestRelease();
        }
    }

    /**
     * @return isAutoCheckForUpdatesEnabled
     */
    public static boolean isAutoCheckForUpdatesEnabled() {
        return isAutoCheckForUpdatesEnabled;
    }

    /**
     * When AutoCheckForUpdates at program start is enabled: isAutoCheckForUpdatesEnabled == true
     * <p>
     * When AutoCheckForUpdates at program start is disabled: isAutoCheckForUpdatesEnabled == false
     * </p>
     *
     * @param isAutoCheckForUpdatesEnabled
     */
    public static void setAutoCheckForUpdatesEnabled(boolean isAutoCheckForUpdatesEnabled) {
        Update.isAutoCheckForUpdatesEnabled = isAutoCheckForUpdatesEnabled;
    }
}