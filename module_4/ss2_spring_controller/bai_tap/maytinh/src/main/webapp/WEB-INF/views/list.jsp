<%--
  Created by IntelliJ IDEA.
  User: ACER
  Date: 8/14/2023
  Time: 2:04 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Simple Calculator</title>
</head>
<body>
<h1>Simple Calculator</h1>
<form action="/caculator/calculate" method="post">
    <input type="number" name="num1" placeholder="Number 1" required>
    <select name="operator">
        <option value="add">+</option>
        <option value="subtract">-</option>
        <option value="multiply">*</option>
        <option value="divide">/</option>
    </select>
    <input type="number" name="num2" placeholder="Number 2" required>
    <button type="submit">Calculate</button>
</form>
<h2>Kết quả : ${result}</h2>
</body>
</html>

