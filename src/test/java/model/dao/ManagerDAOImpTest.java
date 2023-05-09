package model.dao;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import model.dao.ManagerDAOImp;
import model.entities.Attendant;
import model.entities.Manager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class ManagerDAOImpTest {
    private ManagerDAOImp dao;
    File file = new File(System.getProperty("user.dir") + File.separator + "managersTest.json");

    @AfterEach
    void tearDown() {
        file.delete();
    }

    @Test
    void testCreateManager() throws IOException {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        Reader reader = Files.newBufferedReader(Paths.get("managersTest.json"));
        Map<String, Attendant> managersFromJson = gson.fromJson(reader, Map.class);
        Manager manager = new Manager("001", "Paul Walker", "1234567890", "paulwalker@gmail.com", "123 main.Main St","1212");
        Manager manager2 = new Manager("002", "Paul Walker", "1234567890", "paulwalker@gmail.com", "123 main.Main St","2133");
        dao.createManager(manager);
        dao.createManager(manager2);
        assertEquals(managersFromJson.get("001"), manager);
        assertEquals(managersFromJson.size(), 2);
    }

    @Test
    void testUpdateManager() throws IOException {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        Reader reader = Files.newBufferedReader(Paths.get("managersTest.json"));
        Map<String, Manager> managersFromJson = gson.fromJson(reader, Map.class);
        Manager manager = new Manager("001", "Paul Walker", "1234567890", "paulwalker@gmail.com", "123 main.Main St","1212");
        Manager manager2 = new Manager("002", "Paul Walker", "1234567890", "paulwalker@gmail.com", "123 main.Main St","2133");
        dao.createManager(manager);
        dao.createManager(manager2);
        dao.updateManager(managersFromJson.get("001"), "name", "John Smith");
        assertEquals("John Smith", managersFromJson.get("001").getName());
    }

    @Test
    void testDeleteManager() throws IOException {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        Reader reader = Files.newBufferedReader(Paths.get("managersTest.json"));
        Map<String, Manager> managersFromJson = gson.fromJson(reader, Map.class);
        Manager manager = new Manager("001", "Paul Walker", "1234567890", "paulwalker@gmail.com", "123 main.Main St","1212");
        dao.deleteManager(managersFromJson.get("001"));
        assertNull(managersFromJson.get("001"));
    }
    @Test
    void testReadManager() throws IOException {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        Reader reader = Files.newBufferedReader(Paths.get("managersTest.json"));
        Map<String, Manager> managersFromJson = gson.fromJson(reader, Map.class);
        Manager manager = new Manager("001", "Paul Walker", "1234567890", "paulwalker@gmail.com", "123 main.Main St","1212");
        assertEquals(managersFromJson, dao.readManagers());
    }
}