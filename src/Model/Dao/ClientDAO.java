package Model.Dao;

import Model.entities.Client;

import java.util.ArrayList;

public interface ClientDAO {

    void insertClient(Client client, ArrayList clientList);
    void updateClient(Client client, String atributteToChange, String newAtributte);
    void deleteClient(Client client, ArrayList clientList);
}
