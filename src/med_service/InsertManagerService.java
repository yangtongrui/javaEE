package med_service;

import med_dao.InsertManagerDao;
import med_table.user_d;

import java.sql.SQLException;
import java.util.List;

public class InsertManagerService {
    private InsertManagerDao insertManagerDao;
    public InsertManagerService(){
        insertManagerDao = new InsertManagerDao();
    }

    public List<user_d> getAllManager(int id) throws SQLException {
        return insertManagerDao.getAllManager(id);
    }
}
