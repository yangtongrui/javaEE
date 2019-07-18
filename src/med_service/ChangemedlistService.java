package med_service;

import med_dao.ChangemedlistDao;
import med_table.Changemed;

import java.sql.SQLException;
import java.util.List;

public class ChangemedlistService {
    private ChangemedlistDao changemedlistDao;
    public ChangemedlistService(){
         changemedlistDao = new ChangemedlistDao();
    }
    public List<Changemed> getAllchangemed() throws SQLException {
       return changemedlistDao.getchangemedlist();
    }
}
