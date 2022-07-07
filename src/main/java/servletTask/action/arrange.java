package servletTask.action;

import java.io.IOException;
import java.util.List;

import DBUtils.DBBusiness.arrangeDao;
import Entity.arrangeEntity;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/arrange")
public class arrange extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 获取参数
        String id = req.getParameter("id");
        String type = req.getParameter("type");
        req.setAttribute("userid", id);
        req.setAttribute("type", type);
        // 判断是否删除课程
        if (req.getParameter("delete") != null && req.getParameter("delete").equals("1")) {
            String time = req.getParameter("time");
            arrangeEntity a = new arrangeEntity();
            a.setClassno(req.getParameter("classno"));
            a.setTimes(Integer.parseInt(time));
            a.deleteFromDB();
        }
        arrangeDao arrangeDao = new arrangeDao();
        List<arrangeEntity> list = arrangeDao.searchAll(id);
        req.setAttribute("list", list);
        arrangeEntity[] a = arrangeDao.listToArray(list);
        req.setAttribute("arranges", a);
        req.getRequestDispatcher("/arrange.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 获取参数
        String id = req.getParameter("id");
        String type = req.getParameter("type");
        String course = req.getParameter("course");
        String teacher = req.getParameter("teacher");
        String room = req.getParameter("place");
        String week = req.getParameter("week");
        String time = req.getParameter("time");
        arrangeEntity arr = new arrangeEntity();
        arr.setClassno(id);
        arr.setChangeTno(teacher);
        arr.setRno(room);
        arr.setChangeCno(course);
        int w = Integer.parseInt(week);
        int t = Integer.parseInt(time);
        arr.setTimes((t - 1) * 7 + w - 1);
        arr.insertToDB();
        resp.sendRedirect("arrange?id=" + id + "&type=" + type);
    }
}
