package med_controller;

import med_service.AddChangeMedShopingService;
import med_service.AddMedShopingService;
import med_table.changemedshopping;
import med_table.medshopping;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;

public class AddChangemedShopingServlet extends HttpServlet {
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
            String cmid = req.getParameter("cmid");
            int id = (int)session.getAttribute("id");

            changemedshopping changemedshopping = new changemedshopping();
            changemedshopping.setId(id);
            changemedshopping.setCmid(cmid);
            AddChangeMedShopingService addChangeMedShopingService =new AddChangeMedShopingService();
            addChangeMedShopingService.AddChangeMedShopping(changemedshopping);
            String pid =(String)session.getAttribute("pid");
            final int cmsid = changemedshopping.getCmsid();
            String allLogin =(String) req.getAttribute("allLogin");
            req.setAttribute("msid",cmsid);
            req.getRequestDispatcher("/ChangemedServlet").forward(req,resp);
            /* System.out.println("Shopping"+allLogin);*/
           /* if(!"".equals(allLogin) && allLogin != null) {
                req.setAttribute("allLogin",allLogin);
                req.setAttribute("cmid",cmid);
                *//* System.out.println("shp"+mid);*//*
                req.setAttribute("cmsid",cmsid);
                *//* System.out.println("TYPE"+ allLogin);*//*
                req.getRequestDispatcher("ChangeMedlistServlet").forward(req,resp);
            }*/
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
