<%@ page import="enity.User" %>
<%@ page import="dao.UserDao" %><%--
  Created by IntelliJ IDEA.
  User: 刘静y1
  Date: 2021/9/23
  Time: 10:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>do_login</title>
</head>
<body>
<%
    request.setCharacterEncoding("utf-8");
    response.setCharacterEncoding("utf-8");

    String username = request.getParameter("username");
    String upwd = request.getParameter("upwd");

    User user = new UserDao().findUser(username,upwd);
    if (user!=null){
//        out.write("欢迎"+user.getUsername()+"登录");
        session.setAttribute("loginUser",user);
        response.sendRedirect("do_news_list.jsp");
    }else {
        out.write("登录失败");
        response.sendRedirect("../index.jsp");
    }
%>
</body>
</html>
