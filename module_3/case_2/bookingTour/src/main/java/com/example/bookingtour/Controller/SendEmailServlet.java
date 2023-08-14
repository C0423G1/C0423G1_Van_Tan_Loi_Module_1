package com.example.bookingtour.Controller;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import javax.mail.*;
import javax.mail.internet.*;
import java.util.Properties;

@WebServlet(name = "MailServlet", value = "/MailServlet")
public class SendEmailServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Thông tin đăng nhập tài khoản email gửi
        final String username = "your_email@gmail.com";
        final String password = "your_email_password";

        // Cấu hình thông tin SMTP server
        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");

        // Tạo phiên gửi email
        Session session = Session.getInstance(props, new javax.mail.Authenticator() {
            protected javax.mail.PasswordAuthentication getPasswordAuthentication() {
                return new javax.mail.PasswordAuthentication(username, password);
            }
        });

        // Nội dung email dưới dạng HTML
        String htmlContent = "<html><body>";
        htmlContent += "<h1>Xin chào!</h1>";
        htmlContent += "<p>Đây là một đoạn mã HTML được gửi từ servlet.</p>";
        htmlContent += "</body></html>";

        try {
            // Tạo đối tượng MimeMessage
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(username));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse("recipient_email@example.com"));
            message.setSubject("Test email from servlet");

            // Đặt đoạn mã HTML làm nội dung của email
            message.setContent(htmlContent, "text/html; charset=utf-8");

            // Gửi email
            Transport.send(message);

            response.getWriter().println("Email sent successfully!");
        } catch (MessagingException e) {
            response.getWriter().println("Failed to send email: " + e.getMessage());
        }
    }
}