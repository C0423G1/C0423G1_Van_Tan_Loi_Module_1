<%--
  Created by IntelliJ IDEA.
  User: ACER
  Date: 7/27/2023
  Time: 3:10 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
</head>
<body>
<form action="/ProductController?action=Edit&id=${editproduct.id}" method="post">
  <h2>${editproduct.id}</h2>nhà sản xuất
  <h2>Tên Sản Phẩm  <input name="name" value="${editproduct.name}"></h2>
  <h2>Giá Sản Phẩm <input name="gia"  value="${editproduct.price}"></h2>
  <h2>Mô Tả <input name="mota"  value="${editproduct.describe}"></h2>
  <h2>Nhà Sản Xuất <input name="nhasanxuat"  value="${editproduct.producer}"></h2>
  <button type="submit" class="btn btn-outline-secondary" name="action">Trở Lại</button>
  <button type="submit" class="btn btn-outline-success" name="action">Hoàn Thành Sửa</button>
</form>
</body>
</html>
