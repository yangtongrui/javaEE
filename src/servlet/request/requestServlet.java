package servlet.request;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.dbutils.QueryRunner;
import pool.C3P0Utils;
import pool.User_1;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.util.Map;
import java.util.Set;

public class requestServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");

        try {
            User_1 user_1 = new User_1();
            String hobby="";
            Map<String, String[]> parameterMap = req.getParameterMap();
            BeanUtils.populate(user_1,parameterMap);
            Set<Map.Entry<String, String[]>> entries = parameterMap.entrySet();
            for(Map.Entry<String, String[]> e : entries){
                if(e.getKey().equals("hobby")){
                    for(String s: e.getValue()){
                        hobby+=s+",";
                    }
                }
            }
            System.out.println(hobby);
            user_1.setHobby(hobby);
            register(user_1,resp);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }
    public void register(User_1 user1,HttpServletResponse resp){

        try {
            QueryRunner qr = new QueryRunner(C3P0Utils.getDataSource());
            String sql = "insert into t_us values (null,?,?,?,?,?)";
            int rows = qr.update(sql,user1.getUsername(),user1.getPassword(),user1.getEmail(),user1.getHobby(),user1.getSex());
            if(rows > 0) {
                resp.sendRedirect("/login.html");
            }
                } catch (IOException e) {
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
