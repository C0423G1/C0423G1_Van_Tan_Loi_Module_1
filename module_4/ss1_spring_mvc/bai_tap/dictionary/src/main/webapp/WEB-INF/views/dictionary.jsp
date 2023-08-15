<%--
  Created by IntelliJ IDEA.
  User: ACER
  Date: 8/14/2023
  Time: 11:16 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Dictionary</title>
</head>
<body>
<h1>Từ Điển</h1>
<form action="/dictionary/lookup" method="post">
    <label for="word">Mời Bạn Nhập</label>
    <input type="text" name="word" id="word" required>
    <input type="submit" value="Nhập">
</form>

<c:if test="${found}">
    <p>${meaning}</p>
</c:if>

<c:if test="${not found}">
    <p>Từ Không có trong từ điển</p>
</c:if>
</body>
</html>

