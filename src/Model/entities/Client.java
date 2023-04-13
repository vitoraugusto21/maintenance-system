package Model.entities;

import Model.Dao.ClientDAO;

import java.util.ArrayList;
import java.util.List;

public  class Client extends Person{

    private ArrayList<Os> clientOs; //lista de ordens de serviços dos clientes

    public Client() {
    }

    public Client(String id, String name, String phoneNumber, String email, String adress) {
        super(id, name, phoneNumber, email, adress);
    }

    public Client(String id, String name, String phoneNumber, String email, String adress, ArrayList<Os> clientOs) {
        super(id, name, phoneNumber, email, adress);
        this.clientOs = clientOs;
    }

    public ArrayList<Os> getClientOs() {
        return clientOs;
    }

    public void setClientOs(ArrayList<Os> clientOs) {
        this.clientOs = clientOs;
    }




}
