package main.model.dao;

import main.model.entities.Client;

import java.util.ArrayList;

/**
 * Interface responsável por definir as operações de acesso aos dados de Cliente no banco de dados.
 */
public interface ClientDAO {

    //para ser considerado crud, é necessário todos esses métodos.
    void insertClient(Client client);

    void updateClient(Client client, String attributeToChange, String newAttribute);

    void deleteClient(Client client);

    ArrayList<Client> getAllClients();

    Client getClientById(String id);
}
