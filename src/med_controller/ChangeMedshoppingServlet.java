package med_controller;

import med_service.ChangeMedshoppingService;
import med_service.MedshoppingService;
import med_table.Changemed;
import med_table.med;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class ChangeMedshoppingServlet extends HttpServlet {
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

        try {
           /* String mid = (String)req.getAttribute("mid");
            System.out.println("mid"+mid);*/
           ChangeMedshoppingService changeMedshoppingService = new ChangeMedshoppingService();
            List<Changemed> changemedList = null;
            changemedList = changeMedshoppingService.getAllchangeMed();
            req.setAttribute("changemedList",changemedList);
            double total = 0;
            for(int i = 0;i < changemedList.size();i++){
                total += changemedList.get(i).getCredit();
            }

            /*System.out.println(total);*/
            req.setAttribute("total",total);
            req.getRequestDispatcher("changemedshopping.jsp").forward(req,resp);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
