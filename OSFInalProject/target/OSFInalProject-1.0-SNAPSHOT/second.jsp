<%--
  Created by IntelliJ IDEA.
  User: Илон Маск
  Date: 13.03.2021
  Time: 9:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    int res = (int) request.getAttribute("res");
%>
<h1>Result:<%=res%> </h1>
</body>
</html>
