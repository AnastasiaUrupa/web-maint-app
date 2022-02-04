package com.example.webmaintapp.servlet;

import com.example.webmaintapp.dao.CustomerDao;
import com.example.webmaintapp.entity.Customer;
import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.lang3.StringUtils;

@WebServlet(name = "CustomerServlet", value = "/customer")
public class CustomerServlet extends HttpServlet {

    private final CustomerDao customerDao = new CustomerDao();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        List<Customer> customerList = customerDao.getCustomerList();
        request.setAttribute("customerList", customerList);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("customer-list.jsp");
        requestDispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        String name = StringUtils.isEmpty(request.getParameter("name")) ? null : request.getParameter("name");
        String person = StringUtils.isEmpty(request.getParameter("person")) ? null : request.getParameter("person");
        Customer customer = new Customer(name, person);
        customerDao.saveCustomer(customer);
        response.sendRedirect(request.getContextPath() + "/index.jsp");
    }
}
