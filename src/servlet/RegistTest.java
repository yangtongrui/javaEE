package servlet;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import pool.C3P0Utils;
import pool.User;
import pool.User_1;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class RegistTest extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password1 = req.getParameter("password1");
        String password2 = req.getParameter("password2");
        System.out.println(username);
        System.out.println(password1);
        System.out.println(password2);

        login(username,password1,password2,resp);
    }
    public void login(String username,String password1,String password2, HttpServletResponse resp){
        Connection conn = null;
        PreparedStatement pstmt1 = null;
        PreparedStatement pstmt = null;
        try {
            String sql = "insert into  t_user  values (null,?,?)";
            String name = "select * from t_user where name = ? ";
            conn = C3P0Utils.getConnection();
            pstmt = conn.prepareStatement(sql);
            pstmt1 = conn.prepareStatement(name);
            pstmt.setString(1  , username);
            pstmt.setString(2 , password1);
            int i = pstmt.executeUpdate();
            if(name.equals(username)) {
                System.out.println("该用户已存在！！！");

            }else {
                if (username != null || password1 != null || password2 != null) {
                    if (password1.equals(password2) && i > 0) {
                        System.out.println("welcome！！！");
                    } else {
                        System.out.println("两次密码不一致！！！");
                    }
                } else {
                    System.out.println("用户名或者密码不能为空！！！");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }


            /*User_1 user_1 = qr.query(sql, new BeanHandler<>(User_1.class), username, password1);
           User user = qr.query(sql, new BeanHandler<>(User.class), username, password1);
            resp.setContentType("text/html;charset=utf-8");
            if(user_1 != null){
                if(username != null || password1 != null || password2 != null){
                    if(password1 == password2){
                        System.out.println("welecome！！！");
                    }else {
                        System.out.println("两次密码不一致！！！");
                    }
                }else {
                    System.out.println("用户名不能为空！！！");
                }

            }
            else{
                System.out.println("failed！！！");
            }*/

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req , resp);
    }
}
