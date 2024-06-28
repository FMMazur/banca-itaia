package br.ufms.bancas.controller;

import br.ufms.bancas.model.Product;
import br.ufms.bancas.model.Publisher;
import br.ufms.bancas.service.EstoqueService;
import br.ufms.bancas.view.ViewLoader;
import br.ufms.bancas.view.ViewType;
import com.google.inject.Inject;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class CadastroEstoqueController implements Initializable {
    private final ViewLoader viewLoader;
    private final EstoqueService estoqueService;

    @FXML
    public Button register;
    @FXML
    private TextField quantity;
    @FXML
    private TextField sell_price;
    @FXML
    private TextField supplier;
    @FXML
    private TextField codigoProduto;
    @FXML
    private TextField publisher;
    @FXML
    private TextField edition;
    @FXML
    private TextField stock_price;
    @FXML
    private TextField type;

    @Inject
    public CadastroEstoqueController(ViewLoader viewLoader, EstoqueService estoqueService) {
        this.viewLoader = viewLoader;
        this.estoqueService = estoqueService;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        register.setOnAction(e -> {

            String quantityText = quantity.getText();
            String sellPriceText = sell_price.getText();
            String supplierText = supplier.getText();
            String codigoProdutoText = codigoProduto.getText();
            String publisherText = publisher.getText();
            String editionText = edition.getText();
            String stockPriceText = stock_price.getText();
            String typeText = type.getText();

            Product product = new Product(codigoProdutoText, typeText, editionText, Double.parseDouble(stockPriceText), Double.parseDouble(sellPriceText), supplierText, Long.parseLong(quantityText), publisherText, Product.Type.Journal);
            this.estoqueService.adicionar(product);

            this.viewLoader.getSelectedView().set(ViewType.ESTOQUE);
        });
    }
}
