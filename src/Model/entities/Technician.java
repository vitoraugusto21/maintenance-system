package Model.entities;

public class Technician extends  Person{
    private String tPassword;

    public Technician(String id, String name, String phoneNumber, String email, String adress, String tPassword) {
        super(id, name, phoneNumber, email, adress);
        this.tPassword = tPassword;
    }

    public String gettPassword() {
        return tPassword;
    }

    public void settPassword(String tPassword) {
        this.tPassword = tPassword;
    }

    @Override
    public String toString() {
        return  "Technician{" +
                "tPassword='" + tPassword + '\'' +
                '}';
    }
}
