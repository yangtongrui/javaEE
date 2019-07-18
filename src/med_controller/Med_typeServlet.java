package med_controller;

import med_service.Med_typeService;
import med_table.med_type;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class Med_typeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        try {
            Med_typeService med_typeService = new Med_typeService();
            List<med_type> med_typeList = med_typeService.getAllmed_type();
            req.setAttribute("med_typeList",med_typeList);
            req.getRequestDispatcher("medadmin/med/add.jsp").forward(req,resp);
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
}
