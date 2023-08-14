package com.example.demoone;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;

@WebServlet(name = "RandomNumberServlet", value = "/RandomNumberServlet")
public class RandomNumberServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/plain");
        PrintWriter out = response.getWriter();

        // Tạo một số ngẫu nhiên từ 1 đến 100
        Random random = new Random();
        int randomNumber = random.nextInt(100) + 1;

        out.print(randomNumber);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}