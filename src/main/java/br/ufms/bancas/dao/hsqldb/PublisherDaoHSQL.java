package br.ufms.bancas.dao.hsqldb;

import br.ufms.bancas.dao.PublisherDao;
import br.ufms.bancas.model.Publisher;
import br.ufms.bancas.utils.SessionManager;
import com.google.inject.Inject;
import org.hibernate.Session;

import java.util.Optional;
import java.util.stream.Stream;

public class PublisherDaoHSQL implements PublisherDao {
    private final SessionManager sessionManager;

    @Inject
    public PublisherDaoHSQL(SessionManager sessionManager) {
        this.sessionManager = sessionManager;
    }

    @Override
    public Stream<Publisher> findByName(String name) {
        Session session = sessionManager.getSessionFactory().getCurrentSession();

        return session.createQuery("from Publisher p where p.name = :name", Publisher.class)
                .setParameter("name", name)
                .stream();
    }

    @Override
    public void save(Publisher object) {
        sessionManager.save(object);
    }

    @Override
    public void update(Publisher object) {
        sessionManager.update(object);
    }

    @Override
    public void delete(Publisher object) {
        sessionManager.delete(object);
    }

    @Override
    public void deleteById(Object id) {

    }

    @Override
    public Optional<Publisher> findOne(Object id) {
        Session session = sessionManager.getSessionFactory().getCurrentSession();
        Publisher p = session.find(Publisher.class, id);

        return Optional.of(p);
    }

    @Override
    public Stream<Publisher> list() {
        Session session = sessionManager.getSessionFactory().getCurrentSession();

        return session.createQuery("from Publisher", Publisher.class).stream();
    }
}
