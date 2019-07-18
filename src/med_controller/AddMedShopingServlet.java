package med_controller;

import med_service.AddMedShopingService;
import med_table.med;
import med_table.medshopping;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class AddMedShopingServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        String username = (String)session.getAttribute("username");
       /* System.out.println("username " + username);*/
        if("".equals(username)||username == null) {
            String res = "您还未登录，请先登录！";
            req.setAttribute("res",res);
            req.getRequestDispatcher("userlogin.jsp").forward(req, resp);
            return;
        }
        try {
            String mid = req.getParameter("mid");
            /*System.out.println("mid"+mid);*/
            String s = req.getParameter("number");
            /*System.out.println("s"+s);*/
            int number = Integer.parseInt(s);
            /*System.out.println("nuber"+number);*/
            int id = (int)session.getAttribute("id");
            medshopping medshopping = new medshopping();
            medshopping.setId(id);
            medshopping.setMid(mid);
            medshopping.setNumber(number);
            AddMedShopingService addMedShopingService =new AddMedShopingService();
            addMedShopingService.AddMedShopping(medshopping);
            String pid =(String)session.getAttribute("pid");
            final int msid = medshopping.getMsid();
            String allLogin =(String) req.getAttribute("allLogin");
           /* System.out.println("Shopping"+allLogin);*/
            if(!"".equals(allLogin) && allLogin != null) {
                req.setAttribute("allLogin",allLogin);
                req.setAttribute("mid",mid);
                System.out.println("shp"+mid);
                req.setAttribute("msid",msid);
               /* System.out.println("TYPE"+ allLogin);*/
                req.getRequestDispatcher("SelectMedByTypeServlet?pid=" + pid).forward(req,resp);
            }

                /*resp.sendRedirect("SelectMedByTypeServlet?pid=" + pid);*/
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
