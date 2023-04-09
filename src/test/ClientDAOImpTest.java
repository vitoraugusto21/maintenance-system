import Model.entities.Client;
import org.junit.Assertions;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

public class ClientDAOImpTest {

    private ClientDAOImp clientDAO;

    @Before
    public void setUp() {
        clientDAO = new ClientDAOImp();
    }

    @Test
    public void insertClientTest() {
        Client client = new Client("1", "John Doe", "john.doe@example.com", "123-456-7890", "123 Main St");
        clientDAO.insertClient(client);
        Client retrievedClient = clientDAO.getClientById("1");
        Assertions.assertEquals(client, retrievedClient);
    }

    @Test
    public void updateClientTest() {
        Client client = new Client("1", "John Doe", "john.doe@example.com", "123-456-7890", "123 Main St");
        clientDAO.insertClient(client);
        clientDAO.updateClient(client, "name", "Jane Doe");
        Client retrievedClient = clientDAO.getClientById("1");
        Assertions.assertEquals("Jane Doe", retrievedClient.getName());
    }

    @Test
    public void deleteClientTest() {
        Client client = new Client("1", "John Doe", "john.doe@example.com", "123-456-7890", "123 Main St");
        clientDAO.insertClient(client);
        clientDAO.deleteClient(client);
        Client retrievedClient = clientDAO.getClientById("1");
        Assertions.assertNull(retrievedClient);
    }

    @Test
    public void getAllClientsTest() {
        Client client1 = new Client("1", "John Doe", "john.doe@example.com", "123-456-7890", "123 Main St");
        Client client2 = new Client("2", "Jane Doe", "jane.doe@example.com", "234-567-8901", "456 Second St");
        clientDAO.insertClient(client1);
        clientDAO.insertClient(client2);
        ArrayList<Client> clients = clientDAO.getAllClients();
        Assertions.assertTrue(clients.contains(client1));
        Assertions.assertTrue(clients.contains(client2));
    }

    @Test
    public void getClientByIdTest() {
        Client client = new Client("1", "John Doe", "john.doe@example.com", "123-456-7890", "123 Main St");
        clientDAO.insertClient(client);
        Client retrievedClient = clientDAO.getClientById("1");
        Assertions.assertEquals(client, retrievedClient);
    }
}