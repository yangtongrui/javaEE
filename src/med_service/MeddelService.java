package med_service;

import med_dao.MeddelDao;

import java.sql.SQLException;

public class MeddelService {
    private MeddelDao meddelDao;
    public MeddelService(){
        meddelDao = new MeddelDao();

    }

    public void delmedByMid(String mid) throws SQLException {
        meddelDao.delmedByMid(mid);
    }
}
