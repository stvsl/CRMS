<%@ page language="java" contentType="text/html; charset=utf-8" import="java.util.*,DBUtils.DBExecutor.*,Entity.*"
    pageEncoding="utf-8" %>
    <html lang="en">

    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>机房操作</title>
        <link rel="stylesheet" href="css/pagestyle.css">
    </head>

    <body>
        <h1>当前全部机房</h1>
        <br>
        <div class="pane">
            <table class="edittable">
                <tr>
                    <th>机房编号</th>
                    <th>机房描述</th>
                    <th>操作</th>
                </tr>
                <tr>
                    <%
                        List<roomEntity> roomList = (List<roomEntity>)request.getAttribute("rooms");
                        for(roomEntity room : roomList){
                            out.println("<tr>");
                            out.println("<td>" + room.getRno() + "</td>");
                            out.println("<td>" + room.getDescription() + "</td>");
                            out.println("<td><a href='http://127.0.0.1:8080/crmswar/room?id=" + request.getParameter("userid") + "&type=" +  request.getParameter("type") + "&rno=" + room.getRno() + "'>删除</a> </td>");
                            out.println("</tr>");
                        }
                    %>
                </tr>
            </table>
        </div><br />
        <h1>添加机房</h1>
        <div>
            <form action="room" method="post" class="form">
                <div class="inputbox">
                    <label for="course">机房编号</label><input type="text" name="rno">
                    <label for="teacher">机房描述</label><input type="text" name="description">
                    &nbsp
                    <input type="submit" value="添加">
                </div>
            </form>
        </div><br />

    </body>

    </html>