package med_dao;

import med_table.med;
import med_table.needmed;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import pool.C3P0Utils;

import java.sql.SQLException;
import java.util.List;

public class SelectpriceByMidDao {
    QueryRunner qr  = new QueryRunner(C3P0Utils.getDataSource());
    public List<med>  selectpriceByMid(String mid) throws SQLException {

        String sql = "select * from med where mid = ?";
        return qr.query(sql, new BeanListHandler<>(med.class), mid);
    }

    public void insertNeedmed(needmed needmed) throws SQLException {
        String sql = "insert into needmed(mid) values(?)";
        qr.update(sql,needmed.getMid());
    }
}
