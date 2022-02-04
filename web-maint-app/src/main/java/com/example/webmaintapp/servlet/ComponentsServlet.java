package com.example.webmaintapp.servlet;

import com.example.webmaintapp.dao.ComponentDao;
import com.example.webmaintapp.entity.Component;
import com.example.webmaintapp.entity.Version;
import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.lang3.StringUtils;

@WebServlet(name = "ComponentsServlet", value = "/components")
public class ComponentsServlet extends HttpServlet {

    private final ComponentDao componentDao = new ComponentDao();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        List<Component> componentList = componentDao.getComponentList();
        request.setAttribute("componentList", componentList);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("component-list.jsp");
        requestDispatcher.forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        String name = StringUtils.isEmpty(request.getParameter("name")) ? null : request.getParameter("name");
        String team = StringUtils.isEmpty(request.getParameter("team")) ? null : request.getParameter("team");
        String versionNumber = request.getParameter("version");
        Component component = new Component(name, team);
        if (!StringUtils.isEmpty(versionNumber)) {
            component.addVersion(new Version(versionNumber, component));
        }
        componentDao.saveComponent(component);
        response.sendRedirect(request.getContextPath() + "/index.jsp");
    }


}
