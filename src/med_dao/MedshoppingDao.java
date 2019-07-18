package med_dao;

import med_table.med;
import med_table.medshopping;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import pool.C3P0Utils;

import java.sql.SQLException;
import java.util.List;

public class MedshoppingDao {
    QueryRunner qr = new QueryRunner((C3P0Utils.getDataSource()));
    public List<med> getAllMed() throws SQLException {
        String sql = "select * from med,medshopping where med.mid = medshopping.mid";
        return qr.query(sql,new BeanListHandler<>(med.class));
    }
    public List<medshopping> selectMedshopping() throws SQLException {
        String sql = "select * from medshopping where msid = ?";
        return qr.query(sql,new BeanListHandler<>(medshopping.class));
    }
}
