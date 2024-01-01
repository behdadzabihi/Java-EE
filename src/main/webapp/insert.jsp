<%--
  Created by IntelliJ IDEA.
  User: drp
  Date: 01.01.24
  Time: 17:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Insert Product</title>
</head>
<form action="IPS" method="post">
    <table>
        <tr><td>Name</td><td><input type="text" name="name"/></td></tr>
        <tr><td>Model</td><td><input type="text" name="model"/></td></tr>
        <tr><td>Factory</td><td><input type="text" name="factory"/></td></tr>
        <tr><td></td><td><input type="submit" name="Submit" value="Insert"/><input type="submit" name="Cancel" value="Cancel"/></td></tr>
    </table>
</form>
<body>

</body>
</html>
