<%@ page language="java" contentType="text/html; charset=utf-8" import="java.util.*,DBUtils.DBExecutor.*,Entity.*"
    pageEncoding="utf-8" %>
    <html lang="zh">

    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>机房课表管理系统</title>
        <script src="https://cdn.bootcdn.net/ajax/libs/jquery/3.6.0/jquery.js"></script>
        <link rel="stylesheet" href="css/pagestyle2.css">
    </head>

    <body>
        <div class="box">
            <div class=id="pane">
                <h1 class="minititle">个人信息修改</h1>
            </div>
            <div class="pane">
            <% 
                teacherEntity t = new teacherEntity();
                classesEntity c = new classesEntity();
                if (request.getAttribute("class") == null) {
                    t = (teacherEntity) request.getAttribute("teacher");
                }else{
                    c = (classesEntity) request.getAttribute("class");
                }
            %>
                <form class="form" action="account" method="post" id="teacherform">
                    <input type="hidden" name="userid" value="<jsp:scriptlet>
                            out.print(request.getAttribute("userid"));</jsp:scriptlet>">
                    <div class="inputbox" style="width: 400px;">
                        <h3 style="width: 80px;margin-bottom: 18px;">姓名</h3>
                        <input type="text" name="username" placeholder="请输入姓名" value="<%
                            out.print(t.getTname());
                        %>"/>
                    </div>
                    <div class="inputbox" style="width: 400px;">
                        <h3 style="width: 80px;margin-bottom: 18px;">密码</h3>
                        <input type="password" name="password" placeholder="请输入密码" value="<%
                            out.print(t.getPassword());
                        %>"/>
                    </div>
                    <div class="inputbox" style="width: 260px;float:right">
                        <input type="submit" value="确认">
                        &nbsp&nbsp&nbsp&nbsp
                        <input type="reset" style="float:right" value="还原">
                    </div>
                </form>
                <form class="form" action="account" method="post" id="classform" display="none">
                    <input type="hidden" name="userid" value="<jsp:scriptlet>
                            out.print(request.getAttribute("userid"));</jsp:scriptlet>">
                    <div class="inputbox" style="width: 400px;">
                        <h3 style="width: 140px;margin-bottom: 18px;">班级名称</h3>
                        <input type="text" name="classname" placeholder="请输入班级" value="<%
                            out.print(c.getClassname());
                        %>"/>
                    </div>
                    <div class="inputbox" style="width: 400px">
                        <h3 style="margin-top: -6px;margin-bottom: -5px;;float: left;">年&nbsp&nbsp&nbsp&nbsp级&nbsp
                            <input type="radio" name="grade" value="1" <% out.print((c.getClassgrade()==1?"checked":"")); %>>大一
                            <input type="radio" name="grade" value="2" <% out.print((c.getClassgrade()==2?"checked":"")); %>>大二
                            <input type="radio" name="grade" value="3" <% out.print((c.getClassgrade()==3?"checked":"")); %>>大三
                            <input type="radio" name="grade" value="4" <% out.print((c.getClassgrade()==4?"checked":"")); %>>大四
                        </h3>
                    </div>
                    <div class="inputbox" style="width: 400px;">
                        <h3 style="width: 140px;margin-bottom: 18px;">系&nbsp&nbsp&nbsp&nbsp别&nbsp</h3>
                        <input type="text" name="classdept" placeholder="请输入系别" value="<%
                            out.print(c.getClassdept());
                        %>"/>
                    </div>
                    <div class="inputbox" style="width: 400px;">
                        <h3 style="width: 140px;margin-bottom: 18px;">专&nbsp&nbsp&nbsp&nbsp业&nbsp</h3>
                        <input type="text" name="classprofession" placeholder="请输入专业" value="<%
                            out.print(c.getClassprofession());
                        %>"/>
                    </div>
                    <div class="inputbox" style="width: 400px;">
                        <h3 style="width: 140px;margin-bottom: 18px;">班级人数</h3>
                        <input type="text" name="classton" placeholder="请输入班级人数" value="<%
                            out.print(c.getClasston());
                        %>"/>
                    </div>
                    <div class="inputbox" style="width: 400px;">
                        <h3 style="width: 80px;margin-bottom: 18px;">密&nbsp&nbsp&nbsp&nbsp码&nbsp</h3>&nbsp&nbsp&nbsp&nbsp&nbsp
                        <input type="password" name="password" placeholder="请输入密码" value="<%
                            out.print(c.getPassword());
                        %>"/>
                    </div>
                    <div class="inputbox" style="width: 260px;float:right">
                        <input type="submit" value="确认">
                        &nbsp&nbsp&nbsp&nbsp
                        <input type="reset" style="float:right" value="还原">
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
        </script>

    </body>

    </html>