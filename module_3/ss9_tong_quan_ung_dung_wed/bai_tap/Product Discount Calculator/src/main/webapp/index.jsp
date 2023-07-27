<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<form action="/DiscountServlet" method="post">
    <h5>Product Description : <input name="product"></h5>
    <h5>List Price :<input name="price"></h5>
    <h5>Discount Percent : <input name="discount"></h5>
    <input type="submit">Next</input>
</form>
</body>
</html>