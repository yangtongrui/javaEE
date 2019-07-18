package med_dao;

import med_table.Changemed;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import pool.C3P0Utils;

import java.sql.SQLException;
import java.util.List;

public class U_MChangeMedDao {
    public List<Changemed> getAllu_cmMed(int id) throws SQLException {
        QueryRunner qr = new QueryRunner(C3P0Utils.getDataSource());
        String sql = "select * from changemed,submit_changemed,user_d where changemed.cmid = submit_changemed.cmid and  user_d.id = submit_changemed.id  and user_d.id = ?";
        return qr.query(sql,new BeanListHandler<>(Changemed.class),id);
    }
}
