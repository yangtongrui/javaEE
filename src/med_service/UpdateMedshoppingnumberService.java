package med_service;

import med_dao.MedshoppingDao;
import med_dao.UpdateMedshoppingnumberDao;
import med_table.medshopping;

import java.sql.SQLException;
import java.util.List;

public class UpdateMedshoppingnumberService {
    MedshoppingDao medshoppingDao = new MedshoppingDao();
    UpdateMedshoppingnumberDao updateMedshoppingnumberDao = new UpdateMedshoppingnumberDao();
    public String UpdateMedshoppingnumber(int msnumber) throws SQLException {
        List<medshopping> medshoppings = medshoppingDao.selectMedshopping();
        String res = "";
        for(medshopping m :medshoppings)
        {
            if(m.getNumber() >= msnumber){
                updateMedshoppingnumberDao.UpdateMedshoppingnumber(msnumber);
                res = "修改成功";
            }else {
                res = "修改失败";
            }
        }
        return res;
    }
}
