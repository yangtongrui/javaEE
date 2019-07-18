package med_controller;

import med_service.ChangemedService;
import med_table.Changemed;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class ChangemedServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        HttpSession session = req.getSession();
        String username = (String)session.getAttribute("username");
        /*System.out.println("username " + username);*/
        if("".equals(username)||username == null) {
            String res = "您还未登录，请先登录！";
            req.setAttribute("res",res);
            req.getRequestDispatcher("userlogin.jsp").forward(req, resp);
            return;
        }
        double credit = (double)session.getAttribute("credit");
       /* String credit = cre + "";*/
        /*System.out.println("username " + username);*/
        /*System.out.println("credit"+cre);*/
        if(credit == 0) {
            String res = "您未购买过普通商品，不能换购！";
            req.setAttribute("res",res);
            /*System.out.println("res"+res);*/
            req.getRequestDispatcher("index.jsp").forward(req, resp);
            return;
        }
        try {
            ChangemedService changemedService = new ChangemedService();
            List<Changemed> changemedList = changemedService.getAllChangemed();
            req.setAttribute("changemedList",changemedList);
            req.getRequestDispatcher("changemed.jsp").forward(req,resp);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
}
