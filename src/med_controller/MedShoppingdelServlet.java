package med_controller;

import med_service.MedShoppingdelService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;

public class MedShoppingdelServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        try {
           /* String msid =(String) req.getAttribute("msid");
            HttpSession session =req.getSession();
            int msid = (int)session.getAttribute("msid");*/
             int msid =Integer.parseInt(req.getParameter("msid")) ;
            /*System.out.println("msid"+msid);*/
            MedShoppingdelService  medShoppingdelService = new MedShoppingdelService();
            medShoppingdelService.DelmedshoppingBymsid(msid);
            resp.sendRedirect(req.getContextPath()+"MedshoppingServlet");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
}
