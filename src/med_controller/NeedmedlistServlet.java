package med_controller;

import med_service.NeedmedlistService;
import med_table.med;
import med_table.needmed;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class NeedmedlistServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        try {
            NeedmedlistService needmedlistService = new NeedmedlistService();
            List<med> needmedList = needmedlistService.Selectneedmed();
            req.setAttribute("needmedList",needmedList);
            req.getRequestDispatcher("medadmin/needmed/list.jsp").forward(req,resp);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
}
