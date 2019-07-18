package med_dao;

import med_table.med;
import org.apache.commons.dbutils.QueryRunner;
import pool.C3P0Utils;

import java.sql.SQLException;

public class MedaddDao {

    public void getinsertMed(med med) throws SQLException {
        QueryRunner qr = new QueryRunner(C3P0Utils.getDataSource());
       // INSERT INTO med VALUES("2","ceshi","mimge/7.jsp",90,"2018-7-8",34,"ceshi",5);
        String sql = "insert into med values (?,?,?,?,?,?,?,?)";
        //手动加入mname,mimg,price,mdate,number,function,pid
         qr.update(sql,med.getMid(),med.getMname(),med.getMimg(),med.getPrice(),med.getMdate(),med.getNumber(),med.getFunction(),med.getPid());

    }
}
