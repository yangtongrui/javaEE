package med_dao;

import med_table.med;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import pool.C3P0Utils;

import java.sql.SQLException;
import java.util.List;

public class InsertMedDao {
    public List<med> insertmedByMid(String mid) throws SQLException {
        QueryRunner qr = new QueryRunner(C3P0Utils.getDataSource());
        String sql = "select * from med where mid = ?";
        return qr.query(sql,new BeanListHandler<>(med.class),mid);
    }
}
