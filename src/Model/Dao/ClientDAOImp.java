package Model.Dao;

import Model.entities.Client;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ClientDAOImpl implements ClientDAO {

    private final Map<String, Client> clients = new HashMap<>();

    @Override
    public void insertClient(Client client) {
        clients.put(client.getId(), client);
    }

    @Override
    public void updateClient(Client client, String attributeToChange, String newAttribute) {
        switch (attributeToChange.toLowerCase()) {
            case "name" -> client.setName(newAttribute);
            case "email" -> client.setEmail(newAttribute);
            case "phone" -> client.setPhone(newAttribute);
            default -> throw new IllegalArgumentException("Invalid attribute name");
        }
        clients.put(client.getId(), client);
    }

    @Override
    public void deleteClient(Client client) {
        clients.remove(client.getId());
    }

    @Override
    public ArrayList<Client> getAllClients() {
        return new ArrayList<>(clients.values());
    }

    @Override
    public Client getClientById(String id) {
        return clients.get(id);
    }
}
