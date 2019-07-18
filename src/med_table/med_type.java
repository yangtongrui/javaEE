package med_table;

import java.io.Serializable;

public class med_type  implements Serializable{
    private String pid;
    private String pname;

    public med_type(){

    }
    public med_type(String pid, String pname) {
        this.pid = pid;
        this.pname = pname;
    }

    @Override
    public String toString() {
        return "med_type{" +
                "pid='" + pid + '\'' +
                ", pname='" + pname + '\'' +
                '}';
    }

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }
}
