package com.example.webmaintapp.servlet;

import com.example.webmaintapp.dao.TicketDao;
import com.example.webmaintapp.entity.Priority;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.lang3.EnumUtils;

@WebServlet(name = "TicketsServlet", value = "/tickets")
public class TicketsServlet extends HttpServlet {

    private final TicketDao ticketDao = new TicketDao();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        Priority priority = EnumUtils.getEnumIgnoreCase(Priority.class, request.getParameter("priority"));
        String customerName = request.getParameter("customer");
        String componentName = request.getParameter("component");

        request.setAttribute("ticketList",
            ticketDao.findTicketsByCriteria(priority, customerName, componentName));
        request.getRequestDispatcher("ticket-list.jsp").forward(request, response);
    }

//    @Override
//    protected void doPost(HttpServletRequest request, HttpServletResponse response)
//        throws ServletException, IOException {
//
//    }
}
