package med_service;

import med_dao.ChangeMedUpdateDao;
import med_dao.ManagerUpdateDao;
import med_table.Changemed;
import med_table.user_d;

import java.sql.SQLException;

public class ManagerMedUpdateService {
    private ManagerUpdateDao managerUpdateDao;
    public ManagerMedUpdateService(){
        managerUpdateDao = new ManagerUpdateDao();
    }

    public void updateManagerByid(user_d user) throws SQLException {
        managerUpdateDao.updateManagerByid(user);
    }
}
