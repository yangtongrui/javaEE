package med_dao;

import org.apache.commons.dbutils.QueryRunner;
import pool.C3P0Utils;

import java.sql.SQLException;

public class ChangeMeddelDao {
    public void delchangemedBycmid(String cmid) throws SQLException {
        QueryRunner qr = new QueryRunner(C3P0Utils.getDataSource());
        String sql = "delete from changemed where cmid = ?";
        qr.update(sql,cmid);
    }
}
