package med_dao;

import med_table.med;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import pool.C3P0Utils;

import java.sql.SQLException;
import java.util.List;

public class U_MMedDao {
    public List<med> getAllu_mMed(int id) throws SQLException {
        QueryRunner qr = new QueryRunner(C3P0Utils.getDataSource());
        String sql = "select * from med,submit_med,user_d where med.mid = submit_med.mid and  user_d.id = submit_med.id  and user_d.id = ?";
        return qr.query(sql,new BeanListHandler<>(med.class),id);
    }
}
