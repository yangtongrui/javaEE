package med_service;

import med_dao.ChangeMedShoppingdelDao;

import java.sql.SQLException;

public class ChangeMedShoppingdelService {
    private ChangeMedShoppingdelDao changeMedShoppingdelDao;
    public ChangeMedShoppingdelService(){
        changeMedShoppingdelDao = new ChangeMedShoppingdelDao();
    }

    public void DelchangemedshoppingBycmsid(int cmsid) throws SQLException {
        changeMedShoppingdelDao.DelchangemedshoppingBycmsid(cmsid);
    }
}
