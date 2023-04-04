package Model.Dao;

import Model.entities.Client;

import java.util.ArrayList;
import java.util.List;

public class ClientDAOImp implements ClientDAO {


    public ClientDAOImp(){
        //Start Data Connection
    }
    public void insertClient(Client client, ArrayList clientList) {
        clientList.add(client);
    }

    public void updateClient(Client client, String atributteToChange, String newAtributte){
        Client client1 = new Client();
        if (atributteToChange == client.getId()){
            client.setId(newAtributte);
        }

        else if (atributteToChange == client.getEmail()){
            client.setEmail(newAtributte);
        }

        else if (client.atributteToChange == client.getName()){
            client.setName(newAtributte);
        }

        else if (atributteToChange == client.getPhoneNumber()){
            client.setPhoneNumber(newAtributte);
        }

        else if (atributteToChange == client.getAdress()){
            client.setAdress(newAtributte);
        }

    }

    public void deleteClient(Client client, ArrayList clientList){
        clientList.remove(client);
        //delete customer from database
    }

}
