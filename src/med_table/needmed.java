package med_table;

public class needmed {
    private int id;
    private String mid;

    @Override
    public String toString() {
        return "needmed{" +
                "id=" + id +
                ", mid='" + mid + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMid() {
        return mid;
    }

    public void setMid(String mid) {
        this.mid = mid;
    }
}
