package med_service;

import med_dao.AddChangeMedShopingDao;
import med_table.changemedshopping;

import java.sql.SQLException;

public class AddChangeMedShopingService {
    private AddChangeMedShopingDao addChangeMedShopingDao;
    public AddChangeMedShopingService(){
        addChangeMedShopingDao = new AddChangeMedShopingDao();
    }

    public void AddChangeMedShopping(changemedshopping changemedshopping) throws SQLException {
        addChangeMedShopingDao.AddChangeMedShopping(changemedshopping);
       /* System.out.println(changemedshopping.toString());*/
    }
}
