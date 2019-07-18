package med_controller;

import med_service.SubmitChangeMedService;
import med_service.SubmitMedService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class SubmitChangeMedServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        double credit = Double.parseDouble(req.getParameter("total"));
        HttpSession session = req.getSession();
        String res = "";
        double cre = 0;
        if(session.getAttribute("credit") != null){
            cre =(Double) session.getAttribute("credit");
            if(cre >= credit){
                cre -= credit;
                SubmitChangeMedService submitMedService = new SubmitChangeMedService();
                submitMedService.addChangeMedSubmitShopping(cre);
            }
            else {
                res = "积分不足，不予兑换";
                req.setAttribute("res",res);
                req.getRequestDispatcher("ChangeMedshoppingServlet").forward(req,resp);
            }
        }

        req.getRequestDispatcher("U_MChangeMedServlet").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}