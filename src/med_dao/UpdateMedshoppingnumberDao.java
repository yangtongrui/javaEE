package med_dao;

import org.apache.commons.dbutils.QueryRunner;
import pool.C3P0Utils;

import java.sql.SQLException;

public class UpdateMedshoppingnumberDao {
    public void UpdateMedshoppingnumber(int msnumber) throws SQLException {
        QueryRunner qr = new QueryRunner((C3P0Utils.getDataSource()));
        String sql = "update medshopping set msnumber ? where msid = ?";
        qr.update(sql,msnumber);
    }
}
