package med_service;

import med_dao.SelectMedByTypeDao;
import med_table.med;

import java.sql.SQLException;
import java.util.List;

public class SelectMedByTypeService {
    private SelectMedByTypeDao selectMedByTypeDao;
    public SelectMedByTypeService(){
        selectMedByTypeDao = new SelectMedByTypeDao();

    }

    public List<med> getAllMedByType(String pid) throws SQLException {
        return selectMedByTypeDao.getAllMedType(pid);
    }
}
