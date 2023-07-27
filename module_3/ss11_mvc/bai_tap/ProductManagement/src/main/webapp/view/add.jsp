<%--
  Created by IntelliJ IDEA.
  User: ACER
  Date: 7/27/2023
  Time: 10:53 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
</head>
<body>
<form action="ProductServlet?action=Hoàn Thành Thêm Mới" method="post">
    <h2>ID :<input name="id"></h2>
    <h2>Tên Sản Phẩm Mới <input name="name"></h2>
    <h2>Giá Sản Phẩm Mới <input name="gia"></h2>
    <h2>Mô Tả <input name="mota"></h2>
    <h2>Nhà Sản Xuất <input name="nhasanxuat"></h2>
    <button type="submit" class="btn btn-outline-secondary" name="action">Trở Lại</button>
    <button type="submit" class="btn btn-outline-success" name="action">Hoàn Thành Thêm Mới</button>
</form>

</body>
</html>
