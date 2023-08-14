<%--
  Created by IntelliJ IDEA.
  User: ACER
  Date: 8/14/2023
  Time: 10:44 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Currency Converter</title>
</head>
<body>
<h1>Currency Converter</h1>
<form action="/converts/convert" method="post">
    <label for="exchangeRate">Exchange Rate:</label>
    <input type="text" name="exchangeRate" id="exchangeRate" required><br>
    <label for="usdAmount">USD Amount:</label>
    <input type="text" name="usdAmount" id="usdAmount" required><br>
    <input type="submit" value="Convert">
</form>
<c:if test="${not empty vndAmount}">
    <p>VND Amount: ${vndAmount}</p>
</c:if>
</body>
</html>

