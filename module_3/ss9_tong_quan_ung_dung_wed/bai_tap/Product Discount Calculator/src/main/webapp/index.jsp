<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
  <title>Product Discount Calculator</title>
</head>
<body>
<h1>Product Discount Calculator</h1>
<form action="/display-discount" method="post">
  <label for="productDescription">Product Description:</label>
  <input type="text" id="productDescription" name="productDescription" required><br>

  <label for="listPrice">List Price:</label>
  <input type="number" id="listPrice" name="listPrice" required><br>

  <label for="discountPercent">Discount Percent:</label>
  <input type="number" id="discountPercent" name="discountPercent" required><br>

  <input type="submit" value="Calculate Discount">
</form>
</body>
</html></html>