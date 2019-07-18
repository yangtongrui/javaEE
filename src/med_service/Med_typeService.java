package med_service;

import med_dao.Med_typeDao;
import med_table.med_type;

import java.sql.SQLException;
import java.util.List;

public class Med_typeService {
    public List<med_type> getAllmed_type() throws SQLException {
        Med_typeDao med_typeDao = new Med_typeDao();
        return med_typeDao.getAllMed_type();
    }
}
