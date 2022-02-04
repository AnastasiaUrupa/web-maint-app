package com.example.webmaintapp.dao;

import static com.example.webmaintapp.utils.PersistenceUtils.getEntityManagerFactory;

import com.example.webmaintapp.entity.Ticket;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TicketDao {

    private EntityManager entityManager = getEntityManagerFactory().createEntityManager();
    private static final Logger logger = LoggerFactory.getLogger(TicketDao.class);

    public void saveTicket(Ticket ticket) {
        EntityTransaction transaction = null;
        try {
            transaction = entityManager.getTransaction();
            transaction.begin();
            entityManager.persist(ticket);
            transaction.commit();
        } catch (Exception e) {
            logger.error("Unable to save ticket: " + e.getMessage());
            if (transaction != null) {
                transaction.rollback();
            }
            throw e;
        }

    }


}
