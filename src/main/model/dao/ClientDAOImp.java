package main.model.dao;

import main.model.entities.Client;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class ClientDAOImp implements ClientDAO {

    public ClientDAOImp(){};
    private final Map<String, Client> clients = new HashMap<>();

    /**
     * Insere um novo Cliente no banco de dados.
     * @param client o Cliente a ser inserido.
     */
    @Override
    public void insertClient(Client client) {
        clients.put(client.getId(), client);
    }

    /**
     * Atualiza as informações de um Cliente no banco de dados.
     * @param client - o Cliente a ser atualizado.
     * @param attributeToChange - o atributo a ser alterado.
     * @param newAttribute - o novo valor do atributo.
     */
    @Override
    public void updateClient(Client client, String attributeToChange, String newAttribute) {
        switch (attributeToChange.toLowerCase()) {
            case "name" -> client.setName(newAttribute);
            case "email" -> client.setEmail(newAttribute);
            case "phonenumber" -> client.setPhoneNumber(newAttribute);
            case "address" -> client.setAddress(newAttribute);
            default -> throw new IllegalArgumentException("Invalid attribute name");
        }
        clients.put(client.getId(), client);
    }

    /**
     * Exclui um Cliente do banco de dados.
     * @param client - o Cliente a ser excluído.
     */
    @Override
    public void deleteClient(Client client) {
        clients.remove(client.getId());
    }

    /**
     * Obtém todos os Clientes cadastrados no banco de dados.
     * @return - uma lista de todos os Clientes.
     */
    @Override
    public ArrayList<Client> getAllClients() {
        return new ArrayList<>(clients.values());
    }

    /**
     * Obtém um Cliente específico do banco de dados a partir de seu ID.
     * @param id - o ID do Cliente a ser buscado.
     * @return - o Cliente correspondente ao ID especificado.
     */
    @Override
    public Client getClientById(String id) {
        return clients.get(id);
    }
}
