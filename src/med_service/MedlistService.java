package med_service;

import med_dao.MedlistDao;
import med_table.med;

import java.sql.SQLException;
import java.util.List;

public class MedlistService {
    private MedlistDao medlistDao;
    public MedlistService(){
        medlistDao = new MedlistDao();

    }

    public List<med> getAllmed() throws SQLException {
        return medlistDao.getAllmed();
    }
}
