package med_controller;

import med_service.UserRegistService;
import med_table.user_d;
import pool.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

public class userRegistServlet  extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

            try {
                String name = req.getParameter("name");
                String pwd = req.getParameter("password");
                String a_pwd = req.getParameter("userpassword");
                String res = "";
                UserRegistService userRegistService = new UserRegistService();
                if (userRegistService.register(name)) {
                    user_d user = new user_d();
                    user.setName(name);
                    user.setPassword(pwd);
                    res = userRegistService.addUser(user);
                    if (pwd.equals(a_pwd)) {
                        if ("注册成功".equals(res)) {
                            req.setAttribute("res", res);

                            resp.sendRedirect("userlogin.jsp");
//                            req.getRequestDispatcher("userlogin.jsp").forward(req, resp);
                            return;
                        } else {
                            req.setAttribute("res", res);
                            req.getRequestDispatcher("userregist.jsp").forward(req, resp);
                            return;
                        }
                    } else {
                        res = "两次密码不一致";
                        req.setAttribute("res", res);
                        req.getRequestDispatcher("userregist.jsp").forward(req, resp);
                        return;
                    }
                } else {
                    res = "该账号已存在";
                    req.setAttribute("res", res);
                    req.getRequestDispatcher("userregist.jsp").forward(req, resp);
                    return;
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
