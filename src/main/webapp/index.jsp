<%@ page language="java" import="java.util.*, DBUtils.DBExecutor.*" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8" %>
    <!DOCTYPE html>
    <html lang="zh">

    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>机房课表管理系统</title>
        <link rel="stylesheet" href="css/indexstyle.css">
        <link rel="stylesheet" href="css/font-awesome.css">
        <script src="https://cdn.bootcdn.net/ajax/libs/jquery/3.6.0/jquery.js"></script>
    </head>

    <body>
        <div class="topbox parent">
            <h1 class="title">机房课表管理系统</h1>
            <i class="fa fa-window-minimize" style="color:white" aria-hidden="true" id="minmenu"></i>
            <i class="fa fa-window-maximize" style="color:white;display:none" aria-hidden="true" id="mixmenu"></i>
            <h2 class="account right">欢迎<jsp:scriptlet>
                    out.print(request.getAttribute("username"));
                </jsp:scriptlet> &nbsp&nbsp</h2>
        </div>
        <div>
            <div class="navbar">
                <input type="checkbox" id="checkbox" />
                <!-- 复选框的id属性值和label元素的for属性值必须是相同的,才能够通过点击label选中复选框 -->
                <label for="checkbox">
                </label>
                <ul>
                    <li>
                        <span>管理选项</span>
                    </li>
                    <li id="timetable">
                        <a href="javascript:toArrange()">
                            <i class="fa fa-calendar" aria-hidden="true"></i>
                            <span>当前课表</span>
                        </a>
                    </li>
                    <li>
                        <a href="javascript:toCourse()">
                            <i class="fa fa-address-book-o" aria-hidden="true"></i>
                            <span>课程操作</span>
                        </a>
                    </li>
                    <li>
                        <a href="javascript:toRoom()">
                            <i class="fa fa-desktop" aria-hidden="true"></i>
                            <span>机房操作</span>
                        </a>
                    </li>
                    <li id="account">
                        <a href="javascript:toAccount()">
                            <i class="fa fa-id-card" aria-hidden="true"></i>
                            <span>账户操作</span>
                        </a>
                    </li>
                    <li>
                        <a href="http://127.0.0.1:8080/crmswar/login">
                            <i class="fa fa-sign-out" aria-hidden="true"></i>
                            <span>退出登录</span>
                        </a>
                        </a>
                </ul>
            </div>
            <div class="main right">
                <iframe src="http://127.0.0.1:8080/crmswar/arrange?<jsp:scriptlet>
                        out.print("id="+request.getAttribute("username") + "&type=" +request.getAttribute("type"));
                    </jsp:scriptlet>" style="height:800px;border: none;" id="flame">
                </iframe>
            </div>
        </div>
        <script>
            // 监听checkbox的点击事件
            $("#checkbox").click(function () {
                // 获取当前checkbox的状态
                var isChecked = $(this).prop("checked");
                console.log(isChecked);
                // 如果当前checkbox是选中状态
                if (isChecked) {
                    document.getElementById("minmenu").style.display = "none";
                    document.getElementById("mixmenu").style.display = "block";
                } else {
                    document.getElementById("minmenu").style.display = "block";
                    document.getElementById("mixmenu").style.display = "none";
                }
            });
            toArrange = function () {
                $("#flame").attr("src", "http://127.0.0.1:8080/crmswar/arrange?<jsp:scriptlet>
                        out.print("id=" + request.getAttribute("username") + "&type=" + request.getAttribute("type"));
                </jsp:scriptlet> ");
            }
            toCourse = function () {
                $("#flame").attr("src", "http://127.0.0.1:8080/crmswar/course?<jsp:scriptlet>
                        out.print("id=" + request.getAttribute("username") + "&type=" + request.getAttribute("type"));
                </jsp:scriptlet> ");
            }
            toRoom = function () {
                $("#flame").attr("src", "http://127.0.0.1:8080/crmswar/room?<jsp:scriptlet>
                        out.print("id=" + request.getAttribute("username") + "&type=" + request.getAttribute("type"));
                </jsp:scriptlet> ");
            }
            toAccount = function () {
                $("#flame").attr("src", "http://127.0.0.1:8080/crmswar/account?<jsp:scriptlet>
                        out.print("id=" + request.getAttribute("username") + "&type=" + request.getAttribute("type"));
                </jsp:scriptlet> ");
            }
            $(document).ready(function () {
                var isadmin = <jsp:scriptlet>
                    out.print(request.getAttribute("type"));
                </jsp:scriptlet>;
                if (isadmin == 1) {
                    document.getElementById("account").style.display = "none";
                    document.getElementById("timetable").style.display = "none";
                    toCourse();
                }
            });
        </script>

    </body>

    </html>