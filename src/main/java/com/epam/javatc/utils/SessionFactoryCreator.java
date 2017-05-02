package com.epam.javatc.utils;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.boot.MetadataSources;


public class SessionFactoryCreator {
    private static SessionFactory sessionFactory = null;

    private SessionFactoryCreator() {
    }
    
    public static SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
                .configure()
                .build();
            try {
                sessionFactory = new MetadataSources( registry ).buildMetadata().buildSessionFactory();
            }
            catch (Exception e) {
                StandardServiceRegistryBuilder.destroy( registry );
                throw new ExceptionInInitializerError("Initial SessionFactory failed" + e);
            }
        }
        return sessionFactory;
    }
}