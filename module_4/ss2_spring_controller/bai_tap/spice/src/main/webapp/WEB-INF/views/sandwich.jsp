<%--
  Created by IntelliJ IDEA.
  User: ACER
  Date: 8/14/2023
  Time: 1:37 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <title>Sandwich Condiments</title>
</head>
<body>
<h1>Sandwich Condiments</h1>

<form action="/sandwich/order" method="post">
  <h3>Select condiments:</h3>
  <c:forEach items="${condiments}" var="condiment">
    <input type="checkbox" name="selectedCondiments" value="${condiment}">${condiment}<br>
  </c:forEach>
  <br>
  <input type="submit" value="Order">
</form>
<c:if test="${not empty selectedCondiments}">
  <h3>Selected condiments:</h3>
  <c:forEach items="${selectedCondiments}" var="selectedCondiment">
    <p>${selectedCondiment}</p>
  </c:forEach>
</c:if>
</body>
</html>

