package med_controller;

import com.sun.security.auth.UnixNumericUserPrincipal;
import med_service.MedaddService;
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
import java.util.List;
import java.util.UUID;

public class MedaddServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        try {
            req.setCharacterEncoding("utf-8");
            med med = new med();
            BeanUtils.populate(med,req.getParameterMap());
            med.setMid(UUID.randomUUID().toString());
            med.setMimg("mimge/10.jpg");
            med.setMdate(new SimpleDateFormat("yyyy-MM-dd").format(new Date().getTime()));
            MedaddService medaddService = new MedaddService();
            //手动加入mname,mimg,price,mdate,number,function,pid
             medaddService.getinsertMed(med);
             resp.sendRedirect(req.getContextPath()+"/MedlistServlet");

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
