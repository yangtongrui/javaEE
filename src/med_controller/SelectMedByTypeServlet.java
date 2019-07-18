package med_controller;

import med_service.SelectMedByTypeService;
import med_table.med;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

public class SelectMedByTypeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        try {


            String pid = req.getParameter("pid");
            HttpSession session = req.getSession();
            session.setAttribute("pid",pid);
            SelectMedByTypeService selectMedByTypeService = new SelectMedByTypeService();
            List<med> medList =  selectMedByTypeService.getAllMedByType(pid);
            String allLogin =(String) req.getAttribute("allLogin");
           /* System.out.println("type"+allLogin);*/
            if(!"".equals(allLogin) && allLogin != null) {
                req.setAttribute("allLogin",allLogin);
            }
            req.setAttribute("medList",medList);
            req.getRequestDispatcher("med.jsp").forward(req,resp);
            /*String allLogin = (String)session.getAttribute("allLogin");*/

            } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }

}
