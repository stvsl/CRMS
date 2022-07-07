<%@ page language="java" import="java.util.*, DBUtils.DBExecutor.*" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8" %>
    <html lang="zh">

    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>机房课表管理系统</title>
        <script src="https://cdn.bootcdn.net/ajax/libs/jquery/3.6.0/jquery.js"></script>
        <link rel="stylesheet" href="css/loginstyle.css">
    </head>

    <body>
        <div class="box">
            <h1 class="title">机房课表管理系统</h1>
        </div>
        <div class="rightbox">
            <div class="login" id="loginpane">
                <!-- 登录 -->
                <form action="login" method="post" class="form" id="loginbox">
                    <h2><a href="#">登录</a>/<a href="#" id="register">注册</a></h2>
                    <div class="inputbox">
                        <input type="text" name="username" placeholder="用户名">
                    </div>
                    <div class="inputbox">
                        <input type="password" name="password" placeholder="密码">
                    </div>
                    <div class="inputbox" style="float:left">
                        <input type="submit" value="登录">&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp
                        <input type="reset" style="float:right" value="重置">
                    </div>
                </form>
                <!-- 注册 -->
                <form action="register" method="post" class="form" id="registerbox" style="display:none">
                    <h2><a href="#">注册</a>/<a href="#" id="login">登录</a></h2>
                    <div class="inputbox">
                        <input type="text" name="userid" placeholder="用户名">
                    </div>
                    <div class="inputbox">
                        <input type="password" name="passwd" placeholder="密码">
                    </div>
                    <h3>
                        <input type="radio" class="radio" name="type" value="class" checked> 我是班级</input>
                        <input type="radio" class="radio" name="type" value="teacher"> 我是教师 </input>
                    </h3>
                    <div class="inputbox" style="float:left">
                        <input type="submit" value="注册">&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp
                        <input type="reset" style="float:right" value="重置">
                    </div>
                </form>
                <script>
                    // 点击切换界面
                    $("#login").click(function () {
                        console.log("登录");
                        document.getElementById("loginbox").style.display = "block";
                        document.getElementById("registerbox").style.display = "none";
                        $("#loginpane").animate({
                            height: "30%"
                        }, 1000);
                    });
                    $("#register").click(function () {
                        console.log("注册");
                        document.getElementById("loginbox").style.display = "none";
                        document.getElementById("registerbox").style.display = "block";
                        $("#loginpane").animate({
                            height: "33%"
                        }, 1000);
                    });
                    // 检查用户名和密码是否为空
                    $("#loginbox").submit(function () {
                        var username = $("input[name='username']").val();
                        var password = $("input[name='password']").val();
                        if (username == "" || password == "") {
                            alert("用户名或密码不能为空");
                            return false;
                        }
                    });
                    $("#registerbox").submit(function () {
                        var username = $("input[name='userid']").val();
                        var password = $("input[name='passwd']").val();
                        if (username == "" || password == "") {
                            alert("注册的用户名或密码不能为空");
                            return false;
                        }
                    });
                    // 密码长度不能小于6位
                    $("input[name='password']").blur(function () {
                        var password = $("input[name='password']").val();
                        // 检查当前是否是登录
                        if (document.getElementById("loginbox").style.display == "block") {
                            if (password.length < 6) {
                                alert("密码长度不能小于6位");
                                return false;
                            }
                        }
                    });
                    <jsp:scriptlet>
                        if(request.getAttribute("msg")!=null){
                            out.println("alert('" + request.getAttribute("msg") + "')");
                        }
                    </jsp:scriptlet>
                </script>
            </div>
        </div>
    </body>

    </html>