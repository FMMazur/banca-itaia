package br.ufms.bancas.dao.memory;

import br.ufms.bancas.dao.ProductDao;
import br.ufms.bancas.model.Product;
import br.ufms.bancas.service.SaveService;
import com.google.inject.Inject;

import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Optional;
import java.util.stream.Stream;

public class ProductDaoMemory implements ProductDao {
    private HashMap<String, Product> productMap;

    private static final String FILE = "products.bin";
    private final SaveService saveService;

    @Inject
    @SuppressWarnings("unchecked")
    public ProductDaoMemory(SaveService saveService) {
        this.saveService = saveService;

        try {
            this.productMap = (HashMap<String, Product>) this.saveService.load(HashMap.class, FILE);
        } catch (FileNotFoundException ignored) {
            this.productMap = new HashMap<>();
        }
    }

    @Override
    public void save(Product object) {
        productMap.put(object.getId(), object);
        try {
            this.saveService.save(productMap, FILE);
        } catch (FileNotFoundException ignored) {
        }
    }

    @Override
    public void update(Product object) {
        productMap.replace(object.getId(), object);
        try {
            this.saveService.save(productMap, FILE);
        } catch (FileNotFoundException ignored) {
        }
    }

    @Override
    public void delete(Product object) {
        productMap.remove(object.getId());
        try {
            this.saveService.save(productMap, FILE);
        } catch (FileNotFoundException ignored) {
        }
    }

    @Override
    public void deleteById(Object id) {
        productMap.remove((String) id);
        try {
            this.saveService.save(productMap, FILE);
        } catch (FileNotFoundException ignored) {
        }
    }

    @Override
    public Optional<Product> findOne(Object id) {
        return productMap.values().stream().filter(obj -> obj.getId().equals(id)).findFirst();
    }

    @Override
    public Stream<Product> list() {
        return productMap.values().stream();
    }
}
