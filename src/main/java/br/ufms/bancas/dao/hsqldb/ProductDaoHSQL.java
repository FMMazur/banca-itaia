package br.ufms.bancas.dao.hsqldb;

import br.ufms.bancas.dao.ProductDao;
import br.ufms.bancas.model.Product;
import br.ufms.bancas.model.Publisher;
import br.ufms.bancas.utils.SessionManager;
import com.google.inject.Inject;
import org.hibernate.Session;

import java.util.Optional;
import java.util.stream.Stream;

public class ProductDaoHSQL implements ProductDao {
    private final SessionManager sessionManager;

    @Inject
    public ProductDaoHSQL(SessionManager sessionManager) {
        this.sessionManager = sessionManager;
    }

    @Override
    public void save(Product object) {
        sessionManager.save(object);
    }

    @Override
    public void update(Product object) {
        sessionManager.update(object);
    }

    @Override
    public void delete(Product object) {
        sessionManager.delete(object);
    }

    @Override
    public void deleteById(Object id) {

    }

    @Override
    public Optional<Product> findOne(Object id) {
        Session session = sessionManager.getSessionFactory().getCurrentSession();
        Product p = session.find(Product.class, id);

        return Optional.of(p);
    }

    @Override
    public Stream<Product> list() {
        Session session = sessionManager.getSessionFactory().getCurrentSession();

        return session.createQuery("from Product", Product.class).stream();
    }
}
