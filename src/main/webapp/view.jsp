<%@ page import="java.util.List" %>
<%@ page import="com.javaweb.jetty.product.domain.Product" %>
<html>
<body>
<table border="1">
    <tr><td>Name</td><td>Model</td><td>Factory</td><td></td><td></td></tr>
<%
    List<Product> products= (List<Product>) application.getAttribute("products");
    if(products != null){
        for (Product product:products){
        %>
    <tr>
        <td><%=product.getName()%></td>
        <td><%=product.getModel()%></td>
        <td><%=product.getFactory()%></td>
        <td><a href="/editProduct?id=<%=product.getId()%>">Edit</a> </td>
        <td><a href="/deleteProduct?id=<%=product.getId()%>">Delete</a> </td>
    </tr>
    <%
        }
    }
%>
</table>
</body>
</html>
