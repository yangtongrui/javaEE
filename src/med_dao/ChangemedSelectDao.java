package med_dao;

import med_table.Changemed;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import pool.C3P0Utils;

import java.sql.SQLException;
import java.util.List;

public class ChangemedSelectDao {
    public List<Changemed> getAllChangemed(String cmid) throws SQLException {
        QueryRunner qr = new QueryRunner(C3P0Utils.getDataSource());
        String sql ="select * from changemed where cmid = ?";
        return qr.query(sql,new BeanListHandler<>(Changemed.class),cmid);
    }
}
