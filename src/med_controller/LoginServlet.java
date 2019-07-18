package med_controller;

import med_service.LoginService;
import med_table.manager;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import pool.C3P0Utils;
import pool.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class LoginServlet extends HttpServlet {
    private String name;
    private String password;
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            String sname = req.getParameter("username");
            String spassword = req.getParameter("userpassword");
            LoginService loginService = new LoginService();
            String allLogin = loginService.getAllLogin(sname, spassword);
           // System.out.println(allLogin);
            if("1".equals(allLogin)){
                req.getRequestDispatcher("medadmin/home.jsp").forward(req,resp);
                return;
            }else {
                HttpSession session = req.getSession();
                session.setAttribute("err",allLogin);
                req.getRequestDispatcher("medadmin/login.jsp").forward(req,resp);
                return;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }
}
