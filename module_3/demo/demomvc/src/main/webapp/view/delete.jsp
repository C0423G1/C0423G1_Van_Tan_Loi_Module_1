<%--
  Created by IntelliJ IDEA.
  User: ACER
  Date: 7/27/2023
  Time: 11:48 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>

</head>
<body>
<form action="/ProductController?action=Delete&id=${editproduct.id}" method="post">
    <h2>${editproduct.id}</h2>
    <h2>Tên Sản Phẩm  <div name="name" >${editproduct.name}</div></h2>
    <h2>Giá Sản Phẩm <div name="gia" >${editproduct.gia}</div></h2>
    <h2>Mô Tả <div name="mota"  >${editproduct.moTa}</div></h2>
    <h2>Nhà Sản Xuất <div name="nhasanxuat"  >${editproduct.nhaSanXuat}</div></h2>
    <button type="submit" class="btn btn-outline-secondary">Trở Lại</button>
    <button type="submit" class="btn btn-outline-success">Hoàn Thành Xoá</button>
</form>
</body>
</html>
