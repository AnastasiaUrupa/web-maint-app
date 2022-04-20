package com.example.webmaintapp.dao;

import java.util.List;
import javax.persistence.EntityManager;

public abstract class AbstractDao<T> implements Dao<T> {

    protected EntityManager entityManager;
    private final Class<T> clazz;

    public AbstractDao(EntityManager entityManager, Class<T> clazz) {
        this.entityManager = entityManager;
        this.clazz = clazz;
    }

    @Override
    public List<T> getList() {
        return entityManager.createQuery("from " + clazz.getName(), clazz).getResultList();
    }

    @Override
    public void save(T entry) {
        entityManager.persist(entry);
    }

    @Override
    public T findById(Long id) {
        return entityManager.find(clazz, id);
    }

}
