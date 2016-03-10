<%--
  Created by IntelliJ IDEA.
  User: cytzr
  Date: 2016/1/16
  Time: 17:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
    <%--  <form action="<%=request.getContextPath()%>/a.do" method="post">
        <input type="text" name="text" />
        <input type="submit" />
      </form>--%>
    <form action="<%=request.getContextPath()%>/userAdd.do" method="post">
        name: <input type="text" name="name" />
        <br/>
        pass: <input type="text" name="pass" />
        <br/>
        pass: <input type="submit" />
    </form>
  </body>
</html>
