package med_dao;

import med_table.changemedshopping;
import org.apache.commons.dbutils.QueryRunner;
import pool.C3P0Utils;

import java.sql.SQLException;

public class AddChangeMedShopingDao {
    public void AddChangeMedShopping(changemedshopping changemedshopping) throws SQLException {
        QueryRunner qr = new QueryRunner(C3P0Utils.getDataSource());
        String sql = "insert into changemedshopping(id,cmid) values (?,?)";
        qr.update(sql,changemedshopping.getId(),changemedshopping.getCmid());
    }
}
