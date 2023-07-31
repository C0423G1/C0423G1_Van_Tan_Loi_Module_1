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
  <title>Trang bán sản phẩm</title>
  <style>
    body {
      font-family: Arial, sans-serif;
      margin: 0;
      padding: 0;
    }

    header {
      background-color: #333;
      color: #fff;
      padding: 10px;
      text-align: center;
    }

    .product-container {
      display: flex;
      flex-wrap: wrap;
      justify-content: center;
      margin: 20px;
    }

    .product {
      border: 1px solid #ccc;
      border-radius: 5px;
      padding: 10px;
      width: 200px;
      margin: 10px;
      text-align: center;
    }

    .product img {
      max-width: 100%;
      height: auto;
    }

    .product-name {
      font-weight: bold;
      margin: 5px 0;
    }

    .product-price {
      color: #d63f3f;
      font-weight: bold;
    }
  </style>
</head>
<body>
<header>
  <h1>Trang bán sản phẩm</h1>
</header>

<div class="product-container">
  <c:forEach var="SanPham" items="${tours}">
    <div class="product">
      <img src="https://haycafe.vn/wp-content/uploads/2022/03/anh-sach.jpg" alt="Sản phẩm 1">
      <div class="product-name">${SanPham.tourName}</div>
      <div class="product-price">${SanPham.tourPrice}</div>
      <button class="cart-button">
        <span class="cart-icon">&#128722;</span> <!-- Unicode for shopping cart icon -->
        Thêm vào giỏ hàng
      </button>
    </div>
  </c:forEach>

<%--  <div class="product">--%>
<%--    <img src="https://haycafe.vn/wp-content/uploads/2022/03/anh-sach.jpg" alt="Sản phẩm 2">--%>
<%--    <div class="product-name">Sản phẩm 2</div>--%>
<%--    <div class="product-price">$30</div>--%>
<%--    <button class="cart-button">--%>
<%--      <span class="cart-icon">&#128722;</span> <!-- Unicode for shopping cart icon -->--%>
<%--      Thêm vào giỏ hàng--%>
<%--    </button>--%>
<%--  </div>--%>
<%--  <div class="product">--%>
<%--    <img src="https://haycafe.vn/wp-content/uploads/2022/03/anh-sach.jpg" alt="Sản phẩm 3">--%>
<%--    <div class="product-name">Sản phẩm 3</div>--%>
<%--    <div class="product-price">$80</div>--%>
<%--    <button class="cart-button">--%>
<%--      <span class="cart-icon">&#128722;</span> <!-- Unicode for shopping cart icon -->--%>
<%--      Thêm vào giỏ hàng--%>
<%--    </button>--%>
<%--  </div>--%>
<%--  <div class="product">--%>
<%--    <img src="https://haycafe.vn/wp-content/uploads/2022/03/anh-sach.jpg" alt="Sản phẩm 4">--%>
<%--    <div class="product-name">Sản phẩm 4</div>--%>
<%--    <div class="product-price">$10</div>--%>
<%--    <button class="cart-button">--%>
<%--      <span class="cart-icon">&#128722;</span> <!-- Unicode for shopping cart icon -->--%>
<%--      Thêm vào giỏ hàng--%>
<%--    </button>--%>
<%--  </div>--%>
<%--  <div class="product">--%>
<%--    <img src="https://haycafe.vn/wp-content/uploads/2022/03/anh-sach.jpg" alt="Sản phẩm 5">--%>
<%--    <div class="product-name">Sản phẩm 5</div>--%>
<%--    <div class="product-price">$300</div>--%>
<%--    <button class="cart-button">--%>
<%--      <span class="cart-icon">&#128722;</span> <!-- Unicode for shopping cart icon -->--%>
<%--      Thêm vào giỏ hàng--%>
<%--    </button>--%>
<%--  </div>--%>
<%--  <div class="product">--%>
<%--    <img src="https://haycafe.vn/wp-content/uploads/2022/03/anh-sach.jpg" alt="Sản phẩm 6">--%>
<%--    <div class="product-name">Sản phẩm 6</div>--%>
<%--    <div class="product-price">$550</div>--%>
<%--    <button class="cart-button">--%>
<%--      <span class="cart-icon">&#128722;</span> <!-- Unicode for shopping cart icon -->--%>
<%--      Thêm vào giỏ hàng--%>
<%--    </button>--%>
<%--  </div>--%>

</div>
</body>
</html>
