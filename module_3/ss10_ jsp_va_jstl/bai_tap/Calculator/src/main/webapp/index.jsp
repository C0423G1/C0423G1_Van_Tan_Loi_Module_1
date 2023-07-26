<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
  <title>JSP - Hello World</title>
</head>
<body>
<form action="/CalculateServlet" method="get">
  <h2>Simple Calcutor</h2>
  <div style="border: black">
    <h5>Calculator</h5>
    <p>First operand : <input name="firstoperand"></p>
    <p>Operator :
      <select name="operator">
        <option>Addition</option>
        <option>subtraction</option>
        <option>multiplication</option>
        <option>division</option>
      </select></p>
    <p>Second operand : <input name="secondoperand"></p>
    <button type="submit">Calculate</button>
  </div>
</form>
</body>
</html>