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
    <title>500</title>
</head>
<body>
    程序发生错误<br>
    <a href="${pageContext.request.contextPath}../index.jsp">返回首页</a>
</body>
</html>
