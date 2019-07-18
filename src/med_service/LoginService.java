package med_service;

import med_dao.LoginDao;
import med_table.manager;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class LoginService {

    public String getAllLogin(String name,String psd) throws SQLException {
        LoginDao loginDao = new LoginDao();
        String res = "";
        List<manager> managers  = loginDao.getAlllogin();
        for(manager m : managers){
            if (m.getName().equals(name)) {
               /* System.out.println(name);
                System.out.println(m.getName().equals(name));*/
                if (m.getPassword().equals(psd)) {
                    //System.out.println(m.getPassword().equals(psd));
                    res = "1";
                }
            }
        }
        return  res;
    }
}
