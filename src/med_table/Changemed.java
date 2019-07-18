package med_table;

import javax.xml.crypto.Data;

public class Changemed {
    private String cmid;
    private String cmname;
    private String cimg;
    private double credit;
    private String cdate;
    private String function;
    private int cmsid;

    public int getCmsid() {
        return cmsid;
    }

    public void setCmsid(int cmsid) {
        this.cmsid = cmsid;
    }

    @Override
    public String toString() {
        return "changemed{" +
                "cmid='" + cmid + '\'' +
                ", cmname='" + cmname + '\'' +
                ", credit=" + credit +
                ", function='" + function + '\'' +
                '}';
    }

    public Changemed(){

    }
    public Changemed(String cmid, String cmname, double credit, String function) {
        this.cmid = cmid;
        this.cmname = cmname;
        this.credit = credit;
        this.function = function;
    }

    public String getCimg() {
        return cimg;
    }

    public void setCimg(String cimg) {
        this.cimg = cimg;
    }

    public String getCdate() {
        return cdate;
    }

    public void setCdate(String cdate) {
        this.cdate = cdate;
    }

    public String getCmid() {
        return cmid;
    }

    public void setCmid(String cmid) {
        this.cmid = cmid;
    }

    public String getCmname() {
        return cmname;
    }

    public void setCmname(String cmname) {
        this.cmname = cmname;
    }

    public double getCredit() {
        return credit;
    }

    public void setCredit(double credit) {
        this.credit = credit;
    }

    public String getFunction() {
        return function;
    }

    public void setFunction(String function) {
        this.function = function;
    }
}
