package med_service;

import med_dao.ChangemedaddDao;
import med_table.Changemed;

import java.sql.SQLException;

public class ChangeMedaddService {
    private ChangemedaddDao changemedaddDao;
    public ChangeMedaddService(){
        changemedaddDao = new ChangemedaddDao();
    }

    public void getChangeMedAdd(Changemed changemed) throws SQLException {
        changemedaddDao.getChangeMedAdd(changemed);
    }
}
