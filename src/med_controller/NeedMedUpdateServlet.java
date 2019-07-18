package med_controller;

import med_service.MedUpdateService;
import med_table.med;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class NeedMedUpdateServlet  extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        try {

            req.setCharacterEncoding("utf-8");
            med med = new med();
            BeanUtils.populate(med , req.getParameterMap());
//            System.out.println(req.getParameter("mid"));
            med.setMdate(new SimpleDateFormat("yyyy-MM-dd").format(new Date().getTime()));
            MedUpdateService medUpdateService = new MedUpdateService();
            medUpdateService.updatemedBymid(med);

            resp.sendRedirect( "NeedmedlistServlet");
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }


    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req , resp);
    }
}
