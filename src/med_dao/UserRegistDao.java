package med_dao;

import med_table.user_d;
import org.apache.commons.dbutils.QueryRunner;
import pool.C3P0Utils;

import java.sql.SQLException;

public class UserRegistDao {
    public String insertUser(user_d user) {
        String res = "注册成功";
        try {
            QueryRunner qr = new QueryRunner(C3P0Utils.getDataSource());
            String sql = "insert into user_d(name,password,sign) values(?,?,?)";
            qr.update(sql, user.getName(), user.getPassword(), user.getSign());
        } catch (SQLException e) {
            e.printStackTrace();
            res="注册失败！";
        }

        return res;
    }
}
