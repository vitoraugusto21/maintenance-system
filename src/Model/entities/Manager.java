package Model.entities;

public class Manager extends Person{
    private String mPassword;
    public Manager(String id, String name, String phoneNumber, String email, String address, String mPassword) {
        super(id, name, phoneNumber, email, address);
        this.mPassword = mPassword;
    }

    public String getPassword() {
        return mPassword;
    }

    public void setPassword(String mPassword) {
        mPassword = mPassword;
    }
}
