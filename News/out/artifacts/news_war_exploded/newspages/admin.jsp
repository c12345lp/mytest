<%@ page import="java.util.List" %>
<%@ page import="enity.User" %>
<%@ page import="enity.News" %><%--
  Created by IntelliJ IDEA.
  User: DELL
  Date: 2021/9/25
  Time: 17:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    String username = ((User)session.getAttribute("loginUser")).getUsername();
    List<News> list = (List<News>) session.getAttribute("allNews");

%>
欢迎<%=username%>登录
<%
    for (News tempNews:list) {
        out.write(tempNews.toString()+"<br>");
    }
%>
</body>
</html>
