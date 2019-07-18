package med_controller;

import med_service.MedshoppingService;
import med_table.med;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class MedshoppingServlet extends HttpServlet{
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
            MedshoppingService medshoppingService = new MedshoppingService();

            List<med> medList = null;
            medList = medshoppingService.getAllMed();
            req.setAttribute("medList",medList);
            double total = 0;
            for(int i = 0;i < medList.size();i++){
                double tol =  medList.get(i).getMsnumber()*medList.get(i).getPrice();
                total += tol;
            }

           /*System.out.println(total);*/
            req.setAttribute("total",total);
            req.getRequestDispatcher("medshopping.jsp").forward(req,resp);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
