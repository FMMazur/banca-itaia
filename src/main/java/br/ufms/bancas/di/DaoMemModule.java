package br.ufms.bancas.di;

import br.ufms.bancas.dao.DbImageDao;
import br.ufms.bancas.dao.ProductDao;
import br.ufms.bancas.dao.PublisherDao;
import br.ufms.bancas.dao.UserDao;
import br.ufms.bancas.dao.memory.DbImageDaoMemory;
import br.ufms.bancas.dao.memory.ProductDaoMemory;
import br.ufms.bancas.dao.memory.PublisherDaoMemory;
import br.ufms.bancas.dao.memory.UserDaoMemory;
import br.ufms.bancas.model.DbImage;
import br.ufms.bancas.model.Product;
import br.ufms.bancas.model.User;
import com.esotericsoftware.kryo.Kryo;
import com.google.inject.AbstractModule;

import java.util.HashMap;

public class DaoMemModule extends AbstractModule {
    @Override
    protected void configure() {
        Kryo kryo = new Kryo();
        kryo.register(HashMap.class);
        kryo.register(DbImage.class);
        kryo.register(Product.class);
        kryo.register(User.class);
        kryo.register(Product.class);

        bind(Kryo.class).toInstance(kryo);

        bind(DbImageDao.class).to(DbImageDaoMemory.class);
        bind(PublisherDao.class).to(PublisherDaoMemory.class);
        bind(ProductDao.class).to(ProductDaoMemory.class);
        bind(UserDao.class).to(UserDaoMemory.class);
    }
}
