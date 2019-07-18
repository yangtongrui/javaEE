package med_controller;

import med_service.InsertMedService;
import med_table.med;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class InsertMedServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        try {
            String mid = req.getParameter("mid");
            InsertMedService insertMedService = new InsertMedService();
             List<med> medList = insertMedService.insertmedByMid(mid);
             req.setAttribute("medList",medList);
            req.getRequestDispatcher("medadmin/med/edit.jsp").forward(req , resp);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
}
