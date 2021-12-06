<%@ page import="dao.UserDao" %>
<%@ page import="enity.User" %><%--
  Created by IntelliJ IDEA.
  User: DELL
  Date: 2021/9/23
  Time: 17:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>do_login</title>
</head>
<body>
<%
    //0.设置字符集编码()
    request.setCharacterEncoding("utf-8");
    response.setCharacterEncoding("utf-8");
    //1.解析Request对象，获取username,upwd
    String username = request.getParameter("username");
    String upwd = request.getParameter("upwd");
    //2.查询用户是否存在:调用UsersDao中的findUser()方法
    User user = new UserDao().findUser(username,upwd);
    //3.判定返回值，跳转页面
    if(user!=null){//查询到用户
        //将用户user存入session
        session.setAttribute("loginUser",user);//设置session属性
        //跳转到欢迎页面
        response.sendRedirect("do_news_list.jsp");//新闻页面
    }else{
        response.sendRedirect("../index.jsp");//跳转(重定向)到登录页面
    }

%>
</body>
</html>
