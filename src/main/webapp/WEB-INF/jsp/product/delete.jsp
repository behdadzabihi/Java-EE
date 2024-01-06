<%@ page import="com.javaweb.jetty.product.domain.Product" %>
Created by IntelliJ IDEA.
  User: Administrator
  Date: 10/31/2019
  Time: 6:34 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Delete Confirm</title>
</head>
<body>
<%
    Product product = (Product) request.getAttribute("product");
%>
Are you sure to delete this record?
<form method="post" action="/deleteProduct">
    <table>
        <tr><td>Name</td><td><%=product.getName()%></td></tr>
        <tr><td>Model</td><td><%=product.getModel()%></td></tr>
        <tr><td>Factory</td><td><%=product.getFactory()%><input type="hidden" name="id" value="<%=product.getId()%>"/></td></tr>
        <tr><td></td><td><input type="submit" name="Submit" value="Yes"/><input type="submit" name="Cancel" value="No"/></td></tr>
    </table>
</form>
</body>
</html>
