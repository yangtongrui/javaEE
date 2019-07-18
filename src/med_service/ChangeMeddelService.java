package med_service;

import med_dao.ChangeMeddelDao;

import java.sql.SQLException;

public class ChangeMeddelService {
    private ChangeMeddelDao changeMeddelDao;
    public ChangeMeddelService(){
        changeMeddelDao = new ChangeMeddelDao();
    }

    public void delchangemedBycmid(String cmid) throws SQLException {
        changeMeddelDao.delchangemedBycmid(cmid);
    }
}
