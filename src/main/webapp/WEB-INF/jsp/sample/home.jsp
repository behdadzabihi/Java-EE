<%--
  Created by IntelliJ IDEA.
  User: drp
  Date: 01.01.24
  Time: 12:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Home</title>
</head>
<body>
<%
    Integer counter= (Integer) application.getAttribute("counter");
    if(counter == null){
        counter=0;
    }
    counter++;
    application.setAttribute("counter",counter);
%>
this application has seen <%=counter%> times!
<h2>Welcome ...!</h2>
</body>
</html>
