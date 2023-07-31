<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.l
  User: ACER
  Date: 7/27/2023
  Time: 10:03 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Bootstrap demo</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9" crossorigin="anonymous">
</head>
<body>
<table class="table">
    <thead>
    <tr>
        <th scope="col">ID</th>
        <th scope="col">Tên Sản Phẩm</th>
        <th scope="col">Giá Sản Phẩm</th>
        <th scope="col">Mô Tả Sản Phẩm</th>
        <th scope="col">Nhà Sản Xuất</th>
        <th scope="col"></th>
        <th scope="col"></th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="sanPham" items="${products}">
        <tr>
            <th scope="row">${sanPham.id}</th>
            <td>${sanPham.name}</td>
            <td>${sanPham.gia}</td>
            <td>${sanPham.moTa}</td>
            <td>${sanPham.nhaSanXuat}</td>
            <td>
                <a href="ProductController?action=Edit&id=${sanPham.id}">
                    <button type="submit" class="btn btn-outline-secondary" >Edit</button>
                </a>
            </td>
            <td>
                <a href="ProductController?action=Delete&id=${sanPham.id}">
                <button type="button" class="btn btn-outline-success" >Delete</button>
                </a>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
<a href="ProductController?action=Create">
    <button type="button" class="btn btn-outline-success" >Create</button>
</a>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-HwwvtgBNo3bZJJLYd8oVXjrBZt8cqVSpeBNS5n7C8IVInixGAoxmnlMuBnhbgrkm"
        crossorigin="anonymous"></script>
</body>
</html>
