package med_controller;

import med_service.userLoginService;
import med_table.user_d;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;

public class userLoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        try {
            user_d user = new user_d();
            String sname = req.getParameter("username");
            String spassword = req.getParameter("userpassword");

            /*System.out.println("spass"+spassword);*/
            userLoginService loginuserService = new userLoginService();

            user.setName(sname);
            user.setPassword(spassword);
            String allLogin = null;
            /*System.out.println(user.getPassword());*/
            allLogin = loginuserService.getAlluserLogin(user);
            String res = null;
           /* System.out.println(allLogin);*/
            if("1".equals(allLogin)){
                HttpSession session = req.getSession();
                session.setAttribute("username",sname);
                session.setAttribute("id",user.getId());
                session.setAttribute("credit",user.getCredit());
                /*System.out.println("spassword"+spassword);*/
                req.setAttribute("res",res);
                req.getRequestDispatcher("index.jsp").forward(req,resp);
                return;
            }else {
                /*HttpSession session = req.getSession();
                session.setAttribute("err",allLogin);*/
                res = "用户名或者密码错误";
                req.setAttribute("res",res);
                req.getRequestDispatcher("userlogin.jsp").forward(req,resp);
                return;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
}
