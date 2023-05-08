package model.dao;

import model.entities.Client;
import org.junit.jupiter.api.*;

import java.io.IOException;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class ClientDAOImpTest {

    ClientDAOImp dao = new ClientDAOImp();
    Client client = new Client("123456789", "Lucas", "(11)9999-8888", "lucas@test.com", "Rua A, 123", new ArrayList<>());

    @BeforeEach
    void setUp() {
        try {
            dao.createClient(client);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @AfterEach
    void tearDown() {
        try {
            dao.deleteClient(client);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    void testCreateClient() {
        Client createdClient = null;
        try {
            createdClient = dao.getClientById("123456789");
        } catch (IOException e) {
            e.printStackTrace();
        }
        assertEquals(client, createdClient);
    }

    @Test
    void testUpdateClient() {
        try {
            dao.updateClient(client, "name", "Lucas da Silva");
        } catch (IOException e) {
            e.printStackTrace();
        }
        Client updatedClient = null;
        try {
            updatedClient = dao.getClientById("123456789");
        } catch (IOException e) {
            e.printStackTrace();
        }
        assertEquals("Lucas da Silva", updatedClient.getName());
    }

    @Test
    void testDeleteClient() {
        try {
            dao.deleteClient(client);
        } catch (IOException e) {
            e.printStackTrace();
        }
        Client deletedClient = null;
        try {
            deletedClient = dao.getClientById("123456789");
        } catch (IOException e) {
            e.printStackTrace();
        }
        assertNull(deletedClient);
    }

    @Test
    void testReadClient() {
        Client readClient = null;
        try {
            readClient = dao.getClientById("123456789");
        } catch (IOException e) {
            e.printStackTrace();
        }
        assertEquals(client, readClient);
    }
}
