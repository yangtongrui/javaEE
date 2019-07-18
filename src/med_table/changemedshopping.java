package med_table;

public class changemedshopping {
    private int cmsid;
    private String cmid;
    private int id;

    public changemedshopping(){

    }
    @Override
    public String toString() {
        return "changemedshopping{" +
                "cmsid=" + cmsid +
                ", cmid='" + cmid + '\'' +
                ", id=" + id +
                '}';
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
