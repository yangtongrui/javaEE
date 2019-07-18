package med_dao;

import med_table.*;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import pool.C3P0Utils;

import java.sql.SQLException;
import java.util.List;

public class SelectChanegeMedShoppingDao {
    QueryRunner qr = new QueryRunner((C3P0Utils.getDataSource()));
    public List<changemedshopping> getAllChangeMed() throws SQLException {
        String sql = "select * from changemedshopping";
        return qr.query(sql,new BeanListHandler<>(changemedshopping.class));
    }
    public void insertSubmitShopping(submit_changemed changemedshopping) throws SQLException {
        String sql = "insert into submit_changemed (id,cmid) values (?,?)";
        qr.update(sql,changemedshopping.getId(),changemedshopping.getCmid());
    }
    public void delChangeMedshopping() throws SQLException {
        String sql = "delete from changemedshopping";
        qr.update(sql);
    }

    public void delChangemed(String cmid) {
        String sql = "delete from changemed where cmid = ?";
    }

    public void insertcredit(user_d user) throws SQLException {
       String sql = " update user_d set credit = ? where id = ?";
       qr.update(sql,user.getCredit(),user.getId());
    }
}
