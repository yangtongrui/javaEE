package med_table;

import javax.xml.crypto.Data;
import java.io.Serializable;

public class med  implements Serializable{


    private String mid;
    private String mname;
    private double price;
    private  int number;
    private String function;
    private String mimg;
    private String mdate;
    private String pid;
    private int msid;
    private int msnumber;
    public int getMsnumber() {
        return msnumber;
    }

    public void setMsnumber(int msnumber) {
        this.msnumber = msnumber;
    }

    public int getMsid() {
        return msid;
    }

    public void setMsid(int msid) {
        this.msid = msid;
    }

    @Override
    public String toString() {
        return "med{" +
                "mid='" + mid + '\'' +
                ", mname='" + mname + '\'' +
                ", price=" + price +
                ", number=" + number +
                ", function='" + function + '\'' +
                ", mimg='" + mimg + '\'' +
                ", mdate='" + mdate + '\'' +
                ", pid='" + pid + '\'' +
                '}';
    }

    public String getMid() {
        return mid;
    }

    public void setMid(String mid) {
        this.mid = mid;
    }

    public String getMname() {
        return mname;
    }

    public void setMname(String mname) {
        this.mname = mname;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getFunction() {
        return function;
    }

    public void setFunction(String function) {
        this.function = function;
    }

    public String getMimg() {
        return mimg;
    }

    public void setMimg(String mimg) {
        this.mimg = mimg;
    }

    public String getMdate() {
        return mdate;
    }

    public void setMdate(String mdate) {
        this.mdate = mdate;
    }

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }
}
