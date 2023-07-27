package com.example.productmanagement.controller;

import com.example.productmanagement.model.Product;
import com.example.productmanagement.repository.IProductRepository;
import com.example.productmanagement.repository.ProductRepository;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "ProductServlet", value = "/ProductServlet")
public class ProductServlet extends HttpServlet {
    IProductRepository repository = new ProductRepository();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "Thêm Mới":
                showAdd(request, response);
                break;
            case "Xoá":
                showDelete(request, response);
                break;
            case "Sửa":
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
            case "Hoàn Thành Thêm Mới":
                add(request, response);
            case "Hoàn Thành Sửa":
                edit(request, response);
        }
    }

    private void showEdit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Product product = repository.findById(id-1);
        request.setAttribute("editproduct", product);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("view/edit.jsp");
        requestDispatcher.forward(request, response);
    }

    private void showAdd(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("view/add.jsp");
        requestDispatcher.forward(request, response);
    }

    private void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("view/add.jsp");
        requestDispatcher.forward(request, response);
    }

    private void showDelete(HttpServletRequest request, HttpServletResponse response) {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("view/delete.jsp");
    }

    private void showList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ArrayList<Product> products = repository.display();
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
        repository.add(new Product(id, name, gia, moTa, nhaSanXuat));
        response.sendRedirect("/ProductServlet");
    }

    private void edit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = (Integer.parseInt(request.getParameter("id")))-1;
        String name = request.getParameter("name");
        repository.editName(id, name);
        double gia = Double.parseDouble(request.getParameter("gia"));
        repository.editGia(id, gia);
        String moTa = request.getParameter("mota");
        repository.editMoTa(id, moTa);
        String nhaSanXuat = request.getParameter("nhasanxuat");
        repository.editNhaSanXuat(id, nhaSanXuat);
        response.sendRedirect("/ProductServlet");
    }
}