package med_controller;

import med_service.ChangemedSelectService;
import med_service.InsertManagerService;
import med_table.Changemed;
import med_table.user_d;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class InsertManagerServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        try {
            req.setCharacterEncoding("utf-8");
            int id = Integer.parseInt(req.getParameter("id"));
            InsertManagerService insertManagerService = new InsertManagerService();
            List<user_d> user_dList =  insertManagerService.getAllManager(id);
            req.setAttribute("user_dList" , user_dList);
           /* System.out.println(user.getName());
            System.out.println(user.getSign());*/
            req.getRequestDispatcher("medadmin/manager/edit.jsp").forward(req , resp);
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req , resp);
    }
}