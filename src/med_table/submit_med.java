package med_table;

public class submit_med {
     private int msid;
    private String mid;
    private int id;
    private int msnumber;
    private String date;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getMsid() {
        return msid;
    }

    public void setMsid(int msid) {
        this.msid = msid;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getMsnumber() {
        return msnumber;
    }

    public void setMsnumber(int msnumber) {
        this.msnumber = msnumber;
    }

    public submit_med(){

    }

    @Override
    public String toString() {
        return "submit_med{" +
                "msid=" + msid +
                ", mid='" + mid + '\'' +
                ", id=" + id +
                ", smnumber=" + msnumber +
                '}';
    }

    public String getMid() {
        return mid;
    }

    public int getId() {
        return id;
    }

    public void setMid(String mid) {
        this.mid = mid;
    }

}

