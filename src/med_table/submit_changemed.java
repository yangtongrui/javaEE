package med_table;

public class submit_changemed {
    private int cmsid;
    private String cmid;
    private int id;
    private String date;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "submit_changemed{" +
                "cmsid=" + cmsid +
                ", cmid='" + cmid + '\'' +
                ", id=" + id +
                '}';
    }
    public submit_changemed(){

    }

    public int getCmsid() {
        return cmsid;
    }

    public void setCmsid(int cmsid) {
        this.cmsid = cmsid;
    }

    public String getCmid() {
        return cmid;
    }

    public void setCmid(String cmid) {
        this.cmid = cmid;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

}
