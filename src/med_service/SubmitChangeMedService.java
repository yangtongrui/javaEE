package med_service;

import med_dao.SelectChanegeMedShoppingDao;
import med_dao.SelectMedShoppingDao;
import med_table.*;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class SubmitChangeMedService {
    public void addChangeMedSubmitShopping(double credit) {
        SelectChanegeMedShoppingDao selectChanegeMedShoppingDao = new SelectChanegeMedShoppingDao();
        try {
            List<changemedshopping> medshoppings = selectChanegeMedShoppingDao.getAllChangeMed();
            for (changemedshopping m : medshoppings) {
                submit_changemed submit_changemed = new submit_changemed();
                submit_changemed.setId(m.getId());
                submit_changemed.setCmid(m.getCmid());
                submit_changemed.setDate(new SimpleDateFormat("yyyy-MM-dd").format(new Date().getTime()));
                selectChanegeMedShoppingDao.insertSubmitShopping(submit_changemed);
                selectChanegeMedShoppingDao.delChangemed(m.getCmid());
                user_d user = new user_d();
                user.setId(m.getId());
                user.setCredit(credit);
                selectChanegeMedShoppingDao.insertcredit(user);
            }
            selectChanegeMedShoppingDao.delChangeMedshopping();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
