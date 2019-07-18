package med_service;

import med_dao.ChangemedDao;
import med_table.Changemed;

import java.sql.SQLException;
import java.util.List;

public class ChangemedService {
    private ChangemedDao changemedlistDao;
    public ChangemedService(){
        changemedlistDao = new ChangemedDao();

    }

    public List<Changemed> getAllChangemed() throws SQLException {
        return changemedlistDao.getAllChangemed();

    }
}
