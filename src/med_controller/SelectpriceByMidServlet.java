package med_controller;
import med_service.SelectpriceByMidService;
import med_table.med;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class SelectpriceByMidServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        try {
            String mid = req.getParameter("mid");
            int number = Integer.parseInt(req.getParameter("number"));
            SelectpriceByMidService selectpriceByMidService = new SelectpriceByMidService();
            String allLogin = selectpriceByMidService.selectpriceByMid(mid, number);
            HttpSession session = req.getSession();
            String pid = (String)session.getAttribute("pid");
            if ("1".equals(allLogin)) {
                req.setAttribute("allLogin", allLogin);
                /*System.out.println("price"+allLogin);*/
                req.setAttribute("mid", mid);
                req.getRequestDispatcher("AddMedShopingServlet?number=" + number + "&mid=" + mid).forward(req,resp);
               /* resp.sendRedirect("/AddMedShopingServlet?number=" + number + "&mid=" + mid);*/
                return;
            }else {
                req.setAttribute("allLogin", allLogin);
                /*System.out.println("price"+allLogin);*/
                req.getRequestDispatcher("/SelectMedByTypeServlet?pid="+pid).forward(req,resp);
               /* resp.sendRedirect("/SelectMedByTypeServlet?pid="+pid);*/
            }
            } catch(SQLException e){
                e.printStackTrace();
            }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
}
