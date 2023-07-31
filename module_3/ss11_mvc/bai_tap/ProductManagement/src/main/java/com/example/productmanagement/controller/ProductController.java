package com.example.productmanagement.controller;

import com.example.productmanagement.model.Product;
import com.example.productmanagement.service.IProductService;
import com.example.productmanagement.service.ProductService;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ProductController", value = "/ProductController")
public class ProductController extends HttpServlet {
    IProductService service = new ProductService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "Create":
                showAdd(request, response);
                break;
            case "Delete":
                showDelete(request, response);
                break;
            case "Edit":
                showEdit(request, response);
                break;
            default:
                showList(request, response);
        }
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        switch (action) {
            case "Create":
                add(request, response);
                break;
            case "Edit":
                edit(request, response);
                break;
            case "Delete":
                delete(request, response);
                break;
        }
    }

    private void showEdit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Product product = service.findById(id);
        request.setAttribute("editproduct", product);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("view/edit.jsp");
        requestDispatcher.forward(request, response);
    }

    private void showAdd(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = service.autoId()+1;
        request.setAttribute("id",id);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("view/add.jsp");
        requestDispatcher.forward(request, response);
    }

    private void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int index = Integer.parseInt(request.getParameter("id"));
        service.findById(index);
        service.delete(index);
        response.sendRedirect("/ProductController");
    }

    private void showDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Product product = service.findById(id);
        request.setAttribute("editproduct", product);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("view/delete.jsp");
        requestDispatcher.forward(request, response);
    }

    private void showList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Product> products = service.display();
        request.setAttribute("products", products);
        RequestDispatcher dispatcher = request.getRequestDispatcher("view/display.jsp");
        dispatcher.forward(request, response);
    }

    private void add(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        double gia = Double.parseDouble(request.getParameter("gia"));
        String moTa = request.getParameter("mota");
        String nhaSanXuat = request.getParameter("nhasanxuat");
        service.add(new Product(id, name, gia, moTa, nhaSanXuat));
        response.sendRedirect("/ProductController");
    }

    private void edit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        double gia = Double.parseDouble(request.getParameter("gia"));
        String moTa = request.getParameter("mota");
        String nhaSanXuat = request.getParameter("nhasanxuat");
        service.edit(new Product(id, name, gia, moTa, nhaSanXuat));
        response.sendRedirect("/ProductController");
    }
}