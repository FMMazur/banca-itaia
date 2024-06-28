package br.ufms.bancas.view;

import br.ufms.bancas.App;
import com.google.inject.Inject;
import com.google.inject.Injector;
import com.google.inject.Singleton;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import lombok.Getter;

import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

@Getter
@Singleton
public class ViewLoader {
    private final ObjectProperty<ViewType> selectedView;
    private final Injector injector;
    private static final Map<ViewType, Parent> views = new HashMap<>();

    @Inject
    public ViewLoader(Stage stage, Injector injector) {
        this.selectedView = new SimpleObjectProperty<>();
        this.injector = injector;
    }

    public Parent getView(ViewType type) throws IOException {
        if (views.containsKey(type)) return views.get(type);
        String fxml = switch (type) {
            case ADD_ESTOQUE -> "cadastro.fxml";
            case HOME, PEDIDOS -> "dashboard.fxml";
            case VENDAS -> "dashboard.fxml"; // TODO: validar se vai ter essa tela
            case PRODUTOS -> "visualizacao.fxml";
            case VENDER -> "venda.fxml";
            case ESTOQUE -> "estoque.fxml";
        };

        Parent view = this.load(fxml);

        if (type == ViewType.ADD_ESTOQUE) {
            System.out.println("Add estoque");
            return view;
        }

        views.put(type, view);

        return view;
    }

    protected Parent load(String fxml) throws IOException {
        FXMLLoader loader = new FXMLLoader(App.class.getResource(fxml));
        loader.setControllerFactory(injector::getInstance);
        return loader.load();
    }
}
