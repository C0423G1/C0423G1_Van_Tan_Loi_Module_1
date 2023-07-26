package com.example.customer;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "CustomerServlet", value = "/customer-servlet")
public class CustomerServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ArrayList<Customer> customerArrayList = new ArrayList<>();
        customerArrayList.add(new Customer("Mai Văn Hoàn","1900-12-12","Hà Nội","https://smilemedia.vn/wp-content/uploads/2022/09/cach-chup-hinh-the-dep.jpeg"));
        customerArrayList.add(new Customer("Mai Văn Hoàn","1900-12-12","Hà Nội","https://smilemedia.vn/wp-content/uploads/2022/09/cach-chup-hinh-the-dep.jpeg"));
        customerArrayList.add(new Customer("Mai Văn Hoàn","1900-12-12","Hà Nội","https://smilemedia.vn/wp-content/uploads/2022/09/cach-chup-hinh-the-dep.jpeg"));
        customerArrayList.add(new Customer("Mai Văn Hoàn","1900-12-12","Hà Nội","https://smilemedia.vn/wp-content/uploads/2022/09/cach-chup-hinh-the-dep.jpeg"));
        customerArrayList.add(new Customer("Mai Văn Hoàn","1900-12-12","Hà Nội","https://smilemedia.vn/wp-content/uploads/2022/09/cach-chup-hinh-the-dep.jpeg"));
        request.setAttribute("customerArrayList",customerArrayList);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("Customer.jsp");
        requestDispatcher.forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}