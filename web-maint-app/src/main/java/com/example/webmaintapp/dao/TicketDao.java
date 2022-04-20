package com.example.webmaintapp.dao;

import com.example.webmaintapp.entity.Component;
import com.example.webmaintapp.entity.Component_;
import com.example.webmaintapp.entity.Customer;
import com.example.webmaintapp.entity.Customer_;
import com.example.webmaintapp.entity.Priority;
import com.example.webmaintapp.entity.Ticket;
import com.example.webmaintapp.entity.Ticket_;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import org.apache.commons.lang3.StringUtils;

public class TicketDao extends AbstractDao<Ticket> {

    public TicketDao(EntityManager entityManager) {
        super(entityManager, Ticket.class);
    }

    public List<Ticket> findTicketsByCriteria(Priority priority, String customerName,
        String componentName) {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Ticket> query = criteriaBuilder.createQuery(Ticket.class);
        Root<Ticket> root = query.from(Ticket.class);
        List<Predicate> predicates = new ArrayList<>();
        if (priority != null) {
            predicates.add(criteriaBuilder.equal(root.get(Ticket_.priority), priority));
        }
        if (StringUtils.isNotEmpty(customerName)) {
            Join<Ticket, Customer> customerJoin = root.join(Ticket_.customer);
            predicates.add(criteriaBuilder.equal(customerJoin.get(Customer_.name), customerName));
        }
        if (StringUtils.isNotEmpty(componentName)) {
            Join<Ticket, Component> componentJoin = root.join(Ticket_.component);
            predicates.add(criteriaBuilder.equal(componentJoin.get(Component_.name), componentName));
        }
        query.where(criteriaBuilder.and(predicates.toArray(new Predicate[0])));
        return entityManager.createQuery(query).getResultList();
    }
}
