<%@ page import="java.util.List" %>
<%@ page import="enity.User" %>
<%@ page import="enity.News" %>
<%@ page import="dao.NewsDao" %><%--
  Created by IntelliJ IDEA.
  User: DELL
  Date: 2021/9/24
  Time: 22:58
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
   System.out.println("接收到的user="+user.getUsername());
   out.write("欢迎"+user.getUsername()+"登录！"+"<br>");

    List<News> list = new NewsDao().findNews();

    for (News tmp:list){
        out.write(tmp.toString());
    }
    //跳转至newspages/admin.jsp
    session.setAttribute("allNews",list);
    response.sendRedirect("../newspages/admin.jsp");
%>
</body>
</html>
