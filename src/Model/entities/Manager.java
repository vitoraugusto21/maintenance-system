package Model.entities;

public class Manager extends Person{
    private String mPassword;
    public Manager(String id, String name, String phoneNumber, String email, String adress, String Mpassword) {
        super(id, name, phoneNumber, email, adress);
        mPassword = mPassword;
    }

    public String getPassword() {
        return mPassword;
    }

    public void setPassword(String mPassword) {
        mPassword = mPassword;
    }
}
