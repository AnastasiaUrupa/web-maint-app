package com.example.webmaintapp.servlet;

import com.example.webmaintapp.business.ComponentService;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.lang3.StringUtils;

@WebServlet(name = "ComponentsServlet", value = "/components")
public class ComponentsServlet extends HttpServlet {

    private final ComponentService componentService = new ComponentService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        request.setAttribute("componentList", componentService.getComponentList());
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("WEB-INF/component-list.jsp");
        requestDispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        String name = StringUtils.isEmpty(request.getParameter("name")) ? null : request.getParameter("name");
        String team = StringUtils.isEmpty(request.getParameter("team")) ? null : request.getParameter("team");
        String versionNumber = request.getParameter("version");
        componentService.saveComponent(name, team, versionNumber);
        response.sendRedirect(request.getContextPath() + "/index.jsp");
    }


}
