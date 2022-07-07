package servletTask.security;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;

@WebServlet("/register")
public class register extends HttpServlet {

    @Override
    protected void doPost(jakarta.servlet.http.HttpServletRequest req, jakarta.servlet.http.HttpServletResponse resp)
            throws jakarta.servlet.ServletException, java.io.IOException {
        String username = req.getParameter("userid");
        String password = req.getParameter("passwd");
        // 判断密码长度是否大于6位
        if (password.length() < 6) {
            req.setAttribute("msg", "密码长度不能小于6位");
            req.getRequestDispatcher("/login.jsp").forward(req, resp);
        } else {
            String type = req.getParameter("type");
            int loginer = DBUtils.DBExecutor.login.register(username, password, type);
            if (loginer == 1) {
                req.getSession().setAttribute("username", username);
                req.setAttribute("username", username);
                req.setAttribute("type", type.equals("class") ? 2 : 1);
                req.getRequestDispatcher("/completeaccount.jsp").forward(req, resp);
            } else {
                req.setAttribute("msg", "用户已被注册");
                req.getRequestDispatcher("/login.jsp").forward(req, resp);
            }
        }
    }
}
