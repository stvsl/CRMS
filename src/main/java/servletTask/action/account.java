package servletTask.action;

import java.io.IOException;

import Entity.classesEntity;
import Entity.teacherEntity;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/account")
public class account extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 获取参数
        String id = req.getParameter("id");
        String type = req.getParameter("type");
        req.setAttribute("userid", id);
        req.setAttribute("type", type);
        if (id.length() != 6) {
            classesEntity c = new classesEntity();
            c.setClassno(id);
            c.searchFromDB();
            req.setAttribute("class", c);

        } else {
            teacherEntity t = new teacherEntity();
            t.setTno(id);
            t.searchFromDB();
            req.setAttribute("teacher", t);
        }
        req.getRequestDispatcher("/account.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("userid");
        // 判断id长度
        if (id.length() == 6) {
            String username = req.getParameter("username");
            String password = req.getParameter("passwd");
            teacherEntity teacher = new teacherEntity(id, username, password);
            teacher.insertToDB();
            resp.sendRedirect("account?id=" + id + "&type=1");
        } else {
            String classname = req.getParameter("classname");
            int grade = Integer.parseInt(req.getParameter("grade"));
            String classdept = req.getParameter("classdept");
            String profession = req.getParameter("classprofession");
            int classton = Integer.parseInt(req.getParameter("classton"));
            String password = req.getParameter("password");
            classesEntity classes = new classesEntity();
            classes.setClassno(id);
            classes.setClassname(classname);
            classes.setClassgrade(grade);
            classes.setClassdept(classdept);
            classes.setClassprofession(profession);
            classes.setClasston(classton);
            classes.setPassword(password);
            classes.updateToDB();
            resp.sendRedirect("account?id=" + id + "&type=2");
        }
    }
}
