package med_service;

import med_dao.InsertMedDao;
import med_table.med;

import java.sql.SQLException;
import java.util.List;

public class InsertMedService {
    private  InsertMedDao insertMedDao;
    public InsertMedService(){
        insertMedDao = new InsertMedDao();
    }

    public List<med> insertmedByMid(String mid) throws SQLException {
        return insertMedDao.insertmedByMid(mid);

    }
}
