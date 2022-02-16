package com.example.webmaintapp.servlet;

import com.example.webmaintapp.business.ComponentService;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "ComponentServlet", value = "/component")
public class ComponentServlet extends HttpServlet {

    private final ComponentService componentService = new ComponentService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        Long id = Long.parseLong(request.getParameter("id"));
        request.setAttribute("component", componentService.getComponentById(id));
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("WEB-INF/component-view.jsp");
        requestDispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        Long componentId = Long.parseLong(request.getParameter("id"));
        String version = request.getParameter("version");
        componentService.addVersionToComponent(componentId, version);
        response.sendRedirect(request.getContextPath() + "/component?id=" + componentId);

    }


}
