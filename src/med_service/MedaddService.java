package med_service;

import med_dao.MedaddDao;
import med_table.med;

import java.sql.SQLException;
import java.util.List;

public class MedaddService {
    private MedaddDao medaddDao;
    public MedaddService(){
        medaddDao = new MedaddDao();
    }

    public void getinsertMed(med med ) throws SQLException {
        medaddDao.getinsertMed(med);
    }
}
