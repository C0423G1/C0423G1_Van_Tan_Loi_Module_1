<%--
  Created by IntelliJ IDEA.
  User: ACER
  Date: 8/1/2023
  Time: 10:08 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title> User</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
<body>
<form action="/UserController?action=Create" method="post">
    <table class="table">
        <thead>
        <tr>
            <th scope="col">#</th>
            <th scope="col">Name</th>
            <th scope="col">Email</th>
            <th scope="col">Contry</th>
        </tr>
        </thead>
        <tbody>
        <tr>
            <th><input name="id" value="${user.id}"></th>
            <td><input name="name" value="${user.name}"></td>
            <td><input name="email" value="${user.email}"></td>
            <td><input name="country" value="${user.country}"></td>
            <td><button type="submit"> Save </button></td>
        </tr>
        </tbody>
    </table>
</form>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4"
        crossorigin="anonymous"></script>
</head>
</body>
</html>
