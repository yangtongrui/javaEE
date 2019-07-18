package med_controller;

import med_service.ChangeMedaddService;
import med_service.MedaddService;
import med_table.Changemed;
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
import java.util.UUID;

public class ChangemedAddServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        try {
            req.setCharacterEncoding("utf-8");
            Changemed changemed = new Changemed();
            BeanUtils.populate(changemed, req.getParameterMap());
            changemed.setCmid(UUID.randomUUID().toString());
            changemed.setCimg("mimge/10.jpg");
            changemed.setCdate(new SimpleDateFormat("yyyy-MM-dd").format(new Date().getTime()));
            ChangeMedaddService changeMedaddService = new ChangeMedaddService();
            //手动加入mname,mimg,price,mdate,number,function,pid
            changeMedaddService.getChangeMedAdd(changemed);
            resp.sendRedirect(req.getContextPath() + "/ChangemedlistServlet");

        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
}
