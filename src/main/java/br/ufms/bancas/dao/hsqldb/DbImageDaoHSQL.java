package br.ufms.bancas.dao.hsqldb;

import br.ufms.bancas.dao.DbImageDao;
import br.ufms.bancas.model.DbImage;
import br.ufms.bancas.model.Publisher;
import br.ufms.bancas.utils.SessionManager;
import com.google.inject.Inject;
import org.hibernate.Session;

import java.util.Optional;
import java.util.stream.Stream;

public class DbImageDaoHSQL implements DbImageDao {
    private final SessionManager sessionManager;

    @Inject
    public DbImageDaoHSQL(SessionManager sessionManager) {
        this.sessionManager = sessionManager;
    }

    @Override
    public void save(DbImage object) {
        sessionManager.save(object);
    }

    @Override
    public void update(DbImage object) {
        sessionManager.update(object);
    }

    @Override
    public void delete(DbImage object) {
        sessionManager.delete(object);
    }

    @Override
    public void deleteById(Object id) {
    }

    @Override
    public Optional<DbImage> findOne(Object id) {
        Session session = sessionManager.getSessionFactory().getCurrentSession();
        DbImage di = session.find(DbImage.class, id);

        return Optional.of(di);
    }

    @Override
    public Stream<DbImage> list() {
        Session session = sessionManager.getSessionFactory().getCurrentSession();

        return session.createQuery("from DbImage", DbImage.class).stream();
    }
}
