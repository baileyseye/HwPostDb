
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Add Product</title>
</head>
<body>
<h2>Add a new product</h2>
<% if (request.getAttribute("error") != null) { %>
<p style="color: red;"><%= request.getAttribute("error") %></p>
<% } %>
<form method="POST" >
    <label for="productName">Product Name:</label><br>
    <input type="text" id="productName" name="productName"><br>
    <label for="productPrice">Product Price:</label><br>
    <input type="text" id="productPrice" name="productPrice"><br><br>
    <input type="submit" value="Submit">
</form>
</body>
</html>
