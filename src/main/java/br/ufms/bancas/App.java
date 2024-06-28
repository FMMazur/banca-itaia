package br.ufms.bancas;

import br.ufms.bancas.di.*;
import br.ufms.bancas.scene.SceneLoader;
import br.ufms.bancas.scene.SceneType;
import com.google.inject.Guice;
import com.google.inject.Inject;
import com.google.inject.Injector;
import fr.brouillard.oss.cssfx.CSSFX;
import io.github.palexdev.materialfx.theming.JavaFXThemes;
import io.github.palexdev.materialfx.theming.MaterialFXStylesheets;
import io.github.palexdev.materialfx.theming.UserAgentBuilder;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;
import java.util.Objects;

public class App extends Application {
    private static String daoType;
    private Injector injector;

    @Inject
    private SceneLoader sceneLoader;

    public static void main(String[] args) {
        launch();
    }

    @Override
    public void start(Stage stage) throws IOException {
        daoType = "MEMORY";

        injector = Guice.createInjector(
                daoType.equals("MEMORY") ? new DaoMemModule() : new DaoHSQLModule(),
                new FxModule(stage),
                new ServiceModule(),
                new ControllerModule()
        );
        injector.injectMembers(this);

        CSSFX.start();
        UserAgentBuilder.builder()
                .themes(JavaFXThemes.MODENA)
                .themes(MaterialFXStylesheets.forAssemble(true))
                .setDeploy(true)
                .setResolveAssets(true)
                .build()
                .setGlobal();

        stage.initStyle(StageStyle.TRANSPARENT);
        stage.getIcons().add(new Image(Objects.requireNonNull(App.class.getResourceAsStream("/icon.jpeg"))));
        stage.setTitle("Banca Itaia");

        sceneLoader.goToScene(SceneType.DASHBOARD);
    }
}