package br.ufms.bancas.controller;

import br.ufms.bancas.view.ViewLoader;
import br.ufms.bancas.view.ViewType;
import com.google.inject.Inject;
import javafx.fxml.Initializable;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

import java.net.URL;
import java.util.ResourceBundle;

public class MenuOptionsController implements Initializable {
    private final ViewLoader viewLoader;

    @FXML
    private Button estoque;
    @FXML
    private Button produtos;
    @FXML
    private Button vendas;
    @FXML
    private Button pedidos;
    @FXML
    private Button vender;
    @FXML
    private Button dashboard;

    @Inject
    public MenuOptionsController(ViewLoader viewLoader) {
        this.viewLoader = viewLoader;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        addListeners();
    }

    private void addListeners() {
        estoque.setOnAction(e -> onClick(ViewType.ESTOQUE));
        produtos.setOnAction(e -> onClick(ViewType.PRODUTOS));
        vendas.setOnAction(e -> onClick(ViewType.VENDAS));
        pedidos.setOnAction(e -> onClick(ViewType.PEDIDOS));
        vender.setOnAction(e -> onClick(ViewType.VENDER));
        dashboard.setOnAction(e -> onClick(ViewType.HOME));
    }

    private void onClick(ViewType vw) {
        viewLoader.getSelectedView().set(vw);
    }
}
