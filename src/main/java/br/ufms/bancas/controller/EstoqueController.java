package br.ufms.bancas.controller;

import br.ufms.bancas.model.Product;
import br.ufms.bancas.view.ViewLoader;
import br.ufms.bancas.view.ViewType;
import com.google.inject.Inject;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;

import java.net.URL;
import java.util.ResourceBundle;

public class EstoqueController implements Initializable {
    private final ViewLoader viewLoader;

    @FXML
    public Button add;

    @FXML
    public Button remove;

    @FXML
    public TableView<Product> stock;

    @Inject
    public EstoqueController(ViewLoader viewLoader) {
        this.viewLoader = viewLoader;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        add.setOnAction(e -> {
            viewLoader.getSelectedView().set(ViewType.ADD_ESTOQUE);
        });
    }
}
