<%--
  Created by IntelliJ IDEA.
  User: 刘静y1
  Date: 2021/10/20
  Time: 8:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isErrorPage="true" %>
<%
    response.setStatus(HttpServletResponse.SC_OK);
%>
<html>
<head>
    <title>404</title>
</head>
<body>
    访问页面不存在<br>
    <a href="javascript:history.go(-1)">点击返回上一页面</a>
</body>
</html>
