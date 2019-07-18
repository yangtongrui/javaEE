package med_service;

import med_dao.MedShoppingdelDao;

import java.sql.SQLException;

public class MedShoppingdelService {
    private MedShoppingdelDao medShoppingdelDao;
    public MedShoppingdelService(){
        medShoppingdelDao = new MedShoppingdelDao();
    }

    public void DelmedshoppingBymsid(int msid) throws SQLException {
        medShoppingdelDao.DelmedshoppingBymsid(msid);
        /*System.out.println("msid="+msid);*/
    }
}
