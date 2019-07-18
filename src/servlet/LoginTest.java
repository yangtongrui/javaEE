package servlet;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import pool.C3P0Utils;
import pool.User;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;
import java.io.IOException;
import java.sql.SQLException;

public class LoginTest  extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        System.out.println(username);
        System.out.println(password);
        login(username,password,resp);
    }
    public void login(String username,String password, HttpServletResponse resp){
        try {
            QueryRunner qr = new QueryRunner(C3P0Utils.getDataSource());
            String sql = "select * from t_user where name = ? and password = ?";
            User user = qr.query(sql, new BeanHandler<>(User.class), username, password);
            resp.setContentType("text/html;charset=utf-8");
            if(user != null){
                System.out.println("welecome");
            }
            else{
                System.out.println("failed");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req , resp);
    }
}
