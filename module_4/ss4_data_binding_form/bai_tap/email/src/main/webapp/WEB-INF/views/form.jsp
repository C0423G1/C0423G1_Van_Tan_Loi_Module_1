<%--
  Created by IntelliJ IDEA.
  User: ACER
  Date: 8/14/2023
  Time: 3:21 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Email Configuration</title>
</head>
<body>
<h1>Email Configuration</h1>
<form action="/config/post" method="post">
    <div>
        <h3>Language:</h3>
        <select name="language">
            <option value="English">English</option>
            <option value="Vietnamese">Vietnamese</option>
            <option value="Japanese">Japanese</option>
            <option value="Chinese">Chinese</option>
        </select>
    </div>
    <div>
        <h3>Page Size:</h3>
        <select name="pagesize">
            <option value="5">5</option>
            <option value="10">10</option>
            <option value="15">15</option>
            <option value="25">25</option>
            <option value="50">50</option>
            <option value="100">100</option>
        </select>
        <p>emails per page</p>
    </div>
    <div>
        <h3> Spams filter :</h3>
        <input name="spamsfilter" type="checkbox" value="Enable spams filter">Enable spams filter</br>
    </div>
    <div>
        <h3>Signature :</h3>
        <textarea name="signature"></textarea>
    </div>
    <button type="submit">Save Configuration</button>
</form>
<h2>Language : ${config.language}</h2>
<h2> Page Size : ${config.pageSize} </h2>
<h2>Spams filter : ${config.spamsfilter}</h2>
<h2>Signature : ${config.signature}</h2>
</body>
</html>

