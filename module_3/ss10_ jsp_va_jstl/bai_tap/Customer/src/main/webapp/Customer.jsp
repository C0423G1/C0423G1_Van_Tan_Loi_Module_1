<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
    <style>
        td {
            width: 200px;
        }

        table, td, tr {
            border: black solid 1px;
        }
    </style>
</head>
<body>
<form action="/customer-servlet" method="get">
    <div style="text-align:center; width: 800px">
        <h4>Danh Sách Khách Hàng</h4>
        <table>
            <tr>
                <td>Tên</td>
                <td>Ngày Sinh</td>
                <td>Địa Chỉ</td>
                <td>Ảnh</td>
            </tr>
            <c:forEach var="name" items="${customerArrayList}">
                <tr>
                    <td>${name.name}</td>
                    <td>${name.ngaySinh}</td>
                    <td>${name.diaChi}</td>
                    <td><img src="${name.anh}" style="width: 100px;height: 100px"></td>
                </tr>
            </c:forEach>
        </table>
    </div>
</form>
</body>
</html>