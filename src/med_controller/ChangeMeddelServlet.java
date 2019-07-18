package med_controller;

import med_service.ChangeMeddelService;
import med_service.UserdelService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

public class ChangeMeddelServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        try {
            String cmid = req.getParameter("cmid");
            ChangeMeddelService changeMeddelService = new ChangeMeddelService();
            changeMeddelService.delchangemedBycmid(cmid);
            resp.sendRedirect(req.getContextPath()+"/ChangemedlistServlet");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
}
