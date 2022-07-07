<%@ page language="java" contentType="text/html; charset=utf-8"
    import="java.util.*,Entity.*" pageEncoding="utf-8" %>
    <html lang="en">

    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>课程操作</title>
        <link rel="stylesheet" href="css/pagestyle.css">
    </head>

    <body>
        <h1>当前全部课程</h1>
        <br>
        <div class="pane">
            <table class="edittable">
                <tr>
                    <th>课程编号</th>
                    <th>课程名称</th>
                    <th>时长</th>
                    <th>操作</th>
                </tr>
                <%
                    List<courseEntity> courses = (List<courseEntity>)request.getAttribute("courses");
                    for(courseEntity course : courses) {
                        out.println("<tr>");
                        out.println("<td>" + course.getCno() + "</td>");
                        out.println("<td>" + course.getCname() + "</td>");
                        out.println("<td>" + course.getLength() + "</td>");
                        out.println("<td> <a href='http://127.0.0.1:8080/crmswar/course?id=" + request.getParameter("userid") + "&type=" +  request.getParameter("type") + "&cno=" + course.getCno() + "'>删除</a> </td>");
                        out.println("</tr>");
                    }
                %>
            </table>
        </div><br />
        <h1>添加课程</h1>
        <br />
        <div>
            <form action="course" method="post" class="form">
                <div class="inputbox">
                    <label for="course">课程编号</label><input type="text" name="cno">
                    <label for="teacher">课程名称</label><input type="text" name="cname">
                    <label for="time">时长</label><input type="text" name="time">
                    &nbsp
                    <input type="submit" value="添加">
                </div>
            </form>
        </div><br />
        <script>
            <jsp:scriptlet>
                if(request.getAttribute("msg")!=null){
                    out.println("alert('" + request.getAttribute("msg") + "')");
                }
            </jsp:scriptlet>
        </script>
    </body>

    </html>