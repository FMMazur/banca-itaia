package br.ufms.bancas.service;

import br.ufms.bancas.dao.ProductDao;
import br.ufms.bancas.model.Product;
import com.google.inject.Inject;

public class EstoqueService {
    private final ProductDao productDao;

    @Inject
    public EstoqueService(ProductDao productDao) {
        this.productDao = productDao;
    }

    public void adicionar(Product product) {
        productDao.save(product);
    }

    public void remover(String id) {
        productDao.deleteById(id);
    }
}
