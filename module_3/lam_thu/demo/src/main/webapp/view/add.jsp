<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: ACER
  Date: 8/9/2023
  Time: 6:34 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
    <style>

    </style>
</head>
<body>
<form action="/BookServlet?action=add" method="post">
<div style="width: 50%;margin-left: 25%;margin-right: 25%;margin-top:7%;border: grey solid 1px;border-radius: 20px">
    <h3 style=" font-family: 'Montagu Slab', serif;text-align: center;font-size: 40px;margin-top: 3%">Thêm thông tin </h3>
    <div class="row mb-4">
        <div class="col">
            <div class="form-outline">
                <input name="namebook" style="width: 90%;margin-left: 5%;margin-right: 5%" placeholder="Tên Sách" type="text" id="form6Example1" class="form-control"/>
            </div>
        </div>
    </div>
    <div class="form-outline mb-4">
        <input name="soluong" style="width: 90%;margin-left: 5%;margin-right: 5%" placeholder="Số lượng sách" type="number" id="form6Example6" class="form-control"/>
    </div>
    <div class="form-outline mb-4">
        <input name="tacgia" style="width: 90%;margin-left: 5%;margin-right: 5%" placeholder="Tác giả" type="text" id="form6Example4" class="form-control"/>
    </div>
<%--    <div class="form-outline mb-4">--%>
<%--        <input name="theloai" style="width: 90%;margin-left: 5%;margin-right: 5%" placeholder="Thể loại" type="email" id="form6Example5" class="form-control"/>--%>
<%--    </div>--%>
    <select name="theloai" style="width: 90%;margin-left: 5%;margin-right: 5%" >
        <c:forEach  var="theloai" items="${theloai}">
        <option value="${theloai.idCategory}">${theloai.nameCategory}</option>
        </c:forEach>
    </select>
    <a href="/BookServlet"><button  style="margin-bottom: 2%;margin-right: 60%;margin-left: 7%;width: 100px" type="button" class="btn btn-outline-secondary">Trở về</button></a>
    <button style="margin-bottom: 2%;width: 100px" class="btn btn-outline-primary" type="submit">Thêm mới</button>
</div>
</form>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
