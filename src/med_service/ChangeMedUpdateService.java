package med_service;

import med_dao.ChangeMedUpdateDao;
import med_table.Changemed;

import java.sql.SQLException;

public class ChangeMedUpdateService {
    private ChangeMedUpdateDao changeMedUpdateDao;
    public ChangeMedUpdateService(){
        changeMedUpdateDao = new ChangeMedUpdateDao();
    }
    public void updateChangemedBycmid(Changemed changemed) throws SQLException {
        changeMedUpdateDao.updateChangemedBycmid(changemed);

    }
}
