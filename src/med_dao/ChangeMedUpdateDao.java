package med_dao;

import med_table.Changemed;
import org.apache.commons.dbutils.QueryRunner;
import pool.C3P0Utils;

import java.sql.SQLException;

public class ChangeMedUpdateDao {
    public void updateChangemedBycmid(Changemed changemed) throws SQLException {
        QueryRunner qr = new QueryRunner(C3P0Utils.getDataSource());
       /* private String cmid;
        private String cmname;
        private String cimg;
        private double credit;
        private String cdate;
        private String function;
        private int cmsid;*/
        String sql = "update changemed set cmname = ? , credit = ? , cdate = ? , function = ?  where cmid = ?";
        qr.update(sql,changemed.getCmname(),changemed.getCredit(),changemed.getCdate(),changemed.getFunction(),changemed.getCmid());
    }
}
