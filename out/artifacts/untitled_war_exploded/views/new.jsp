<%--
  Created by IntelliJ IDEA.
  User: cytzr
  Date: 2016/1/16
  Time: 21:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <%
        boolean b = (Boolean) request.getAttribute("X");
        if(!b) {
            out.print("failure");
        } else {
            out.print("success");
        }
    %>
</body>
</html>
