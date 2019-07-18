package med_dao;

import med_table.user_d;
import org.apache.commons.dbutils.QueryRunner;
import pool.C3P0Utils;

import java.sql.SQLException;

public class ManagerUpdateDao {
    public void updateManagerByid(user_d user) throws SQLException {
        QueryRunner qr = new QueryRunner(C3P0Utils.getDataSource());
        String sql = "update user_d set sign = ? where id = ?";
        qr.update(sql,user.getSign(),user.getId());
    }
}
