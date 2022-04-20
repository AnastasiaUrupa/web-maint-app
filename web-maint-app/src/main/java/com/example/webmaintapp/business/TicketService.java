package com.example.webmaintapp.business;

import static com.example.webmaintapp.utils.PersistenceUtils.getEntityManagerFactory;

import com.example.webmaintapp.dao.TicketDao;
import com.example.webmaintapp.entity.Component;
import com.example.webmaintapp.entity.Customer;
import com.example.webmaintapp.entity.Priority;
import com.example.webmaintapp.entity.Status;
import com.example.webmaintapp.entity.Ticket;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import org.apache.commons.lang3.EnumUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TicketService {

    private static final Logger logger = LoggerFactory.getLogger(TicketService.class);
    private final EntityManager entityManager = getEntityManagerFactory().createEntityManager();
    private final TicketDao ticketDao = new TicketDao(entityManager);

    public void saveTicket(String title, String description, Long customerId, Long componentId, String priority) {
        Ticket ticket = new Ticket();
        ticket.setTitle(title);
        ticket.setDescription(description);
        ticket.setCustomer(entityManager.getReference(Customer.class, customerId));
        ticket.setComponent(entityManager.getReference(Component.class, componentId));
        ticket.setPriority(Priority.valueOf(priority));
        ticket.setStatus(Status.OPEN);
        EntityTransaction transaction = null;
        try {
            transaction = entityManager.getTransaction();
            transaction.begin();
            ticketDao.save(ticket);
            transaction.commit();
        } catch (Exception e) {
            logger.error("Unable to save ticket: " + e.getMessage());
            if (transaction != null) {
                transaction.rollback();
            }
            throw e;
        }
    }

    public List<Ticket> findTicketsByCriteria(String priority, String customerName, String componentName) {
        Priority priorityValue = EnumUtils.getEnumIgnoreCase(Priority.class, priority);
        entityManager.getTransaction().begin();
        List<Ticket> ticketList = ticketDao.findTicketsByCriteria(priorityValue, customerName, componentName);
        entityManager.getTransaction().commit();
        return ticketList;
    }

}
