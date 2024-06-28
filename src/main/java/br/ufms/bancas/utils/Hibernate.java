package br.ufms.bancas.utils;

import br.ufms.bancas.model.*;
import lombok.Getter;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class Hibernate {
    @Getter
    private static SessionFactory sessionFactory;

    static {
        try {

            final StandardServiceRegistry registry =
                    new StandardServiceRegistryBuilder()
                            .applySetting("hibernate.bytecode.use_reflection_optimizer", false)
                            .applySetting("hibernate.bytecode.provider", "javassist")
                            .build();

            // Load settings from hibernate.properties
            sessionFactory = new MetadataSources(registry)
                            .addAnnotatedClass(User.class)
                            .addAnnotatedClass(Product.class)
                            .addAnnotatedClass(Publisher.class)
                            .addAnnotatedClass(DbImage.class)
                            .buildMetadata()
                            .buildSessionFactory();
        } catch (Throwable ex) {
            System.err.println("Initial SessionFactory creation failed." + ex);
            sessionFactory = null;
            ex.printStackTrace();
//            throw new ExceptionInInitializerError(ex);
        }
    }
}
