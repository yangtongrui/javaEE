package med_service;

import med_dao.InsertMedDao;
import med_dao.SelectNeedMedDao;
import med_table.med;

import java.sql.SQLException;
import java.util.List;

public class SelectNeedMedService {
    private SelectNeedMedDao selectNeedMedDao;
    public SelectNeedMedService(){
        selectNeedMedDao = new SelectNeedMedDao();
    }

    public List<med> selectneedmedByMid(String mid) throws SQLException {
        return selectNeedMedDao.insertmedByMid(mid);
    }
}
