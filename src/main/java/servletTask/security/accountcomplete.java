package servletTask.security;

import java.io.IOException;

import DBUtils.DBExecutor.infoUpdate;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/completeaccount")
public class accountcomplete extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (req.getParameter("classdept") == null) {
            String username = req.getParameter("username");
            String userid = req.getParameter("userid");
            infoUpdate.updateTeacherInfo(userid, username);
            req.getRequestDispatcher("/index.jsp").forward(req, resp);
        } else {
            String classno = req.getParameter("userid");
            String classname = req.getParameter("classname");
            String classdept = req.getParameter("classdept");
            String classprofession = req.getParameter("classprofession");
            String classgrade = req.getParameter("grade");
            String classton = req.getParameter("classton");
            infoUpdate.updateClassInfo(classno, classname, Integer.parseInt(classgrade),
                    classdept, classprofession,
                    Integer.parseInt(classton));
            req.setAttribute("username", classno);
            req.setAttribute("type", "2");
            req.getRequestDispatcher("/index.jsp").forward(req, resp);
        }
    }
}
