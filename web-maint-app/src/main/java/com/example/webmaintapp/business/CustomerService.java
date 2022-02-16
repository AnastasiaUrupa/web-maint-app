package com.example.webmaintapp.business;

import static com.example.webmaintapp.utils.PersistenceUtils.getEntityManagerFactory;

import com.example.webmaintapp.dao.CustomerDao;
import com.example.webmaintapp.entity.Customer;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CustomerService {

    private static final Logger logger = LoggerFactory.getLogger(CustomerService.class);

    private final CustomerDao customerDao = new CustomerDao();
    private final EntityManager entityManager = getEntityManagerFactory().createEntityManager();

    public void saveCustomer(String name, String person) {
        Customer customer = new Customer(name, person);
        EntityTransaction transaction = null;
        try {
            transaction = entityManager.getTransaction();
            transaction.begin();
            customerDao.save(entityManager, customer);
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
        Customer customer = customerDao.findById(entityManager,id);
        entityManager.getTransaction().commit();
        return customer;
    }

    public List<Customer> getCustomerList() {
        entityManager.getTransaction().begin();
        List<Customer> customerList = customerDao.getList(entityManager);
        entityManager.getTransaction().commit();
        return customerList;
    }

}
