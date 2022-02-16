package com.example.webmaintapp.dao;

import com.example.webmaintapp.entity.Component;
import java.util.List;
import javax.persistence.EntityManager;

public class ComponentDao implements Dao<Component> {

    @Override
    public List<Component> getList(EntityManager entityManager) {
        return entityManager.createQuery("from Component", Component.class).getResultList();
    }

    @Override
    public void save(EntityManager entityManager,Component component) {
        entityManager.persist(component);
    }

    @Override
    public Component findById(EntityManager entityManager,Long id) {
        return entityManager.find(Component.class, id);
    }
}
