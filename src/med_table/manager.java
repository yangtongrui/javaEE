package med_table;

public class manager {
    private String name;
    private String password;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "manager{" +
                "name='" + name + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    public manager(String name, String password) {
        this.name = name;
        this.password = password;
    }

    public manager(){

    }
}
