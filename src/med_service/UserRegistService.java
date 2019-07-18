package med_service;

import med_dao.UserRegistDao;
import med_dao.userLoginDao;
import med_table.user_d;

import java.sql.SQLException;
import java.util.List;

public class UserRegistService {
    private UserRegistDao userRegistDao;
    public UserRegistService(){
        userRegistDao = new UserRegistDao();
    }

    public String addUser(user_d user) throws SQLException {
       return userRegistDao.insertUser(user);
    }

    public boolean register(String name) {
        boolean b = true;
        try {
            userLoginDao userLoginDao = new userLoginDao();
            List<user_d> user_dList = userLoginDao.getAlluserLogin();
            for(user_d u :user_dList){
                if(u.getName().equals(name)){
                    b = false;
                    break;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return b;
    }
}
