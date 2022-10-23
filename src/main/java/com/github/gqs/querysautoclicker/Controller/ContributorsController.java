// Copyright© by getQueryString/Fin

package com.github.gqs.querysautoclicker.Controller;

import com.github.gqs.querysautoclicker.Contributors.ContributorsWindow;
import com.github.gqs.querysautoclicker.Main.Net.OpenWebsite;
import com.github.gqs.querysautoclicker.Personalization.MainWindow;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;

import java.io.IOException;
import java.net.URISyntaxException;

public class ContributorsController {

    public AnchorPane contributorsAnchorPane;

    public ImageView contributorsImageViewCloseButton;
    public ImageView contributorsImageViewDeveloper;

    public Label contributorsLabelWindowTitle;
    public Label contributorsLabelFoundersAndIdeas;
    public Label contributorsLabelDesign;
    public Label contributorsLabelProgrammedBy;

    public HBox contributorsHBox;

    /**
     * Move ContributorsWindow
     *
     * @param e
     */
    public void mousePressedOnContributorsHBox(MouseEvent e) {
        MainWindow.mousePressed(e);
    }

    public void mouseDraggedOnContributorsHBox(MouseEvent e) {
        MainWindow.mouseDragged(e);
    }

    /**
     * Open the developer's GitHub profile
     *
     * @throws Exception
     */
    public void openDevelopersGitHubProfile() throws URISyntaxException, IOException {
        OpenWebsite.developersGitHubProfile();
    }

    /**
     * Close ContributorsWindow
     *
     * @param e
     */
    public void closeContributorsWindow(MouseEvent e) {
        new ContributorsWindow().close(e);
    }

    /**
     * Functions to be executed by the {@link ContributorsController} when the program starts
     */
    public void initialize() {
    }
}