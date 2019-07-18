package med_controller;

import med_service.ChangemedService;
import med_service.ChangemedlistService;
import med_table.Changemed;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class ChangemedlistServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            ChangemedlistService changemedlistService = new ChangemedlistService();
            List<Changemed> changemedList = null;
            changemedList = changemedlistService.getAllchangemed();
            req.setAttribute("changemedList",changemedList);

            req.getRequestDispatcher("medadmin/changemed/list.jsp").forward(req,resp);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
}
