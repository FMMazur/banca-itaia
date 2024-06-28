package br.ufms.bancas.utils;

import com.google.inject.Singleton;
import org.hibernate.SessionFactory;

@Singleton
public class SessionManager {
    public void save(Object object) {
        Hibernate.getSessionFactory().inTransaction(session -> session.persist(object));
    }

    public void update(Object object) {
        Hibernate.getSessionFactory().inTransaction(session -> session.merge(object));
    }

    public void delete(Object object) {
        getSessionFactory().inTransaction(session -> session.remove(object));
    }

    public SessionFactory getSessionFactory() {
        return Hibernate.getSessionFactory();
    }
}
