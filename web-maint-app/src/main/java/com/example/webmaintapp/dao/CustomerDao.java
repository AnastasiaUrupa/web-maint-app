package com.example.webmaintapp.dao;

import com.example.webmaintapp.entity.Customer;
import javax.persistence.EntityManager;

public class CustomerDao extends AbstractDao<Customer> {

    public CustomerDao(EntityManager entityManager) {
        super(entityManager, Customer.class);
    }
}
