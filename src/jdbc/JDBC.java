package jdbc;

import java.sql.*;

import jdbc.untils.JDBCuntils;
import org.junit.Test;
import pool.C3P0Utils;

public class JDBC {
    @Test
    public  void testQuery()
    {
           Connection conn = null;
            Statement st = null;
            ResultSet re = null;
            try {
                /*//1.加载驱动
                Class.forName("com.mysql.jdbc.Driver");
                //2.获取连接
                conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/web", "root", "123456");*/
                conn = JDBCuntils.getconnection();

                //3.获取StateMent对象
                st = conn.createStatement();
                //4.编写sql语句
                String sql = "select * from t_user";
                //5.执行sql语句
                re = st.executeQuery(sql);
                while (re.next()) {
                    System.out.println("id:" + re.getInt("id" )+ " "+"name:" + re.getString("name"));
                }
            } catch (SQLException e) {
                    e.printStackTrace();
            } finally {
                JDBCuntils.relese(conn,st,re);

        }
    }
    @Test
    public void update(){
        Connection conn = null;
        PreparedStatement pstmt = null;

        try {
            String sql = "update t_user set name = 'ss' where id = 1";
            conn = C3P0Utils.getConnection();
            pstmt = conn.prepareStatement(sql);
            int i = pstmt.executeUpdate();
            if(i > 0){
                System.out.println("修改成功！");
            }
            if(i < 0){
                System.out.println("修改失败！");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    @Test
    public void delete(){
        Connection conn = null;
        PreparedStatement pstmt = null;

        try {
            conn = JDBCuntils.getconnection();
            String sql = "delete from t_user where id = 1";
            pstmt = conn.prepareStatement(sql);
            int i = pstmt.executeUpdate();
            if(i > 0){
                System.out.println("修改成功！");
            }
            if(i < 0){
                System.out.println("修改失败！");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            conn = JDBCuntils.getconnection();
            String sql = "insert t_user values('4','aa','1234')";
            pstmt = conn.prepareStatement(sql);
            int i = pstmt.executeUpdate();
            if(i > 0){
                System.out.println("添加成功！");
            }
            if(i < 0){
                System.out.println("添加失败！");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
