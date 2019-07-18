package med_controller;

import med_service.SubmitMedService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class SubmitMedServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        double credit = Double.parseDouble(req.getParameter("total"));
        HttpSession session = req.getSession();
        double cre = 0;
        if(session.getAttribute("credit") != null){
               cre =(Double) session.getAttribute("credit");
                cre += credit;
                SubmitMedService  submitMedService = new SubmitMedService();
                submitMedService.addMedSubmitShopping(cre);
                req.getRequestDispatcher("U_MMedServlet").forward(req,resp);
        }


    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
}
