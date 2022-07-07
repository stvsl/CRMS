<%@ page language="java" import="java.util.*, DBUtils.DBExecutor.*,Entity.*" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8" %>
    <html lang="zh">

    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>课表</title>
        <link rel="stylesheet" href="css/pagestyle.css">
    </head>

    <body>
        <h1>当前课表</h1><br />
        <div class="pane">
            <table class="gridtable" border="1">
                <tr>
                    <%arrangeEntity[] arr=(arrangeEntity[])request.getAttribute("arranges");%>
                        <th colspan="2">时间\日期</th>
                        <th>星期一</th>
                        <th>星期二</th>
                        <th>星期三</th>
                        <th>星期四</th>
                        <th>星期五</th>
                        <th>星期六</th>
                        <th>星期日</th>
                </tr>
                <tr>
                    <th rowspan="2">上午</th>
                    <th>8:00-9:50</th>
                    <th>
                        <% if(arr[0]==null){ out.print(""); }else{ out.print(arr[0].toString()); } %>
                    </th>
                    </th>
                    <th>
                        <% if(arr[1]==null){ out.print(""); }else{ out.print(arr[1].toString()); } %>
                    </th>
                    <th>
                        <% if(arr[2]==null){ out.print(""); }else{ out.print(arr[2].toString()); } %>
                    </th>
                    <th>
                        <% if(arr[3]==null){ out.print(""); }else{ out.print(arr[3].toString()); } %>
                    </th>
                    <th>
                        <% if(arr[4]==null){ out.print(""); }else{ out.print(arr[4].toString()); } %>
                    </th>
                    <th>
                        <% if(arr[5]==null){ out.print(""); }else{ out.print(arr[5].toString()); } %>
                    </th>
                    <th>
                        <% if(arr[6]==null){ out.print(""); }else{ out.print(arr[6].toString()); } %>
                    </th>

                </tr>
                <tr>
                    <th>10:15-11:05</th>
                    <th>
                        <% if(arr[7]==null){ out.print(""); }else{ out.print(arr[7].toString()); } %>
                    </th>
                    <th>
                        <% if(arr[8]==null){ out.print(""); }else{ out.print(arr[8].toString()); } %>
                    </th>
                    <th>
                        <% if(arr[9]==null){ out.print(""); }else{ out.print(arr[9].toString()); } %>
                    </th>
                    <th>
                        <% if(arr[10]==null){ out.print(""); }else{ out.print(arr[10].toString()); } %>
                    </th>
                    <th>
                        <% if(arr[11]==null){ out.print(""); }else{ out.print(arr[11].toString()); } %>
                    </th>
                    <th>
                        <% if(arr[12]==null){ out.print(""); }else{ out.print(arr[12].toString()); } %>
                    </th>
                    <th>
                        <% if(arr[13]==null){ out.print(""); }else{ out.print(arr[13].toString()); } %>
                    </th>
                </tr>
                <tr>
                    <th rowspan="2">下午</th>
                    <th>13:30-15:20</th>
                    <th>
                        <% if(arr[14]==null){ out.print(""); }else{ out.print(arr[14].toString()); } %>
                    </th>
                    <th>
                        <% if(arr[15]==null){ out.print(""); }else{ out.print(arr[15].toString()); } %>
                    </th>
                    <th>
                        <% if(arr[16]==null){ out.print(""); }else{ out.print(arr[16].toString()); } %>
                    </th>
                    <th>
                        <% if(arr[17]==null){ out.print(""); }else{ out.print(arr[17].toString()); } %>
                    </th>
                    <th>
                        <% if(arr[18]==null){ out.print(""); }else{ out.print(arr[18].toString()); } %>
                    </th>
                    <th>
                        <% if(arr[19]==null){ out.print(""); }else{ out.print(arr[19].toString()); } %>
                    </th>
                    <th>
                        <% if(arr[20]==null){ out.print(""); }else{ out.print(arr[20].toString()); } %>
                    </th>
                </tr>
                <tr>
                    <th>15:45-16:35</th>
                    <th>
                        <% if(arr[21]==null){ out.print(""); }else{ out.print(arr[21].toString()); } %>
                    </th>
                    <th>
                        <% if(arr[22]==null){ out.print(""); }else{ out.print(arr[22].toString()); } %>
                    </th>
                    <th>
                        <% if(arr[23]==null){ out.print(""); }else{ out.print(arr[23].toString()); } %>
                    </th>
                    <th>
                        <% if(arr[24]==null){ out.print(""); }else{ out.print(arr[24].toString()); } %>
                    </th>
                    <th>
                        <% if(arr[25]==null){ out.print(""); }else{ out.print(arr[25].toString()); } %>
                    </th>
                    <th>
                        <% if(arr[26]==null){ out.print(""); }else{ out.print(arr[26].toString()); } %>
                    </th>
                    <th>
                        <% if(arr[27]==null){ out.print(""); }else{ out.print(arr[27].toString()); } %>
                    </th>
                </tr>
                <tr>
                    <th>晚上</th>
                    <th>18:30-20:20</th>
                    <th>
                        <% if(arr[28]==null){ out.print(""); }else{ out.print(arr[28].toString()); } %>
                    </th>
                    <th>
                        <% if(arr[29]==null){ out.print(""); }else{ out.print(arr[29].toString()); } %>
                    </th>
                    <th>
                        <% if(arr[30]==null){ out.print(""); }else{ out.print(arr[30].toString()); } %>
                    </th>
                    <th>
                        <% if(arr[31]==null){ out.print(""); }else{ out.print(arr[31].toString()); } %>
                    </th>
                    <th>
                        <% if(arr[32]==null){ out.print(""); }else{ out.print(arr[32].toString()); } %>
                    </th>
                    <th>
                        <% if(arr[33]==null){ out.print(""); }else{ out.print(arr[33].toString()); } %>
                    </th>
                    <th>
                        <% if(arr[34]==null){ out.print(""); }else{ out.print(arr[34].toString()); } %>
                    </th>
                </tr>
            </table>
        </div><br />
        <h1>更改课表</h1><br />
        <div class="pane">
            <table class="edittable">
                <tr>
                    <th>课程</th>
                    <th>教师</th>
                    <th>地点</th>
                    <th>上课时间</th>
                    <th>操作</th>
                </tr>
                <% 
                    List<arrangeEntity> arrangeList = (List<arrangeEntity>)request.getAttribute("list");
                    for(arrangeEntity arrange : arrangeList){
                        out.print("<tr>");
                        out.print("<td>" + arrange.getChangeClassno() + "</td>");
                        out.print("<td>" + arrange.getChangeCno() + "</td>");
                        out.print("<td>" + arrange.getChangeTno() + "</td>");
                        // 计算上课时间
                        switch(arrange.getTimes()){
                            case 0:
                                out.print("<td>周一 8:00-9:50</td>");
                                break;
                            case 1:
                                out.print("<td>周二 8:00-9:50</td>");
                                break;
                            case 2:
                                out.print("<td>周三 8:00-9:50</td>");
                                break;
                            case 3:
                                out.print("<td>周四 8:00-9:50</td>");
                                break;
                            case 4:
                                out.print("<td>周五 8:00-9:50</td>");
                                break;
                            case 5:
                                out.print("<td>周六 8:00-9:50</td>");
                                break;
                            case 6:
                                out.print("<td>周日 8:00-9:50</td>");
                                break;
                            case 7:
                                out.print("<td>周一 10:15-11:05</td>");
                                break;
                            case 8:
                                out.print("<td>周二 10:15-11:05</td>");
                                break;
                            case 9:
                                out.print("<td>周三 10:15-11:05</td>");
                                break;
                            case 10:
                                out.print("<td>周四 10:15-11:05</td>");
                                break;
                            case 11:
                                out.print("<td>周五 10:15-11:05</td>");
                                break;
                            case 12:
                                out.print("<td>周六 10:15-11:05</td>");
                                break;
                            case 13:
                                out.print("<td>周日 10:15-11:05</td>");
                                break;
                            case 14:
                                out.print("<td>周一 13:30-15:20/td>");
                                break;
                            case 15:
                                out.print("<td>周二 13:30-15:20</td>");
                                break;
                            case 16:
                                out.print("<td>周三 13:30-15:20</td>");
                                break;
                            case 17:
                                out.print("<td>周四 13:30-15:20</td>");
                                break;
                            case 18:
                                out.print("<td>周五 13:30-15:20</td>");
                                break;
                            case 19:
                                out.print("<td>周六 13:30-15:20</td>");
                                break;
                            case 20:
                                out.print("<td>周日 13:30-15:20</td>");
                                break;
                            case 21:
                                out.print("<td>周一 15:45-16:35</td>");
                                break;
                            case 22:
                                out.print("<td>周二 15:45-16:35</td>");
                                break;
                            case 23:
                                out.print("<td>周三 15:45-16:35</td>");
                                break;
                            case 24:
                                out.print("<td>周四 15:45-16:35</td>");
                                break;
                            case 25:
                                out.print("<td>周五 15:45-16:35</td>");
                                break;
                            case 26:
                                out.print("<td>周六 15:45-16:35</td>");
                                break;
                            case 27:
                                out.print("<td>周日 15:45-16:35</td>");
                                break;
                            case 28:
                                out.print("<td>周一 18:30-20:20</td>");
                                break;
                            case 29:
                                out.print("<td>周二 18:30-20:20</td>");
                                break;
                            case 30:
                                out.print("<td>周三 18:30-20:20</td>");
                                break;
                            case 31:
                                out.print("<td>周四 18:30-20:20</td>");
                                break;
                            case 32:
                                out.print("<td>周五 18:30-20:20</td>");
                                break;
                            case 33:
                                out.print("<td>周六 18:30-20:20</td>");
                                break;
                            case 34:
                                out.print("<td>周日 18:30-20:20</td>");
                                break;
                        }
                        out.print("<td><a href='http://127.0.0.1:8080/crmswar/arrange?delete=1&time=" + arrange.getTimes() + "&id="+request.getAttribute("userid")+"&type="+ request.getAttribute("type") +"&classno="+arrange.getClassno()+"'>删除</a></td>");
                        out.print("</tr>");
                    }
                %>
            </table>
        </div><br />
        <h1>添加课表</h1>
        <div>
            <form action="arrange" method="post" class="form">
                <div class="inputbox">
                    <input type="hidden" name="id" value="<% out.print(request.getAttribute("userid")); %>">
                    <input type="hidden" name="type" value="<% out.print(request.getAttribute("type")); %>">
                    <label for="course">课程</label><input type="text" placeholder="请输入课程名称" name="course" id="course">
                    <label for="teacher">教师</label><input type="text" placeholder="请输入教师" name="teacher" id="teacher">
                    <label for="place">地点</label><input type="text" placeholder="请输入地点" name="place" id="place">
                    <label for="time">上课时间</label>
                    <!-- 星期下拉列表 -->
                    <select name="week" id="week" style="width:8%">
                        <option value="1">星期一</option>
                        <option value="2">星期二</option>
                        <option value="3">星期三</option>
                        <option value="4">星期四</option>
                        <option value="5">星期五</option>
                        <option value="6">星期六</option>
                        <option value="7">星期日</option>
                    </select>
                    <select name="time" id="time">
                        <option value="1">8:00-9:50</option>
                        <option value="2">10:15-11:05</option>
                        <option value="3">13:30-15:20</option>
                        <option value="4">15:45-16:35</option>
                        <option value="5">18:30-20:20</option>
                    </select>
                    &nbsp
                    <input type="submit" value="添加">
                </div>
            </form>
        </div><br />
    </body>

    </html>