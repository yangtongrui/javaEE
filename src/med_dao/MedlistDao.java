package med_dao;

import med_table.med;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import pool.C3P0Utils;

import java.sql.SQLException;
import java.util.List;

public class MedlistDao {

    public List<med> getAllmed() throws SQLException {
        QueryRunner qr = new QueryRunner(C3P0Utils.getDataSource());
        String sql = "select * from med";
        List<med>medList = qr.query(sql,new BeanListHandler<>(med.class));
        return medList;
    }
}
