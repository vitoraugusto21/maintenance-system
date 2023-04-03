package Model.entities;

public class Attendant extends Person{
    private String aPassword;

    public Attendant(String id, String name, String phoneNumber, String email, String adress, String aPassword) {
        super(id, name, phoneNumber, email, adress);
        this.aPassword = aPassword;
    }

    public String getaPassword() {
        return aPassword;
    }

    public void setaPassword(String aPassword) {
        this.aPassword = aPassword;
    }
}
