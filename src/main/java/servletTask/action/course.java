package servletTask.action;

import java.io.IOException;
import java.util.List;

import DBUtils.DBBusiness.courseDao;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import Entity.courseEntity;

@WebServlet("/course")
public class course extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 获取参数

        String id = req.getParameter("id");
        String type = req.getParameter("type");
        req.setAttribute("userid", id);
        req.setAttribute("type", type);
        // 判断是否删除课程
        if (req.getParameter("cno") != null) {
            String cno = req.getParameter("cno");
            courseEntity c = new courseEntity();
            c.setCno(cno);
            c.deleteFromDB();
        }
        // 查询数据库
        courseDao courseDao = new courseDao();
        List<courseEntity> courses = courseDao.searchAll();
        req.setAttribute("courses", courses);
        // 判断是否有权限
        if (type == "" || type.equals("1")) {
            req.getRequestDispatcher("/course.jsp").forward(req, resp);
        } else {
            req.getRequestDispatcher("/nopower.jsp").forward(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String cno = req.getParameter("cno");
        String cname = req.getParameter("cname");
        String length = req.getParameter("time");
        courseEntity c = new courseEntity();
        c.setCno(cno);
        c.setCname(cname);
        c.setLength(Integer.parseInt(length));
        c.insertToDB();
        resp.sendRedirect("course?id=" + req.getParameter("userid") + "&type=" + 1);
    }
}
