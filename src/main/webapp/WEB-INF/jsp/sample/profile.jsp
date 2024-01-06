<%--
  Created by IntelliJ IDEA.
  User: drp
  Date: 01.01.24
  Time: 12:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    if(session.getAttribute("username") ==null){
        response.sendRedirect("/login.jsp");
    }else{
%>
<html>
<head>
    <title>Profile</title>
</head>
<h3>welcome To Your Profile</h3>
<body>
<a href="logout">Logout</a><br>
</body>
</html>
<% } %>