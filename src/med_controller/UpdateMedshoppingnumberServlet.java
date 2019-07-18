package med_controller;

import med_service.UpdateMedshoppingnumberService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

public class UpdateMedshoppingnumberServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        try {
            int msnumber = Integer.parseInt( req.getParameter("msnumber"));
            System.out.println("msnumber"+msnumber);
            UpdateMedshoppingnumberService updateMedshoppingnumberService = new UpdateMedshoppingnumberService();
            String res = updateMedshoppingnumberService.UpdateMedshoppingnumber(msnumber);
            if(res.equals("修改成功")){
                req.setAttribute("res",res);
                req.getRequestDispatcher("MedshoppingServlet").forward(req,resp);
            }
            else if(res.equals("修改失败"))
            {
                req.setAttribute("res",res);
                req.getRequestDispatcher("MedshoppingServlet").forward(req,resp);
            }
            req.getRequestDispatcher("MedshoppingServlet").forward(req,resp);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
}
