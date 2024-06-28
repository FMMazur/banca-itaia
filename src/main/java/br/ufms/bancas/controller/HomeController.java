package br.ufms.bancas.controller;

import br.ufms.bancas.view.ViewLoader;
import com.google.inject.Inject;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.layout.BorderPane;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class HomeController implements Initializable {
    private final ViewLoader viewLoader;
    public BorderPane client_parent;

    @Inject
    public HomeController(ViewLoader viewLoader) {
        this.viewLoader = viewLoader;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        viewLoader.getSelectedView().addListener((observableValue, oldVal, newVal) -> {
            try {
                Parent view = viewLoader.getView(newVal);
                client_parent.setCenter(view);
            } catch (IOException ignored) {

            }
        });
    }
}
