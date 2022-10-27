// Copyright© by getQueryString/Fin

package com.github.gqs.querysautoclicker.Contributors;

import com.github.gqs.querysautoclicker.Controller.ContributorsController;
import com.github.gqs.querysautoclicker.Main.Main;
import com.github.gqs.querysautoclicker.Personalization.Design;
import com.github.gqs.querysautoclicker.Personalization.Language;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.RadioMenuItem;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;
import java.util.Locale;
import java.util.ResourceBundle;

public class ContributorsWindow {

    private final Main gMI = Main.getInstance();

    ContributorsController cC;

    private Parent contributorsRoot;
    private Stage contributorsStage;
    private Scene contributorsScene;

    private static boolean isContributorsWindowShowing = false;

    /**
     * Open the ContributorsWindow
     *
     * @param selectedLanguage
     * @throws IOException
     */
    public void open(String selectedLanguage) throws IOException {
        if (contributorsStage == null) {
            contributorsStage = new Stage();

            FXMLLoader contributorsLoader = new FXMLLoader(getClass().getClassLoader().getResource("Views/ContributorsWindow/Contributors.fxml"));
            contributorsRoot = contributorsLoader.load();
            cC = contributorsLoader.getController();

            contributorsScene = new Scene(contributorsRoot);
            contributorsScene.setFill(Color.TRANSPARENT);

            contributorsStage.setResizable(false);
            contributorsStage.setAlwaysOnTop(true);

            contributorsStage.setScene(contributorsScene);
            contributorsStage.initStyle(StageStyle.TRANSPARENT);
            contributorsStage.initModality(Modality.APPLICATION_MODAL);
        }
        setPosition();
        setContributorsWindowShowing(true);
        contributorsStage.show();
        setLanguage(selectedLanguage);
        setDesign();
    }

    /**
     * Set ContributorsWindow position to center of MainWindow
     */
    private void setPosition() {
        contributorsStage.setX(gMI.primaryStage.getX() + ((gMI.primaryStage.getWidth() / 2) - 213)); // 427 / 2 = 213.5
        contributorsStage.setY(gMI.primaryStage.getY() + ((gMI.primaryStage.getHeight() / 2) - 120));
    }

    /**
     * Set language of ContributorsWindow
     */
    private void setLanguage(String selectedLanguage) {
        RadioMenuItem radioMenuItem = Language.languageToGroup.get(selectedLanguage);
        if (radioMenuItem.isSelected()) {
            Locale contributorsLocale = new Locale(selectedLanguage);
            ResourceBundle contributorsResourceBunde = ResourceBundle.getBundle("Languages/contributorsLang", contributorsLocale);
            contributorsStage.setTitle(contributorsResourceBunde.getString("stageTitle.text"));
            cC.contributorsLabelWindowTitle.setText(contributorsResourceBunde.getString("contributorsLabelWindowTitle.text"));
            cC.contributorsLabelFoundersAndIdeas.setText(contributorsResourceBunde.getString("contributorsLabelFoundersAndIdeas.text"));
            cC.contributorsLabelDesign.setText(contributorsResourceBunde.getString("contributorsLabelDesign.text"));
            cC.contributorsLabelProgrammedBy.setText(contributorsResourceBunde.getString("contributorsLabelProgrammedBy.text"));
        }
    }

    /**
     * Set Design of ContributorsWindow
     */
    private void setDesign() {
        if (Design.isBorderRadiusEnabled())
            contributorsScene.getStylesheets().add(Design.class.getResource("/Style/Design/BorderRadius.css").toExternalForm());
        else
            contributorsScene.getStylesheets().remove(Design.class.getResource("/Style/Design/BorderRadius.css").toExternalForm());
    }

    /**
     * Close the ContributorsWindow
     */
    public void close(MouseEvent e) {
        ((Stage) (((ImageView) e.getSource()).getScene().getWindow())).close();
        setContributorsWindowShowing(false);
    }

    /**
     * @return isContributorsWindowShowing
     */
    public static boolean isContributorsWindowShowing() {
        return isContributorsWindowShowing;
    }

    /**
     * When the contributors window is open: isContributorsWindowShowing = true
     * <p>
     * When the contributors window is closed: isContributorsWindowShowing = false
     * </p>
     *
     * @param isContributorsWindowShowing
     */
    public static void setContributorsWindowShowing(boolean isContributorsWindowShowing) {
        ContributorsWindow.isContributorsWindowShowing = isContributorsWindowShowing;
    }
}