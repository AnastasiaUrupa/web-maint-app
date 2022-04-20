package com.example.webmaintapp.dao;

import java.util.List;

public interface Dao<T> {

    T findById(Long id);

    List<T> getList();

    void save(T entity);

}
