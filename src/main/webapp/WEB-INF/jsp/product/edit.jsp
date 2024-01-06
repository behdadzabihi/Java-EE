<%@ page import="com.javaweb.jetty.product.domain.Product" %>
Created by IntelliJ IDEA.
  User: Administrator
  Date: 10/31/2019
  Time: 6:07 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit Product</title>
</head>
<body>
<%
    Product product = (Product) request.getAttribute("product");
%>
<form method="post" action="/editProduct">
    <table>
        <tr><td>Name</td><td><input type="text" name="name" value="<%=product.getName()%>"/></td></tr>
        <tr><td>Model</td><td><input type="text" name="model" value="<%=product.getModel()%>"/></td></tr>
        <tr><td>Factory</td><td><input type="text" name="factory" value="<%=product.getFactory()%>"/><input type="hidden" name="id" value="<%=product.getId()%>"/></td></tr>
        <tr><td></td><td><input type="submit" name="Submit" value="Update"/><input type="submit" name="Cancel" value="Cancel"/></td></tr>
    </table>
</form>
</body>
</html>
