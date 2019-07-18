package med_service;

import med_dao.SelectpriceByMidDao;
import med_table.med;
import med_table.needmed;

import java.sql.SQLException;
import java.util.List;

public class SelectpriceByMidService {
    private SelectpriceByMidDao selectpriceByMidDao;
    public SelectpriceByMidService(){
        selectpriceByMidDao = new SelectpriceByMidDao();
    }

    public String selectpriceByMid(String mid, int number) throws SQLException {
        String res = "";
        /*System.out.println(number);*/
        List<med> medList = selectpriceByMidDao.selectpriceByMid(mid);
        needmed needmed = new needmed();
        for(med m:medList){
           /* System.out.println("med"+m.getNumber());
            System.out.println("number"+number);*/
            if(m.getNumber()>=number){
                res = "1";
            }else {
                res = "0";
                needmed.setMid(m.getMid());
                selectpriceByMidDao.insertNeedmed(needmed);

            }
        }
        return res;
    }
}
