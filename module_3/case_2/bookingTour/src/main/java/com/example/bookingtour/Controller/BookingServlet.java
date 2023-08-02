package com.example.bookingtour.Controller;

import com.example.bookingtour.Model.BookingDto;
import com.example.bookingtour.Service.BookingService;
import com.example.bookingtour.Service.IBookingService;

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
        String count =request.getParameter("count");
        if (action == null) {
            action = "";
        }
//        if(count.equals(tang))

        switch (action) {
            case "addquantitylist":
                try {
                    addQuantityList(request, response);
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
                break;
            case "addquantitycart":
                try {
                    addQuantityCart(request, response);
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
                break;
            case "deletequantitycart":
                try {
                    deleteQuantityCart(request, response);
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
                break;
            case "deletecart":
                try {
                    deleteCart(request, response);
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
                break;
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

    private void deleteCart(HttpServletRequest request, HttpServletResponse response) throws IOException, SQLException {
//        int idCustomer = Integer.parseInt(request.getParameter("idcustomer"));
        int id = Integer.parseInt(request.getParameter("id"));
        service.deleteQuantityCart(id,2);
        response.sendRedirect("/BookingServlet");
    }

    private void deleteQuantityCart(HttpServletRequest request, HttpServletResponse response) throws IOException, SQLException {
//        int idCustomer = Integer.parseInt(request.getParameter("idcustomer"));
        int id = Integer.parseInt(request.getParameter("id"));
        service.deleteQuantity(id,2);
        response.sendRedirect("/BookingServlet");
    }

    private void addQuantityCart(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
//        int idCustomer = Integer.parseInt(request.getParameter("idcustomer"));
        int id = Integer.parseInt(request.getParameter("id"));
        service.addQuantity(id,2);
        response.sendRedirect("/BookingServlet");
    }

    private void addQuantityList(HttpServletRequest request, HttpServletResponse response) throws IOException, SQLException {
//      int idCustomer = Integer.parseInt(request.getParameter("idcustomer"));
        int id = Integer.parseInt(request.getParameter("id"));
        service.addQuantity(id,2);
        response.sendRedirect("/tourServlet");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
    private void showList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
//        int id = Integer.parseInt(request.getParameter("idcustomer"));
        List<BookingDto> bookings = service.display(2);
        request.setAttribute("bookings", bookings);
        double sum =0;
        for(BookingDto bookingDto: bookings) {
            sum+= bookingDto.getTourSumPrice();
        }
        request.setAttribute("sum",sum);
        RequestDispatcher dispatcher = request.getRequestDispatcher("View/cart.jsp");
        dispatcher.forward(request, response);
    }
}