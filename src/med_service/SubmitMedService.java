package med_service;
import med_dao.SelectMedByTypeDao;
import med_dao.SelectMedShoppingDao;
import med_table.med;
import med_table.medshopping;
import med_table.submit_med;
import med_table.user_d;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class SubmitMedService {
    public void addMedSubmitShopping(double credit) {
        SelectMedShoppingDao selectMedShoppingDao = new SelectMedShoppingDao();
        try {
            List<medshopping> medshoppings;
            List<med> meds = selectMedShoppingDao.getallmed();
            medshoppings = selectMedShoppingDao.getAllMed();
            int number = 0;
            for (medshopping m : medshoppings) {
                submit_med submit_med = new submit_med();
                submit_med.setId(m.getId());
                submit_med.setMid(m.getMid());
                submit_med.setMsnumber(m.getNumber());
                submit_med.setDate(new SimpleDateFormat("yyyy-MM-dd").format(new Date().getTime()));
                selectMedShoppingDao.insertSubmitShopping(submit_med);
                user_d user = new user_d();
                user.setId(m.getId());
                user.setCredit(credit);
                selectMedShoppingDao.insertcredit(user);
                selectMedShoppingDao.updateNumer();
            }
            selectMedShoppingDao.delMedshopping();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
