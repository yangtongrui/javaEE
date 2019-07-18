package med_controller;

import med_service.ChangeMedUpdateService;
import med_service.ManagerMedUpdateService;
import med_table.Changemed;
import med_table.user_d;
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

public class ManagerUpdateServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        try {

            req.setCharacterEncoding("utf-8");
            user_d user = new user_d();
            BeanUtils.populate(user , req.getParameterMap());
            String sign = (String)req.getParameter("sign");
           /* System.out.println("sign"+sign);*/
            if(sign.equals("会员")){
                user.setSign(1);
            }
            else if(sign.equals("非会员")){
                user.setSign(0);
            }
            ManagerMedUpdateService managerMedUpdateService = new ManagerMedUpdateService();
            managerMedUpdateService.updateManagerByid(user);
           /* System.out.println(user);*/
            req.getRequestDispatcher("ManagerlistServlet").forward(req , resp);
           /* resp.sendRedirect( "ManagerlistServlet");*/
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
