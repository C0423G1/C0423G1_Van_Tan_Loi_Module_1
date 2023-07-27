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
<form action="/ProductServlet?action=Hoàn Thành Sửa" method="post">
  <h2 name="id">ID : ${editproduct.id}</h2>
  <h2>Tên Sản Phẩm  <input name="name" value="${editproduct.name}"></h2>
  <h2>Giá Sản Phẩm <input name="gia"  value="${editproduct.gia}"></h2>
  <h2>Mô Tả <input name="mota"  value="${editproduct.moTa}"></h2>
  <h2>Nhà Sản Xuất <input name="nhasanxuat"  value="${editproduct.nhaSanXuat}"></h2>
  <button type="submit" class="btn btn-outline-secondary" name="action">Trở Lại</button>
  <button type="submit" class="btn btn-outline-success" name="action">Hoàn Thành Sửa</button>
</form>

</body>
</html>
