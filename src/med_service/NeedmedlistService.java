package med_service;

import med_dao.NeedmedlistDao;
import med_table.med;
import med_table.needmed;

import java.sql.SQLException;
import java.util.List;

public class NeedmedlistService {
    private NeedmedlistDao needmedlistDao;
    public NeedmedlistService(){
        needmedlistDao = new NeedmedlistDao();
    }

    public List<med> Selectneedmed() throws SQLException {
       return needmedlistDao.Selectneedmed();
    }
}
