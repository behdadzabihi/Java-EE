<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 10/31/2019
  Time: 1:48 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Register</title>
</head>
<%
    String color = "White";
    Cookie[] cookies = request.getCookies();
    if(cookies!=null) {
        for (Cookie cookie : cookies) {
            if (cookie.getName().equals("color")) {
                color = cookie.getValue();
                break;
            }
        }
    }
%>
<body bgcolor="<%=color%>">

</body>
</html>

