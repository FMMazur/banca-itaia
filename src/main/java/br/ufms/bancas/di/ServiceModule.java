package br.ufms.bancas.di;

import br.ufms.bancas.scene.SceneLoader;
import br.ufms.bancas.service.LoginService;
import br.ufms.bancas.service.SaveService;
import br.ufms.bancas.utils.Hibernate;
import br.ufms.bancas.utils.SessionManager;
import br.ufms.bancas.view.ViewLoader;
import com.google.inject.AbstractModule;
import com.google.inject.Injector;
import com.google.inject.Provides;
import com.google.inject.Singleton;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;

public class ServiceModule extends AbstractModule {
    @Override
    protected void configure() {
        bind(ViewLoader.class).in(Singleton.class);
        bind(SessionManager.class).in(Singleton.class);
        bind(SaveService.class).in(Singleton.class);

        bind(LoginService.class).in(Singleton.class);

    }

    @Provides
    @Singleton
    public SceneLoader provideSceneLoader(Stage stage, Injector injector) {
        return new SceneLoader(stage, injector);
    }
}