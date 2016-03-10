<%--
  Created by IntelliJ IDEA.
  User: cytzr
  Date: 2016/1/17
  Time: 21:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="service.vo.MessageBean" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <%
        MessageBean msg = (MessageBean) request.getAttribute("msg");
    %>
    <table border="2" width="85%">
        <tr>
            <td><%=msg.getName()%></td>
            <td><%=msg.getMessage()%></td>
        </tr>
        <tr>
            <td><%=msg.getNick()%></td>
            <td><%=msg.getDate()%></td>
        </tr>
    </table>
</body>
</html>
