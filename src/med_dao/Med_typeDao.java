package med_dao;

import med_table.med_type;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import pool.C3P0Utils;

import java.sql.SQLException;
import java.util.List;

public class Med_typeDao {
    public List<med_type> getAllMed_type() throws SQLException {
        QueryRunner qr = new QueryRunner(C3P0Utils.getDataSource());
        String sql = "select * from med_type";
        return qr.query(sql,new BeanListHandler<>(med_type.class));

    }
}
