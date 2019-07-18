package med_dao;

import med_table.med;
import org.apache.commons.dbutils.QueryRunner;
import pool.C3P0Utils;

import java.sql.SQLException;

public class MedUpdateDao {
    public void updatemedBymid(med med) throws SQLException {
        QueryRunner qr = new QueryRunner(C3P0Utils.getDataSource());
       /* private String mid;
        private String mname;
        private double price;
        private  int number;
        private String function;
        private String mimg;
        private String mdate;
        private String pid;
        private int msid;
        private int msnumber;*/
        String sql = "update med set mname = ? , price = ? , number = ? , function = ? , mdate = ? where mid = ?";
        qr.update(sql,med.getMname(),med.getPrice(),med.getNumber(),med.getFunction(),med.getMdate(),med.getMid());
    }
}
