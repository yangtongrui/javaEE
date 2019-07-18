package med_dao;

import med_table.med;
import med_table.needmed;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import pool.C3P0Utils;

import java.sql.SQLException;
import java.util.List;

public class NeedmedlistDao {
    public List<med> Selectneedmed() throws SQLException {
        QueryRunner qr = new QueryRunner(C3P0Utils.getDataSource());
        String sql = "select * from med,needmed where med.mid = needmed.mid";
        return qr.query(sql,new BeanListHandler<>(med.class));

    }
}
