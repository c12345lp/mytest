<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>新闻中国</title>
    <link href="css/main.css" rel="stylesheet" type="text/css" />
    <script src="${pageContext.request.contextPath}/js/jquery-3.6.0.min.js" type="text/javascript"></script>
    <script language="javascript">
        function check(){
            var id_username = document.getElementById("id_username").value;
            var id_upwd = document.getElementById("id_upwd").value;
            if(id_username == null || id_username==""){
                alert("账号为空，请返回注册");
                document.getElementById("usernameError").innerHTML="账号不能为空";
                return false;
            }
            if(id_upwd == null || id_upwd==""){
                alert("密码为空，请返回注册");
                document.getElementById("upwdError").innerHTML="密码不能为空";
                return false;
            }

            alert("通过空值验证");
            return true;
        }
        function jqueryCheck(){
            const username = $("#id_username").val();
            const upwd = $("#id_upwd").val();


            if(username=="" || username==null){
                // $("#usernameError").css("color", "red");
                $("#usernameError").html("账号不能为空");
                $("#id_username").focus();
                return false;
            }
            if (upwd=="" || upwd==null){
                $("#upwdError").html("密码不能为空");
                $("#id_upwd").focus()
                return false;
            }
                alert("校验成功")
                return true;
        }
        function focusOnLogin(){
            // var login_username = document.getElementById("username");
            // var login_username = $("username");
            // login_username.focus();
            $("#id_username").focus();
        }

        var xhr;
        function createXHR(){
            try{
                return new XMLHttpRequest();
            }catch (e) {
                return new ActiveXObject("Microsoft.XMLHTTP");
            }
        }

        function cherkRegName(regName) {
            // xhr = createXHR();
            // xhr.onreadystatechange = callback;
            // xhr.open("get","CheckRegServlet?regName="+regName,true);
            // xhr.send(null)

            // ajax的jquery写法$.get()
            // $.get(
            //     "CheckRegServlet",//servlet的url地址
            //     {regName},//传入servlet的参数
            //     function (data) {//callback回调函数，data是servlet的返回值
            //         if (data == 0) {
            //             $("#regNames").html("用户名可以注册jquery的get方法").css("color", "green");
            //             $("#regBtn").disabled("false");
            //         } else {
            //             $("#regNames").html("用户名可以注册jquery的get方法").css("color", "red");
            //             $("#regBtn").disabled("true");
            //         }
            //     }
            // );

            //ajax的jquery写法$.ajax();
            $.ajax({
                    url: "CheckRegServlet",//servlet的url地址
                    type: "get",//数据传输方式
                    data: {regName},//传入servlet的参数
                    dataType: "text",
                    success: function (data) {//servlet成功返回值data
                        if (data == 0) {
                            $("#regNames").html("用户名可以注册jquery的$.ajax方法").css("color", "green");
                            $("#regBtn").attr("disabled",false);
                        } else {
                            $("#regNames").html("用户名可以注册jquery的$.ajax方法").css("color", "red");
                            $("#regBtn").attr("disabled",true);
                        }
                    }
                }
            );

        }



        // function callback() {
        //     if (xhr.readyState == 4 && xhr.status == 200) {//是否servlet执行成功
        //         var res = xhr.responseText;//获取open方法中的servlet的返回值
        //         if (res == 0) {
        //             document.getElementById("regNames").innerHTML
        //                 = "<font style='color: green'>用户名可以注册</font>";
        //             document.getElementById("regBtn").disabled = false;
        //             document.getElementById("regBtn").style.visibility="hidden";
        //         } else {
        //             document.getElementById("regNames").innerHTML
        //                 = "<font style='color: red'>用户名已经存在</font>";
        //             document.getElementById("regBtn").disabled = true;
        //             document.getElementById("regBtn").style.visibility="hidden";
        //         }
        //     }
        //     }


            // function callback() {
            //     if (xhr.readyState == 4 && xhr.status == 200) {
            //         var res = xhr.responseText;
            //         if (res == 0) {
            //             $("#regNames").html("用户名可以注册").css("color", "green");
            //             $("#regBtn").disabled("false");
            //         } else {
            //             $("#regNames").html("用户名已存在").css("color", "red");
            //             $("#regBtn").disabled("true");
            //         }
            //     }
            // }
    </script>
</head>
<body onload="focusOnLogin()">
<div id="header">
    <div id="top_login" style="height:25px;">

        <%--<form action="logonServlet" method="post">
            <input login_input/>
            <label id="error"> </label>
            <img src="images/friend_logo.gif" alt="Google" id="friend_logo" />
        </form>--%>
    </div>
    <div id="nav">
        <div id="logo"> <img src="images/logo.jpg" alt="新闻中国" /> </div>
        <div id="a_b01"> <img src="images/a_b01.gif" alt="" /> </div>
        <!--mainnav end-->
    </div>
</div>
<div id="container">
    <div class="main">
        <div class="class_type"> <img src="images/class_type.gif" alt="新闻中心" /> </div>
        <div class="content">
<%--            RegServlet--%>
            <form action="RegisterServlet" method="post" onsubmit="return jqueryCheck()">
                <label> 用户名 </label>
                <input onblur="cherkRegName(this.value)" id="id_username" name="username" placeholder="请输入账号" class="login_input" />
                <span id="regNames"></span>
                <label id="usernameError" style="color: red;"> </label>
                <br><br><label> 密&#160;&#160;&#160;码 </label>
                <input type="password" id="id_upwd" name="upwd" placeholder="请输入密码" class="login_input" />
                <label id="upwdError" style="color: red"> </label>
                <br><br><input type="submit" class="login_sub" value="注册" id="regBtn" />
                <input type="button" class="login_sub" value="返回" onclick="javascrtpt:window.location.href='index.jsp'" />
            </form>
        </div>
<%--        <%@include file="index-elements/index_rightbar.html"%>--%>
    </div>
</div>
<%@include file="index-elements/index_bottom.html"%>
</body>
</html>
