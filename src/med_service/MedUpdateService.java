package med_service;

import med_dao.MedUpdateDao;
import med_table.med;

import java.sql.SQLException;

public class MedUpdateService {
    private MedUpdateDao medUpdateDao;
    public MedUpdateService(){

        medUpdateDao = new MedUpdateDao();
    }
    public void updatemedBymid(med med) throws SQLException {
        medUpdateDao.updatemedBymid(med);
    }
}
