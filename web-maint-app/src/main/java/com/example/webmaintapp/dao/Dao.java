package com.example.webmaintapp.dao;

import java.util.List;
import javax.persistence.EntityManager;

public interface Dao<T> {

    T findById(EntityManager entityManager, Long id);

    List<T> getList(EntityManager entityManager);

    void save(EntityManager entityManager, T entity);

}
