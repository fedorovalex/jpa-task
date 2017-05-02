
package com.epam.javatc.utils;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


public class EntityManagerFactoryCreator {
    private static EntityManagerFactory entityManagerFactory = null;

    private EntityManagerFactoryCreator() {
    }
    
    public static EntityManagerFactory getEntityManagerFactory() {
        if (entityManagerFactory == null) {
            entityManagerFactory = Persistence.createEntityManagerFactory("jpaTask");
        }
        return entityManagerFactory;
    }
}