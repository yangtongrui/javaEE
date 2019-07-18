package med_service;

import med_dao.ManagerListDao;
import med_table.manager;
import med_table.user_d;

import java.sql.SQLException;
import java.util.List;

public class ManagerListService {
    private  ManagerListDao managerListDao;
    public ManagerListService(){
        managerListDao = new ManagerListDao();

    }

    public List<user_d> getAllmanager() throws SQLException {
      /* List<manager> list = managerListDao.getAllmanager();
       for(manager m: list){
           System.out.println(m.getName());
           System.out.println(m.getPassword());
       }*/
        return managerListDao.getAllmanager();
    }
}