package com.example.webmaintapp.servlet;

import com.example.webmaintapp.business.CustomerService;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.lang3.StringUtils;

@WebServlet(name = "CustomerServlet", value = "/customer")
public class CustomerServlet extends HttpServlet {

    private final CustomerService customerService = new CustomerService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        request.setAttribute("customerList", customerService.getCustomerList());
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("WEB-INF/customer-list.jsp");
        requestDispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        String name = StringUtils.isEmpty(request.getParameter("name")) ? null : request.getParameter("name");
        String person = StringUtils.isEmpty(request.getParameter("person")) ? null : request.getParameter("person");
        customerService.saveCustomer(name, person);
        response.sendRedirect(request.getContextPath() + "/index.jsp");
    }
}
