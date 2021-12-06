<%@ page import="enity.User" %>
<%@ page import="java.util.List" %>
<%@ page import="dao.NewsDao" %>
<%@ page import="enity.News" %><%--
  Created by IntelliJ IDEA.
  User: 刘静y1
  Date: 2021/9/24
  Time: 14:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    User user = (User) session.getAttribute("loginUser");
    System.out.println("username="+user.getUsername());
    out.write("欢迎"+user.getUsername()+"登录"+"<br>");
%>
<%
    List<News> list = new NewsDao().findNews();
    for(News tmp:list){
        out.write(tmp.toString());
    }
    session.setAttribute("allNews",list);
    response.sendRedirect("../newspages/admin.jsp");
%>
</body>
</html>
