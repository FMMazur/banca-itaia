package br.ufms.bancas.controller;

import br.ufms.bancas.scene.SceneLoader;
import br.ufms.bancas.service.LoginService;
import com.google.inject.Inject;
import io.github.palexdev.materialfx.controls.MFXTextField;
import io.github.palexdev.mfxresources.fonts.MFXFontIcon;
import javafx.application.Platform;
import javafx.css.PseudoClass;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class LoginController implements Initializable {
    private final LoginService loginService;
    private final SceneLoader sceneLoader;
    private final Stage stage;

    @FXML
    private MFXFontIcon closeIcon;

    @FXML
    private MFXFontIcon minimizeIcon;

    @FXML
    private MFXFontIcon alwaysOnTopIcon;
    @FXML
    private HBox windowHeader;

    @FXML
    private MFXTextField userField;
    @FXML
    private MFXTextField passwordField;
    @FXML
    private AnchorPane rootPane;

    @Inject
    public LoginController(Stage stage, LoginService loginService, SceneLoader sceneLoader) {
        this.stage = stage;
        this.loginService = loginService;
        this.sceneLoader = sceneLoader;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        closeIcon.addEventHandler(MouseEvent.MOUSE_CLICKED, event -> Platform.exit());
        minimizeIcon.addEventHandler(MouseEvent.MOUSE_CLICKED, event -> ((Stage) rootPane.getScene().getWindow()).setIconified(true));
        alwaysOnTopIcon.addEventHandler(MouseEvent.MOUSE_CLICKED, event -> {
            boolean newVal = !stage.isAlwaysOnTop();
            alwaysOnTopIcon.pseudoClassStateChanged(PseudoClass.getPseudoClass("always-on-top"), newVal);
            stage.setAlwaysOnTop(newVal);
        });
    }

    @FXML
    private void onClickLogin() {
        String username = userField.getText();
        String password = passwordField.getText();

        boolean logged = loginService.login(username, password);

        if (logged) {
            sceneLoader.goToDashboard();
        }
    }
}
