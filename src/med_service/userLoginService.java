package med_service;

import med_dao.LoginDao;
import med_dao.userLoginDao;
import med_table.manager;
import med_table.user_d;

import java.sql.SQLException;
import java.util.List;

public class userLoginService {
    public String getAlluserLogin(user_d user) throws SQLException {
        userLoginDao userLoginDao = new userLoginDao();
        String res = "";
        List<user_d> managers  = userLoginDao.getAlluserLogin();
        if(managers.size()!=0){
        for(user_d m : managers) {
            if (m.getName().equals(user.getName())) {
               /* System.out.println(user.getName());*/
               /* System.out.println(name);
                System.out.println(m.getName().equals(name));*/
                if (m.getPassword().equals(user.getPassword())) {

                    /*System.out.println("user_dpassword" + user.getPassword());*/
                    //System.out.println(m.getPassword().equals(psd));
                    res = "1";
                    user.setId(m.getId());
                    user.setCredit(m.getCredit());
                }
            }
            }
        }
        return  res;
    }
}
