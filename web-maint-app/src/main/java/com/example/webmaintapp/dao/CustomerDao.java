package com.example.webmaintapp.dao;

import static com.example.webmaintapp.utils.PersistenceUtils.getEntityManagerFactory;

import com.example.webmaintapp.entity.Customer;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CustomerDao {

    private final EntityManager entityManager = getEntityManagerFactory().createEntityManager();
    private static final Logger logger = LoggerFactory.getLogger(CustomerDao.class);

    public List<Customer> getCustomerList() {
        entityManager.getTransaction().begin();
        List<Customer> customerList = entityManager.createQuery("from Customer", Customer.class).getResultList();
        entityManager.getTransaction().commit();
        return customerList;
    }


    public void saveCustomer(Customer customer) {
        EntityTransaction transaction = null;
        try {
            transaction = entityManager.getTransaction();
            transaction.begin();
            entityManager.persist(customer);
            transaction.commit();
        } catch (Exception e) {
            logger.error("Unable to save customer: " + e.getMessage());
            if (transaction != null) {
                transaction.rollback();
            }
            throw e;

        }
    }

    public Customer findCustomerById(Long id) {
        entityManager.getTransaction().begin();
        Customer customer = entityManager.find(Customer.class, id);
        entityManager.getTransaction().commit();
        return customer;
    }


}
