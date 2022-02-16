package com.example.webmaintapp.servlet;

import com.example.webmaintapp.business.ComponentService;
import com.example.webmaintapp.business.CustomerService;
import com.example.webmaintapp.business.TicketService;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "TicketServlet", value = "/ticket")
public class TicketServlet extends HttpServlet {

    private final CustomerService customerService = new CustomerService();
    private final ComponentService componentService = new ComponentService();
    private final TicketService ticketService = new TicketService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        request.setAttribute("customerList", customerService.getCustomerList());
        request.setAttribute("componentList", componentService.getComponentList());
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("WEB-INF/ticket.jsp");
        requestDispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        String title = request.getParameter("title");
        String description = request.getParameter("description");
        Long customerId = Long.parseLong(request.getParameter("customer"));
        Long componentId = Long.parseLong(request.getParameter("component"));
        String priority = request.getParameter("priority");
        ticketService.saveTicket(title, description, customerId, componentId, priority);
        response.sendRedirect(request.getContextPath() + "/index.jsp");
    }
}
