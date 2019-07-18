package med_dao;
import med_table.manager;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import pool.C3P0Utils;

import java.sql.SQLException;
import java.util.List;

public class LoginDao {
    //private String name;
    //private String password;
    public List<manager> getAlllogin() throws SQLException {
        QueryRunner qr = new QueryRunner(C3P0Utils.getDataSource());
        String sql = "select * from manager ";
        List<manager> list = qr.query(sql, new BeanListHandler<>(manager.class));
        return (List<manager>) list;
    }
}
