<%@ page language="java" contentType="text/html; charset=utf-8" import="java.util.*,DBUtils.DBExecutor.*"
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
            <div class="middlebox" id="pane">
                <h1 class="minititle">请完善您的个人信息</h1>
            </div>
            <div class="pane">
                <form class="form" action="completeaccount" method="post" id="teacherform">
                    <div>
                        <h2 id="nowaccount">您当前的帐号是:<jsp:scriptlet>
                                out.print(request.getAttribute("username"));</jsp:scriptlet>
                        </h2>
                        <h3>请完善您的个人信息</h3>
                    </div>
                    <input type="hidden" name="userid" value="<jsp:scriptlet>
                            out.print(request.getAttribute("username"));</jsp:scriptlet>">
                    <div class="inputbox" style="width: 400px;">
                        <h3 style="width: 80px;margin-bottom: 18px;">姓名</h3>
                        <input type="text" name="username" placeholder="请输入姓名" />
                    </div>
                    <div class="inputbox" style="width: 260px;float:right">
                        <input type="submit" value="确认">
                        &nbsp&nbsp&nbsp&nbsp
                        <input type="reset" style="float:right" value="清除">
                    </div>
                </form>
                <form class="form" action="completeaccount" method="post" id="classform" display="none">
                    <div>
                        <h2>您当前的帐号是:<jsp:scriptlet>
                                out.print(request.getAttribute("username"));</jsp:scriptlet>
                        </h2>
                        <h3>请完善您的班级信息</h3>
                    </div>
                    <input type="hidden" name="userid" value="<jsp:scriptlet>
                            out.print(request.getAttribute("username"));</jsp:scriptlet>">
                    <div class="inputbox" style="width: 400px;">
                        <h3 style="width: 140px;margin-bottom: 18px;">班级名称</h3>
                        <input type="text" name="classname" placeholder="请输入班级" />
                    </div>
                    <div class="inputbox" style="width: 400px">
                        <h3 style="margin-top: -6px;margin-bottom: -5px;;float: left;">年&nbsp&nbsp&nbsp&nbsp级&nbsp
                            <input type="radio" name="grade" value="1" checked>大一
                            <input type="radio" name="grade" value="2">大二
                            <input type="radio" name="grade" value="3">大三
                            <input type="radio" name="grade" value="4">大四
                        </h3>
                    </div>
                    <div class="inputbox" style="width: 400px;">
                        <h3 style="width: 140px;margin-bottom: 18px;">系&nbsp&nbsp&nbsp&nbsp别&nbsp</h3>
                        <input type="text" name="classdept" placeholder="请输入系别" />
                    </div>
                    <div class="inputbox" style="width: 400px;">
                        <h3 style="width: 140px;margin-bottom: 18px;">专&nbsp&nbsp&nbsp&nbsp业&nbsp</h3>
                        <input type="text" name="classprofession" placeholder="请输入专业" />
                    </div>
                    <div class="inputbox" style="width: 400px;">
                        <h3 style="width: 140px;margin-bottom: 18px;">班级人数</h3>
                        <input type="text" name="classton" placeholder="请输入班级人数" />
                    </div>
                    <div class="inputbox" style="width: 260px;float:right">
                        <input type="submit" value="确认">
                        &nbsp&nbsp&nbsp&nbsp
                        <input type="reset" style="float:right" value="清除">
                    </div>
                </form>
            </div>
        </div>
        <script>
            $(document).ready(function () {
                var type = <jsp:scriptlet>out.print(request.getAttribute("type"));</jsp:scriptlet>;
                if (type == 1) {
                    document.getElementById("teacherform").style.display = "block";
                    document.getElementById("classform").style.display = "none";
                    document.getElementById("pane").style.height = "40%";
                } else if (type == 2) {
                    document.getElementById("teacherform").style.display = "none";
                    document.getElementById("classform").style.display = "block";
                    document.getElementById("pane").style.height = "65%";
                }
            });
            <jsp:scriptlet>
                if(request.getAttribute("msg")!=null){
                    out.println("alert('" + request.getAttribute("username") + "')");
                }
            </jsp:scriptlet>
        </script>

    </body>

    </html>