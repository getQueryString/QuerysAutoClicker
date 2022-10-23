// Copyright© by getQueryString/Fin

package com.github.gqs.querysautoclicker.Main.Net;

import java.awt.*;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

public class OpenWebsite {

    /**
     * Open the developer's GitHub profile
     *
     * @throws URISyntaxException
     * @throws IOException
     */
    public static void developersGitHubProfile() throws URISyntaxException, IOException {
        Desktop.getDesktop().browse(new URI("https://github.com/getQueryString"));
    }

    /**
     * Open the latest release of QuerysAutoClicker
     *
     * @throws URISyntaxException
     * @throws IOException
     */
    public static void latestRelease() throws URISyntaxException, IOException {
        Desktop.getDesktop().browse(new URI("https://github.com/getQueryString/QuerysAutoClicker/releases"));
    }

    /**
     * Open the source code
     *
     * @throws URISyntaxException
     * @throws IOException
     */
    public static void sourceCode() throws URISyntaxException, IOException {
        Desktop.getDesktop().browse(new URI("https://github.com/getQueryString/QuerysAutoClicker"));
    }
}