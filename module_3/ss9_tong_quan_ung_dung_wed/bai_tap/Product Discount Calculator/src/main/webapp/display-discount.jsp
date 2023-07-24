<%--
  Created by IntelliJ IDEA.
  User: ACER
  Date: 7/24/2023
  Time: 4:01 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!-- display-discount.jsp -->
<!DOCTYPE html>
<html>
<head>
  <title>Discount Result</title>
</head>
<body>
<h1>Discount Result</h1>
<p><strong>Product Description:</strong> <%= request.getAttribute("productDescription") %></p>
<p><strong>List Price:</strong> <%= request.getAttribute("listPrice") %></p>
<p><strong>Discount Percent:</strong> <%= request.getAttribute("discountPercent") %></p>
<p><strong>Discount Amount:</strong> <%= request.getAttribute("discountAmount") %></p>
<p><strong>Discount Price:</strong> <%= request.getAttribute("discountPrice") %></p>
</body>
</html>

