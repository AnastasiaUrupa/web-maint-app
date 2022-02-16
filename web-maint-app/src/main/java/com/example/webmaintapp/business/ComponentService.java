package com.example.webmaintapp.business;

import static com.example.webmaintapp.utils.PersistenceUtils.getEntityManagerFactory;

import com.example.webmaintapp.dao.ComponentDao;
import com.example.webmaintapp.entity.Component;
import com.example.webmaintapp.entity.Version;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ComponentService {

    private static final Logger logger = LoggerFactory.getLogger(ComponentService.class);

    private final ComponentDao componentDao = new ComponentDao();
    private final EntityManager entityManager = getEntityManagerFactory().createEntityManager();

    public void saveComponent(String name, String team, String versionNumber) {
        Component component = new Component(name, team);
        if (!StringUtils.isEmpty(versionNumber)) {
            component.addVersion(new Version(versionNumber, component));
        }
        EntityTransaction transaction = null;
        try {
            transaction = entityManager.getTransaction();
            transaction.begin();
            componentDao.save(entityManager, component);
            transaction.commit();
        } catch (Exception e) {
            logger.error("Unable to save component: " + e.getMessage());
            if (transaction != null) {
                transaction.rollback();
            }
            throw e;
        }
    }

    public Component getComponentById(Long id) {
        entityManager.getTransaction().begin();
        Component component = componentDao.findById(entityManager, id);
        entityManager.getTransaction().commit();
        return component;
    }

    public List<Component> getComponentList() {
        entityManager.getTransaction().begin();
        List<Component> componentList = componentDao.getList(entityManager);
        entityManager.getTransaction().commit();
        return componentList;
    }

    public void addVersionToComponent(Long componentId, String version) {
        EntityTransaction transaction = null;
        try {
            transaction = entityManager.getTransaction();
            transaction.begin();
            Component component = componentDao.findById(entityManager, componentId);
            component.addVersion(new Version(version, component));
            componentDao.save(entityManager, component);
            transaction.commit();
        } catch (Exception e) {
            logger.error("Unable to save component: " + e.getMessage());
            if (transaction != null) {
                transaction.rollback();
            }
            throw e;
        }
    }

}
