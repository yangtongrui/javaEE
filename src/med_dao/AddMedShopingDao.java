package med_dao;

import med_table.medshopping;
import org.apache.commons.dbutils.QueryRunner;
import pool.C3P0Utils;

import java.sql.SQLException;

public class AddMedShopingDao {
    public void AddMedShopping(medshopping medshopping) throws SQLException {
        QueryRunner qr = new QueryRunner(C3P0Utils.getDataSource());
        String sql = "insert into medshopping(id,mid,msnumber) values (?,?,?)";
        qr.update(sql,medshopping.getId(),medshopping.getMid(),medshopping.getNumber());
    }
}
