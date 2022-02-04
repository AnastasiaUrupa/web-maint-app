package com.example.webmaintapp.dao;

import static com.example.webmaintapp.utils.PersistenceUtils.getEntityManagerFactory;

import com.example.webmaintapp.entity.Component;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ComponentDao {

    private EntityManager entityManager = getEntityManagerFactory().createEntityManager();
    private static final Logger logger = LoggerFactory.getLogger(ComponentDao.class);

    public List<Component> getComponentList() {
        entityManager.getTransaction().begin();
        List<Component> componentList = entityManager.createQuery("from Component", Component.class).getResultList();
        entityManager.getTransaction().commit();
        return componentList;
    }

    public void saveComponent(Component component) {
        EntityTransaction transaction = null;
        try {
            transaction = entityManager.getTransaction();
            transaction.begin();
            entityManager.persist(component);
            transaction.commit();
        } catch (Exception e) {
            logger.error("Unable to save component: " + e.getMessage());
            if (transaction != null) {
                transaction.rollback();
            }
            throw e;
        }
    }

    public Component findComponentById(Long id) {
        entityManager.getTransaction().begin();
        Component component = entityManager.find(Component.class, id);
        entityManager.getTransaction().commit();
        return component;
    }

}
