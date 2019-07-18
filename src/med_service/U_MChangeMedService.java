package med_service;

import med_dao.U_MChangeMedDao;
import med_table.Changemed;

import java.sql.SQLException;
import java.util.List;

public class U_MChangeMedService {
    private U_MChangeMedDao u_mChangeMedDao;
    public U_MChangeMedService(){
        u_mChangeMedDao = new U_MChangeMedDao();
    }

    public List<Changemed> getAllu_cmMed(int id) throws SQLException {
        return u_mChangeMedDao.getAllu_cmMed(id);
    }
}
