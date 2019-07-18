package med_service;

import med_dao.ChangeMedshoppingDao;
import med_table.Changemed;

import java.sql.SQLException;
import java.util.List;

public class ChangeMedshoppingService {
    private ChangeMedshoppingDao changeMedshoppingDao;
    public ChangeMedshoppingService(){
        changeMedshoppingDao = new ChangeMedshoppingDao();
    }
    public List<Changemed> getAllchangeMed() throws SQLException {
        return changeMedshoppingDao.getAllchangeMed();
    }
}
