package jdbc.untils;

import java.sql.*;
import java.util.ResourceBundle;

public class JDBCuntils {
    private static String dirver;
    private static String url;
    private static String username;
    private static String passward;
    static {
        ResourceBundle rb = ResourceBundle.getBundle("db");
        dirver = rb.getString("jdbc.driver");
        url = rb.getString("jdbc.url");
        username = rb.getString("jdbc.username");
        passward = rb.getString("jdbc.password");
    }
    public static Connection getconnection(){
        Connection conn = null;
        try {
            Class.forName(dirver);
                conn = DriverManager.getConnection(url,username,passward);
            } catch (SQLException e) {
                e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return conn;
    }
    public static void relese(Connection con, Statement st, ResultSet rs ){
        if(null != con){
            try {
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if(null != st){
            try {
                st.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if(null != rs){
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
