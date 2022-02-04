package com.example.webmaintapp.servlet;

import com.example.webmaintapp.dao.ComponentDao;
import com.example.webmaintapp.dao.CustomerDao;
import com.example.webmaintapp.dao.TicketDao;
import com.example.webmaintapp.entity.Priority;
import com.example.webmaintapp.entity.Status;
import com.example.webmaintapp.entity.Ticket;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "TicketServlet", value = "/ticket")
public class TicketServlet extends HttpServlet {

    private final CustomerDao customerDao = new CustomerDao();
    private final ComponentDao componentDao = new ComponentDao();
    private final TicketDao ticketDao = new TicketDao();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        request.setAttribute("customerList", customerDao.getCustomerList());
        request.setAttribute("componentList", componentDao.getComponentList());
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("ticket.jsp");
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
        Ticket ticket = new Ticket();
        ticket.setTitle(title);
        ticket.setDescription(description);
        ticket.setCustomer(customerDao.findCustomerById(customerId));
        ticket.setComponent(componentDao.findComponentById(componentId));
        ticket.setPriority(Priority.valueOf(priority));
        ticket.setStatus(Status.OPEN);
        ticketDao.saveTicket(ticket);
        response.sendRedirect(request.getContextPath() + "/index.jsp");
    }
}
