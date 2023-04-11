package Model.entities;

public class Technician extends  Person{
    private String tPassword;
    private Os os;

    public Technician() {
    }

    public Technician(String id, String name, String phoneNumber, String email, String adress, String tPassword) {
        super(id, name, phoneNumber, email, adress);
        this.tPassword = tPassword;
    }

    public Technician(String id, String name, String phoneNumber, String email, String adress, String tPassword, Os os) {
        super(id, name, phoneNumber, email, adress);
        this.tPassword = tPassword;
        this.os = os;
    }

    public String gettPassword() {
        return tPassword;
    }

    public void settPassword(String tPassword) {
        this.tPassword = tPassword;
    }

    public Os getOs() {
        return os;
    }

    public void setOs(Os os) {
        this.os = os;
    }

    @Override
    public String toString() {
        return  "Technician{" +
                "tPassword='" + tPassword + '\'' +
                '}';
    }
}
