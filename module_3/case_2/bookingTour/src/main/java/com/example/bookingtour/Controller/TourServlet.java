package com.example.bookingtour.Controller;

import com.example.bookingtour.Model.Tours;
import com.example.bookingtour.Repository.BaseRepository;
import com.example.bookingtour.Service.ITourService;
import com.example.bookingtour.Service.TourService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "TourService", value = "/tourServlet")
public class TourServlet extends HttpServlet {
    ITourService service =new TourService();


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            showList(request,response);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    private void showList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
        List<Tours> tours = service.display();
        request.setAttribute("tours", tours);
        RequestDispatcher dispatcher = request.getRequestDispatcher("View/list.jsp");
        dispatcher.forward(request, response);
    }
}