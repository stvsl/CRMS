package servletTask.security;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;

@WebServlet("/login")
public class login extends HttpServlet {

    public login() {
        super();
    }

    @Override
    protected void doGet(jakarta.servlet.http.HttpServletRequest request,
            jakarta.servlet.http.HttpServletResponse response)
            throws jakarta.servlet.ServletException, java.io.IOException {
        request.getRequestDispatcher("/login.jsp").forward(request,
                response);
    }

    @Override
    protected void doPost(jakarta.servlet.http.HttpServletRequest req, jakarta.servlet.http.HttpServletResponse resp)
            throws jakarta.servlet.ServletException, java.io.IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        int loginer = DBUtils.DBExecutor.login.verify(username, password);
        if (loginer >= 1) {
            req.setAttribute("username", username);
            req.setAttribute("type", loginer);
            req.getRequestDispatcher("/index.jsp").forward(req, resp);
        } else {
            req.setAttribute("msg", "用户名或密码错误");
            req.getRequestDispatcher("/login.jsp").forward(req, resp);
        }
    }
}
