package com.example.bookingtour.Controller;

import com.example.bookingtour.Model.BookingDto;
import com.example.bookingtour.Model.Bookings;
import com.example.bookingtour.Model.Tours;
import com.example.bookingtour.Service.BookingService;
import com.example.bookingtour.Service.IBookingService;
import com.example.bookingtour.Service.ITourService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "BookingServlet", value = "/BookingServlet")
public class BookingServlet extends HttpServlet {
    IBookingService service = new BookingService();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        String count =request.getRequestDispatcher("count")
        if (action == null) {
            action = "";
        }
        if(count.equals(tang))

        switch (action) {
//            case "Create":
//                showNewForm(request, response);
//                break;
//            case "edit":
//                try {
//                    showEditForm(request, response);
//                } catch (SQLException e) {
//                    throw new RuntimeException(e);
//                }
//                break;
//            case "Delete":
//                try {
//                    deleteUser(request, response);
//                } catch (SQLException e) {
//                    throw new RuntimeException(e);
//                }
//                break;
//            case "arrange":
//                try {
//                    showArrange(request,response);
//                } catch (SQLException e) {
//                    throw new RuntimeException(e);
//                }
//                break;
//            case "search":
//                try {
//                    showSearch(request,response);
//                } catch (SQLException e) {
//                    throw new RuntimeException(e);
//                }
            default:
                try {
                    showList(request,response);
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
                break;
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
    private void showList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
        List<BookingDto> bookings = service.display();
        request.setAttribute("bookings", bookings);
        RequestDispatcher dispatcher = request.getRequestDispatcher("View/GioHang.jsp");
        dispatcher.forward(request, response);
    }
}