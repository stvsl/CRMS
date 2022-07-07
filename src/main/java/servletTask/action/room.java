package servletTask.action;

import java.io.IOException;
import java.util.List;

import DBUtils.DBBusiness.roomDao;
import Entity.roomEntity;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/room")
public class room extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 判断是否删除课程
        if (req.getParameter("rno") != null) {
            String rno = req.getParameter("rno");
            roomEntity r = new roomEntity();
            r.setRno(rno);
            r.deleteFromDB();
        }
        String id = req.getParameter("id");
        String type = req.getParameter("type");
        req.setAttribute("userid", id);
        req.setAttribute("type", type);
        roomDao roomDao = new roomDao();
        List<roomEntity> rooms = roomDao.searchAll();
        req.setAttribute("rooms", rooms);
        // 判断是否有权限
        if (type == "" || type.equals("1")) {
            req.getRequestDispatcher("/room.jsp").forward(req, resp);
        } else {
            req.getRequestDispatcher("/nopower.jsp").forward(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String rno = req.getParameter("rno");
        String description = req.getParameter("description");
        roomEntity r = new roomEntity();
        r.setRno(rno);
        r.setDescription(description);
        r.insertToDB();
        resp.sendRedirect("room?id=" + req.getParameter("userid") + "&type=" + 1);
    }
}
