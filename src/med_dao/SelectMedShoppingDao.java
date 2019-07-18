package med_dao;

import med_table.med;
import med_table.medshopping;
import med_table.submit_med;
import med_table.user_d;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import pool.C3P0Utils;

import java.sql.SQLException;
import java.util.List;

public class SelectMedShoppingDao {
    QueryRunner qr = new QueryRunner((C3P0Utils.getDataSource()));
    public List<medshopping> getAllMed() throws SQLException {
        String sql = "select * from medshopping";
        return qr.query(sql,new BeanListHandler<>(medshopping.class));
    }
    public void insertSubmitShopping(submit_med medshopping) throws SQLException {
        String sql = "insert into submit_med (id,mid,msnumber,date) values (?,?,?,?)";
        qr.update(sql,medshopping.getId(),medshopping.getMid(),medshopping.getMsnumber(),medshopping.getDate());
    }
    public void delMedshopping() throws SQLException {
        String sql = "delete from medshopping";
        qr.update(sql);
    }

    public void insertcredit(user_d user) throws SQLException {
        String sql = " update user_d set credit = ? where id = ?";
        qr.update(sql,user.getCredit(),user.getId());
    }

    public List<med> getallmed() throws SQLException {
        String sql = "select * from med";
        return qr.query(sql,new BeanListHandler<>(med.class));
    }

    public void updateNumer() throws SQLException {
        String sql = "update med,medshopping set med.number = med.number - medshopping.msnumber where med.mid = medshopping.mid";
        qr.update(sql);
    }
}
