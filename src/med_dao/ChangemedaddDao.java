package med_dao;

import med_table.Changemed;
import org.apache.commons.dbutils.QueryRunner;
import pool.C3P0Utils;

import java.sql.SQLException;

public class ChangemedaddDao {
    public void getChangeMedAdd(Changemed changemed) throws SQLException {
        QueryRunner qr = new QueryRunner(C3P0Utils.getDataSource());
        String sql = "insert into changemed values (?,?,?,?,?,?)";
        //cmid,cmname,cimg,cdate,credit,funtion
        qr.update(sql,changemed.getCmid(),changemed.getCmname(),changemed.getCimg(),changemed.getCdate(),changemed.getCredit(),changemed.getFunction());
    }
}
