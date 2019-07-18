package pool;
import com.mchange.v2.c3p0.ComboPooledDataSource;
import java.sql.*;
import javax.sql.DataSource;


public class C3P0Utils {
    private static ComboPooledDataSource dataSource;

    static {
        dataSource = new ComboPooledDataSource();
    }

    public static DataSource getDataSource(){
        return dataSource;
    }
    public static Connection getConnection(){
        Connection conn = null;
        try {
            conn = dataSource.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }

     //释放资源

    public static void releaseRes(Connection conn , Statement st , ResultSet rs){
        if(null != conn){
            try {
                conn.close();
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
