package br.ufms.bancas.dao.hsqldb;

import br.ufms.bancas.dao.UserDao;
import br.ufms.bancas.model.Publisher;
import br.ufms.bancas.model.User;
import br.ufms.bancas.utils.SessionManager;
import com.google.inject.Inject;
import org.hibernate.Session;

import java.util.Optional;
import java.util.stream.Stream;

public class UserDaoHSQL implements UserDao {
    private final SessionManager sessionManager;

    @Inject
    public UserDaoHSQL(SessionManager sessionManager) {
        this.sessionManager = sessionManager;
    }

    @Override
    public void save(User object) {
        sessionManager.save(object);
    }

    @Override
    public void update(User object) {
        sessionManager.update(object);
    }

    @Override
    public void delete(User object) {
        sessionManager.delete(object);
    }

    @Override
    public void deleteById(Object id) {

    }

    @Override
    public Optional<User> findOne(Object id) {
        Session session = sessionManager.getSessionFactory().getCurrentSession();
        User p = session.find(User.class, id);

        return Optional.of(p);
    }

    @Override
    public Stream<User> list() {
        Session session = sessionManager.getSessionFactory().getCurrentSession();

        return session.createQuery("from User", User.class).stream();
    }

    @Override
    public Optional<User> findByUser(String username) {
        Session session = sessionManager.getSessionFactory().getCurrentSession();

        return session.createQuery("from User u where u.username = :username", User.class).stream().findFirst();
    }
}
