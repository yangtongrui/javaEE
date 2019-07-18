package med_dao;

import org.apache.commons.dbutils.QueryRunner;
import pool.C3P0Utils;

import java.sql.SQLException;

public class UserdelDao {
    public void deluserByName(String name) throws SQLException {
        QueryRunner qr = new QueryRunner(C3P0Utils.getDataSource());
        String sql = "delete from user_d where name = ?";
        qr.update(sql,name);
    }
}
