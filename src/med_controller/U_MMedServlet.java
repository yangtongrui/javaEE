package med_controller;

import med_service.MedshoppingService;
import med_service.U_MMedService;
import med_table.med;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class U_MMedServlet extends HttpServlet {
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
            int id =(int) session.getAttribute("id");
            U_MMedService u_mMedService = new U_MMedService();
            List<med> medList =  u_mMedService.getAllu_mMed(id);
            req.setAttribute("medList",medList);
            req.getRequestDispatcher("u_m.jsp").forward(req,resp);
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
