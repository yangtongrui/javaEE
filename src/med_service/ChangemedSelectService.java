package med_service;

import med_dao.ChangemedSelectDao;
import med_table.Changemed;

import java.sql.SQLException;
import java.util.List;

public class ChangemedSelectService {
    private ChangemedSelectDao changemedSelectDao;
    public ChangemedSelectService(){
        changemedSelectDao = new ChangemedSelectDao();
    }

    public List<Changemed> getAllChangemed(String cmid) throws SQLException {
        return changemedSelectDao.getAllChangemed(cmid);
    }
}
