package med_service;

import med_dao.UserdelDao;

import java.sql.SQLException;

public class UserdelService {
    private UserdelDao userdelDao;
    public UserdelService(){
        userdelDao = new UserdelDao();
    }

    public  void deluserByName(String name) throws SQLException {
        userdelDao.deluserByName(name);
    }
}
