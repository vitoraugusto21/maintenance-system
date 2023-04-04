package Model.Dao;

import Model.entities.Client;

import java.util.ArrayList;

public interface ClientDAO {

    //para ser considerado crud, é necessário todos esses métodos.
    void insertClient(Client client);
    void updateClient(Client client);
    void deleteClient(Client client);
    ArrayList<Client> getAllClients();
    Client getClientById(String id);
}