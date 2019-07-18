package med_dao;

import org.apache.commons.dbutils.QueryRunner;
import pool.C3P0Utils;

import java.sql.SQLException;

public class NeedMeddelDao {
    public void delneedmedByMid(String mid) throws SQLException {
        QueryRunner qr = new QueryRunner(C3P0Utils.getDataSource());
        String sql = "delete from needmed where mid = ?";
        qr.update(sql,mid);
    }
}
