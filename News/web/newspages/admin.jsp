<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" import="java.util.*,java.sql.*,enity.*" pageEncoding="utf-8"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@ page import="tools.Page" %>
<%@ page import="javax.xml.crypto.dsig.keyinfo.PGPData" %>
<%
    Page pages = (Page) request.getAttribute("pages");
    if (pages == null){
        response.sendRedirect("PageControlServlet?pageIndex=1");
    }else {
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
    <meta http-equiv="pragma" content="no-cache">
    <meta http-equiv="cache-control" content="no-cache">
    <meta http-equiv="expires" content="0">
    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
    <meta http-equiv="description" content="This is my page">
    <title>添加主题--管理后台</title>
    <link href="./css/admin.css" rel="stylesheet" type="text/css" />
</head>
<body>
<div id="header">
    <div id="welcome">欢迎使用新闻管理系统！</div>
    <div id="nav">
        <div id="logo"><img src="./images/logo.jpg" alt="新闻中国" /></div>
        <div id="a_b01"><img src="./images/a_b01.gif" alt="" /></div>
    </div>
</div>
<div id="admin_bar">
    <div id="status">管理员：
        <%--      <%
                  String username = ((User) session.getAttribute("loginUser")).getUsername();
              %>
              <%=username%>--%>
        <%--      ${loginUser.username}--%>
        <c:out value="${loginUser.username}" default="匿名" escapeXml="false"></c:out>
        登录  &#160;&#160;&#160;&#160; <a href="/LoginOutServlet">login out</a></div>
    <div id="channel"> </div>
</div>
<div id="main">
    <%@include file="console_element/left.html" %>
    <div id="opt_area">
        <script language="javascript">
            function clickdel(){
                return confirm("删除请点击确认");
            }
        </script>
        <table border="1">
            <%
                int totalPages = pages.getTotalPageCount();
                int pageIndex = pages.getCurrPageNo();
                List<News> newList = pages.getNewsList();
                for (News news:newList){
            %>
            <tr>
                <td><%=news.getNTitle()%></td>
                <td><%=news.getNContent()%></td>
                <td><%=news.getNCreatDate()%></td>
            </tr>
            <%
                }
            %>
        </table>
        当前页码：[<%=pageIndex%>/<%=totalPages%>]

        <%
            if (pageIndex > 1){
        %>
        <a href="<%=request.getContextPath()%>/PageControlServlet?pageIndex=1">首页</a>
        <a href="<%=request.getContextPath()%>/PageControlServlet?pageIndex=<%=pageIndex-1%>">上一页</a>
        <%
            }
        %>

        <%
            if (pageIndex < totalPages){
        %>
        <a href="<%=request.getContextPath()%>/PageControlServlet?pageIndex=<%=pageIndex+1%>">下一页</a>
        <a href="<%=request.getContextPath()%>/PageControlServlet?pageIndex=<%=totalPages%>">尾页</a>
        <%
            }
        %>



    </div>
</div>
<div id="footer">
    <%@include file="console_element/bottom.html" %>
</div>
</body>
</html>
<%
    }
%>