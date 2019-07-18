package med_controller;

import med_service.InsertMedService;
import med_service.MeddelService;
import med_service.NeedMeddelService;
import med_table.med;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class NeedMeddelServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        try {
            String mid = req.getParameter("mid");
            NeedMeddelService needMeddelService = new NeedMeddelService();
            needMeddelService.delneedmedByMid(mid);
            resp.sendRedirect(req.getContextPath()+"/NeedmedlistServlet");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
}
