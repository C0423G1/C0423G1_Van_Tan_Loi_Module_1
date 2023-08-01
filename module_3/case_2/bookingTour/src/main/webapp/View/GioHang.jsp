<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: ACER
  Date: 7/31/2023
  Time: 5:15 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Giỏ hàng</title>
    <link rel="stylesheet" href="font.css">
</head>
<body>
<header>
    <h1>Giỏ hàng</h1>
</header>

<div class="cart-container">
    <c:forEach var="bookings" items="${bookings}">
        <div class="product">
            <img src="data:image/jpeg;base64,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"
                 alt="Sản phẩm 1">
            <div class="product-info">
                <div class="product-name">${bookings.customerName}</div>
                <div class="product-price">${bookings.tourName}</div>
                <div class="product-quantity">
                    <a href="/BookingServlet?action=tang="><button class="quantity-btn" onclick="decreaseQuantity(this)" >-</button></a>
                    <span class="quantity">${bookings.quantity}</span>
                    <button class="quantity-btn" onclick="increaseQuantity(this)">+</button>
                </div>
                <div class="total-price">Tổng tiền: $50</div>
            </div>
        </div>
    </c:forEach>
    <br>
    <h4>Tổng tiền : $1000</h4>
</div>
</body>
</html>
