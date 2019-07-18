package med_controller;

import med_service.ChangeMedShoppingdelService;
import med_service.MedShoppingdelService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

public class ChangeMedShoppingdelServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        try {

            int cmsid =Integer.parseInt(req.getParameter("cmsid")) ;
            /*System.out.println("msid"+msid);*/
            ChangeMedShoppingdelService changemedShoppingdelService = new ChangeMedShoppingdelService();
            changemedShoppingdelService.DelchangemedshoppingBycmsid(cmsid);
            resp.sendRedirect(req.getContextPath()+"ChangeMedshoppingServlet");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
}
