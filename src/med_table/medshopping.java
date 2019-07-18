package med_table;

public class medshopping {
    private int msid;
    private String mid;
    private int id;
    private int number;

    public int getMsid() {
        return msid;
    }

    public void setMsid(int msid) {
        this.msid = msid;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }


    public medshopping(){

    }

    @Override
    public String toString() {
        return "medshopping{" +
                "msid=" + msid +
                ", mid='" + mid + '\'' +
                ", id=" + id +
                ", number=" + number +
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
