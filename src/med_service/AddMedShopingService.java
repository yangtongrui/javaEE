package med_service;

import med_dao.AddMedShopingDao;
import med_table.med;
import med_table.medshopping;

import java.sql.SQLException;
import java.util.List;

public class AddMedShopingService {
    private AddMedShopingDao addMedShopingDao;
    public AddMedShopingService(){
        addMedShopingDao = new AddMedShopingDao();
        
    }

    public void AddMedShopping(medshopping medshopping) throws SQLException {
        addMedShopingDao.AddMedShopping(medshopping);
        /* System.out.println(medshopping.toString());*/
    }
}
