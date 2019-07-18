package med_service;

import med_dao.U_MMedDao;
import med_table.med;

import java.sql.SQLException;
import java.util.List;

public class U_MMedService {
    private U_MMedDao u_mMedDao;
    public U_MMedService(){
        u_mMedDao = new U_MMedDao();
    }

    public List<med> getAllu_mMed(int id) throws SQLException {
        return u_mMedDao.getAllu_mMed(id);
    }
}
