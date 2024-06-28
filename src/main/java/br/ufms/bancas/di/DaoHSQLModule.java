package br.ufms.bancas.di;

import br.ufms.bancas.dao.DbImageDao;
import br.ufms.bancas.dao.ProductDao;
import br.ufms.bancas.dao.PublisherDao;
import br.ufms.bancas.dao.UserDao;
import br.ufms.bancas.dao.hsqldb.DbImageDaoHSQL;
import br.ufms.bancas.dao.hsqldb.ProductDaoHSQL;
import br.ufms.bancas.dao.hsqldb.PublisherDaoHSQL;
import br.ufms.bancas.dao.hsqldb.UserDaoHSQL;
import br.ufms.bancas.utils.Hibernate;
import com.google.inject.AbstractModule;

public class DaoHSQLModule extends AbstractModule {
    @Override
    protected void configure() {
        Hibernate.getSessionFactory();

        bind(DbImageDao.class).to(DbImageDaoHSQL.class);
        bind(PublisherDao.class).to(PublisherDaoHSQL.class);
        bind(ProductDao.class).to(ProductDaoHSQL.class);
        bind(UserDao.class).to(UserDaoHSQL.class);
    }
}
