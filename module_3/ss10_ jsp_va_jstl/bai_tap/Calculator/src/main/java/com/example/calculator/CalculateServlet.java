package com.example.calculator;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "CalculateServlet", value = "/CalculateServlet")
public class CalculateServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int firstOperand = Integer.parseInt(request.getParameter("firstoperand"));
        String operator = request.getParameter("operator");
        int secondOperand = Integer.parseInt(request.getParameter("secondoperand"));
        String result = null;
        try {
            if (operator.equals("Addition")) {
                result = String.valueOf(firstOperand + secondOperand);
            } else if (operator.equals("subtraction")) {
                result = String.valueOf(firstOperand - secondOperand);
            } else if (operator.equals("multiplication")) {
                result = String.valueOf(firstOperand * secondOperand);
            } else if (operator.equals("division")) {
                result = String.valueOf(firstOperand / secondOperand);
            }
        } catch (NullPointerException e) {
            result ="Không được chia cho 0";
        }catch (Exception e){
            result = "Lôĩ";
        }
        request.setAttribute("result", result);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("display.jsp");
        requestDispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}