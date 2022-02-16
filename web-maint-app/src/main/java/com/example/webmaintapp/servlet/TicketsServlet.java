package com.example.webmaintapp.servlet;

import com.example.webmaintapp.business.TicketService;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "TicketsServlet", value = "/tickets")
public class TicketsServlet extends HttpServlet {

    private final TicketService ticketService = new TicketService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        String priority = request.getParameter("priority");
        String customerName = request.getParameter("customer");
        String componentName = request.getParameter("component");

        request.setAttribute("ticketList",
            ticketService.findTicketsByCriteria(priority, customerName, componentName));
        request.getRequestDispatcher("WEB-INF/ticket-list.jsp").forward(request, response);
    }

//    @Override
//    protected void doPost(HttpServletRequest request, HttpServletResponse response)
//        throws ServletException, IOException {
//
//    }
}
