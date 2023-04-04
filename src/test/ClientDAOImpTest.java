import org.junit.Test;
import java.util.ArrayList;
import static org.junit.Assert.*;

package test;

public class ClientDAOImpTest() {
    @Test
    public void testInsertClient() {
        Client client = new Client("João", "joao@gmail.com", "123456789", "Rua A, 123");
        ArrayList<Client> clientList = new ArrayList<>();
        ClientDAOImp dao = new ClientDAOImp();
        dao.insertClient(client, clientList);
        assertEquals(1, clientList.size());
    }

    @Test
    public void testUpdateClient() {
        Client client = new Client("João", "joao@gmail.com", "123456789", "Rua A, 123");
        ArrayList<Client> clientList = new ArrayList<>();
        clientList.add(client);
        ClientDAOImp dao = new ClientDAOImp();
        dao.updateClient(client, "name", "Maria");
        assertEquals("Maria", client.getName());
    }

    @Test
    public void testDeleteClient() {
        Client client = new Client("João", "joao@gmail.com", "123456789", "Rua A, 123");
        ArrayList<Client> clientList = new ArrayList<>();
        clientList.add(client);
        ClientDAOImp dao = new ClientDAOImp();
        dao.deleteClient(client, clientList);
        assertEquals(0, clientList.size());
    }

}
