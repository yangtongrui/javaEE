package med_dao;

import med_table.user_d;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import pool.C3P0Utils;

import java.sql.SQLException;
import java.util.List;

public class InsertManagerDao {
    public List<user_d> getAllManager(int id) throws SQLException {
        QueryRunner qr = new QueryRunner(C3P0Utils.getDataSource());
        String sql = "select * from user_d where id = ?" ;
        return qr.query(sql,new BeanListHandler<>(user_d.class),id);
    }
}
