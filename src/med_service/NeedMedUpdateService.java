package med_service;

import med_dao.MedUpdateDao;
import med_dao.NeedMedUpdateDao;
import med_table.med;

import java.sql.SQLException;

public class NeedMedUpdateService {
    private NeedMedUpdateDao needMedUpdateDao;
    public NeedMedUpdateService(){

        needMedUpdateDao = new NeedMedUpdateDao();
    }
    public void updatemedBymid(med med) throws SQLException {
        needMedUpdateDao.updatemedBymid(med);
    }
}