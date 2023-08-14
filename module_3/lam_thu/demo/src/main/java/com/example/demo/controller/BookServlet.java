package com.example.demo.controller;

import com.example.demo.model.Book;
import com.example.demo.model.Category;
import com.example.demo.service.BookingService;
import com.example.demo.service.IBookingService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "BookServlet", value = "/BookServlet")
public class BookServlet extends HttpServlet {
    IBookingService service = new BookingService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "theloai":
                try {
                    theLoai(request, response);
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
                break;
            case "delete":
                try {
                    delete(request,response);
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
                break;
            default:
                try {
                    showList(request, response);
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
        }
    }

    private void delete(HttpServletRequest request, HttpServletResponse response) throws IOException, SQLException {
        int id = Integer.parseInt(request.getParameter("id"));
        service.delete(id);
        response.sendRedirect("/BookServlet");
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "add":
                try {
                    addBook(request, response);
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
                break;
        }
    }

    private void theLoai(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
        ArrayList<Category> category = service.category();
        request.setAttribute("theloai", category);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/view/add.jsp");
        dispatcher.forward(request, response);
    }

    private void addBook(HttpServletRequest request, HttpServletResponse response) throws IOException, SQLException {
        String nameBook = request.getParameter("namebook");
        int soLuong = Integer.parseInt(request.getParameter("soluong"));
        String tacGia = request.getParameter("tacgia");
        int theLoai = Integer.parseInt(request.getParameter("theloai"));
        service.add(nameBook, soLuong, tacGia, theLoai);
        response.sendRedirect("/BookServlet");
    }

    private void showList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
        List<Book> books = service.display();
        request.setAttribute("books", books);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/view/list.jsp");
        dispatcher.forward(request, response);
    }
}