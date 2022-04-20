package com.example.webmaintapp.dao;

import com.example.webmaintapp.entity.Component;
import javax.persistence.EntityManager;

public class ComponentDao extends AbstractDao<Component> {

    public ComponentDao(EntityManager entityManager) {
        super(entityManager, Component.class);
    }
}
