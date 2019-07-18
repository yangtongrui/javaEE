package med_dao;

import org.apache.commons.dbutils.QueryRunner;
import pool.C3P0Utils;

import java.sql.SQLException;

public class ChangeMedShoppingdelDao {
    public void DelchangemedshoppingBycmsid(int cmsid) throws SQLException {
        QueryRunner qr = new QueryRunner(C3P0Utils.getDataSource());
        String sql = "delete from changemedshopping where cmsid = ?";
        qr.update(sql,cmsid);
    }
}
