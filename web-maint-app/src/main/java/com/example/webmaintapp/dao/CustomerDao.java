package com.example.webmaintapp.dao;

import com.example.webmaintapp.entity.Customer;
import java.util.List;
import javax.persistence.EntityManager;

public class CustomerDao implements Dao<Customer> {

    @Override
    public List<Customer> getList(EntityManager entityManager) {
        return entityManager.createQuery("from Customer", Customer.class).getResultList();
    }

    @Override
    public void save(EntityManager entityManager, Customer customer) {
        entityManager.persist(customer);
    }

    @Override
    public Customer findById(EntityManager entityManager, Long id) {
        return entityManager.find(Customer.class, id);
    }
}
