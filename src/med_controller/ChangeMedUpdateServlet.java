package med_controller;

import med_service.ChangeMedUpdateService;
import med_table.Changemed;
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

public class ChangeMedUpdateServlet  extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        try {

            req.setCharacterEncoding("utf-8");
            Changemed changemed = new Changemed();/*
            String cmid = req.getParameter("cmid");
            String name = req.getParameter("cmname");
            System.out.println("getpara cmid" + cmid);

            System.out.println("getpara name" + name);*/
            BeanUtils.populate(changemed , req.getParameterMap());
            changemed.setCdate(new SimpleDateFormat("yyyy-MM-dd").format(new Date().getTime()));
            ChangeMedUpdateService changeMedUpdateService = new ChangeMedUpdateService();
            changeMedUpdateService.updateChangemedBycmid(changemed);

            resp.sendRedirect( "ChangemedlistServlet");
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
