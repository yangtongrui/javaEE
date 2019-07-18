package med_service;

import med_dao.NeedMeddelDao;

import java.sql.SQLException;

public class NeedMeddelService {
    private NeedMeddelDao needMeddelDao;
    public NeedMeddelService(){
        needMeddelDao = new NeedMeddelDao();
    }

    public void delneedmedByMid(String mid) throws SQLException {
        needMeddelDao.delneedmedByMid(mid);
    }
}
