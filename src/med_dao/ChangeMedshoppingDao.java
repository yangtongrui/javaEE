package med_dao;

import med_table.Changemed;
import med_table.med;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import pool.C3P0Utils;

import java.sql.SQLException;
import java.util.List;

public class ChangeMedshoppingDao {
    public List<Changemed> getAllchangeMed() throws SQLException {
        QueryRunner qr = new QueryRunner((C3P0Utils.getDataSource()));
        String sql = "select * from changemed,changemedshopping where changemed.cmid = changemedshopping.cmid";
        return qr.query(sql,new BeanListHandler<>(Changemed.class));
    }
}
