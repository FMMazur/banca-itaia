package br.ufms.bancas.scene;

import br.ufms.bancas.App;
import com.google.inject.Inject;
import com.google.inject.Injector;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;

public class SceneLoader {
    private final Stage primaryStage;
    private final Injector injector;

    @Inject
    public SceneLoader(Stage stage, Injector injector) {
        primaryStage = stage;
        this.injector = injector;
    }

    public void goToLogin() {
        try {
            Scene scene = this.load(App.class.getResource("login.fxml"));
            scene.setFill(Color.TRANSPARENT);
            primaryStage.setScene(scene);
            primaryStage.centerOnScreen();
            primaryStage.show();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void goToDashboard() {
        try {
            Scene scene = this.load(App.class.getResource("home.fxml"));;
            scene.setFill(Color.TRANSPARENT);
            primaryStage.setScene(scene);
            primaryStage.centerOnScreen();
            primaryStage.show();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void goToScene(SceneType sceneType) {
        switch (sceneType) {
            case LOGIN -> goToLogin();
            case DASHBOARD -> goToDashboard();
        }
    }

    protected Scene load(URL fxml, double width, double height) throws IOException {
        FXMLLoader loader = new FXMLLoader(fxml);
        loader.setControllerFactory(injector::getInstance);
        Parent root = loader.load();
        return new Scene(root, width, height);
    }

    protected Scene load(URL fxml) throws IOException {
        FXMLLoader loader = new FXMLLoader(fxml);
        loader.setControllerFactory(injector::getInstance);
        Parent root = loader.load();
        return new Scene(root);
    }

}
