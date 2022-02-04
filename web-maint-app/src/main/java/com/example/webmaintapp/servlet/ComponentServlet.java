package com.example.webmaintapp.servlet;

import static com.example.webmaintapp.utils.PersistenceUtils.getEntityManagerFactory;

import com.example.webmaintapp.dao.ComponentDao;
import com.example.webmaintapp.entity.Component;
import com.example.webmaintapp.entity.Version;
import java.io.IOException;
import javax.persistence.EntityManager;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "ComponentServlet", value = "/component")
public class ComponentServlet extends HttpServlet {

    private ComponentDao componentDao = new ComponentDao();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        Long id = Long.parseLong(request.getParameter("id"));
        EntityManager entityManager = getEntityManagerFactory().createEntityManager();
        entityManager.getTransaction().begin();
        Component component = entityManager.find(Component.class, id);
        entityManager.getTransaction().commit();
        request.setAttribute("component", component);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("component-view.jsp");
        requestDispatcher.forward(request, response);
        entityManager.close();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        Long componentId = Long.parseLong(request.getParameter("id"));
        String version = request.getParameter("version");
        Component component = componentDao.findComponentById(componentId);
        component.addVersion(new Version(version, component));
        componentDao.saveComponent(component);
        response.sendRedirect(request.getContextPath() + "/component?id=" + componentId);

    }


}
