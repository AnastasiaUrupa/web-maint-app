package com.example.webmaintapp.utils;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class PersistenceUtils {

    private static EntityManagerFactory entityManagerFactory;

    public static synchronized EntityManagerFactory getEntityManagerFactory() {
        if (entityManagerFactory == null) {
            entityManagerFactory = Persistence.createEntityManagerFactory("MaintAppPU");
        }
        return entityManagerFactory;
    }
}
