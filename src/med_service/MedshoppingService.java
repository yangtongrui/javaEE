package med_service;

import med_controller.MedshoppingServlet;
import med_dao.MedshoppingDao;
import med_table.med;

import java.sql.SQLException;
import java.util.List;

public class MedshoppingService {
    private MedshoppingDao medshoppingDao;
    public MedshoppingService(){
        medshoppingDao = new MedshoppingDao();
    }

    public List<med> getAllMed() throws SQLException {
       return medshoppingDao.getAllMed();
    }
}
