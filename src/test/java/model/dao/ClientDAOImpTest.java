package model.dao;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import model.entities.Attendant;
import model.entities.Client;
import org.junit.jupiter.api.*;

import java.io.File;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class ClientDAOImpTest {

    ClientDAOImp dao = new ClientDAOImp();
    File file = new File(System.getProperty("user.dir") + File.separator + "clientsTest.json");


    @AfterEach
    void tearDown() {
        file.delete();
    }

    @Test
    void testCreateClient() throws IOException {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        Reader reader = Files.newBufferedReader(Paths.get("clientsTest.json"));
        Map<String, Client> clientsFromJson = gson.fromJson(reader, Map.class);
        Client client = new Client("001", "Paul Walker", "1234567890", "paulwalker@gmail.com", "123 main.Main St");
        Client client1 = new Client("002", "Paul Walker", "1234567890", "paulwalker@gmail.com", "123 main.Main St");
        dao.createClient(client);
        dao.createClient(client1);
        assertEquals(clientsFromJson.get("001"), client);
        assertEquals(clientsFromJson.size(), 2);
    }

    @Test
    void testUpdateClient() throws IOException {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        Reader reader = Files.newBufferedReader(Paths.get("clientsTest.json"));
        Map<String, Client> clientsFromJson = gson.fromJson(reader, Map.class);
        Client client = new Client("001", "Paul Walker", "1234567890", "paulwalker@gmail.com", "123 main.Main St");
        dao.createClient(client);
        dao.updateClient(clientsFromJson.get("001"), "name", "John Smith");
        assertEquals("John Smith", clientsFromJson.get("001").getName());
    }

    @Test
    void testDeleteClient() throws IOException {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        Reader reader = Files.newBufferedReader(Paths.get("clientsTest.json"));
        Map<String, Client> clientsFromJson = gson.fromJson(reader, Map.class);
        Client client = new Client("001", "Paul Walker", "1234567890", "paulwalker@gmail.com", "123 main.Main St");
        dao.createClient(client);
        dao.deleteClient(clientsFromJson.get("001"));
        assertNull(clientsFromJson.get("001"));
    }

    @Test
    void testReadClient() throws IOException {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        Reader reader = Files.newBufferedReader(Paths.get("clientsTest.json"));
        Map<String, Client> clientsFromJson = gson.fromJson(reader, Map.class);
        Client client = new Client("001", "Paul Walker", "1234567890", "paulwalker@gmail.com", "123 main.Main St");
        dao.createClient(client);
        assertEquals(clientsFromJson, dao.readClients());
    }
}