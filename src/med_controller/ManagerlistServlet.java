package med_controller;

import med_service.ManagerListService;
import med_table.manager;
import med_table.user_d;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class ManagerlistServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        try {
            ManagerListService managerListService = new ManagerListService();
            List<user_d> managerList = managerListService.getAllmanager();
            req.setAttribute("managerList",managerList);
            req.getRequestDispatcher("medadmin/manager/list.jsp").forward(req,resp);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
}
