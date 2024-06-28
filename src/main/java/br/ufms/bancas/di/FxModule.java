package br.ufms.bancas.di;

import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import com.google.inject.Singleton;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;

public class FxModule extends AbstractModule {
    private final Stage stage;

    public FxModule(Stage stage) {
        this.stage = stage;
    }

    @Provides
    @Singleton
    public Stage providePrimaryStage() {
        return stage;
    }
}
