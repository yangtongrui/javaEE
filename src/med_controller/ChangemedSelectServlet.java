package med_controller;

import med_service.ChangemedSelectService;
import med_table.Changemed;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class ChangemedSelectServlet  extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        try {
            req.setCharacterEncoding("utf-8");
            String cmid = req.getParameter("cmid");
            ChangemedSelectService changemedSelectService = new ChangemedSelectService();
            List<Changemed> changemedList = changemedSelectService.getAllChangemed(cmid);
           /* Product product = productService.getProductById(cmid);*/
            req.getAttribute("cmid");
            req.setAttribute("changemedList" , changemedList);
            req.getRequestDispatcher("medadmin/changemed/edit.jsp").forward(req , resp);
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req , resp);
    }
}
