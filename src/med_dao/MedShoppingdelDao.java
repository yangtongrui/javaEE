package med_dao;

import org.apache.commons.dbutils.QueryRunner;
import pool.C3P0Utils;

import java.sql.SQLException;

public class MedShoppingdelDao {
    public void DelmedshoppingBymsid(int msid) throws SQLException {
        QueryRunner qr = new QueryRunner(C3P0Utils.getDataSource());
        String sql = "delete from medshopping where msid = ?";
        qr.update(sql,msid);
    }
}
