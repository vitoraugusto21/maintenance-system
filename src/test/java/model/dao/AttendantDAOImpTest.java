package model.dao;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import model.dao.AttendantDAOImp;
import model.entities.Attendant;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class AttendantDAOImpTest {
    private AttendantDAOImp dao;
    File file = new File(System.getProperty("user.dir") + File.separator + "attendantsTest.json");


    @AfterEach
    void tearDown() throws IOException {
        file.delete();
    }

    @Test
    void testCreateAttendant() throws IOException {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        Reader reader = Files.newBufferedReader(Paths.get("attendantsTest.json"));
        Map<String, Attendant> attendantsFromJson = gson.fromJson(reader, Map.class);
        Attendant attendant = new Attendant("001", "Paul Walker", "1234567890", "paulwalker@gmail.com", "123 main.Main St");
        Attendant attendant2 = new Attendant("002", "Paul Walker", "1234567890", "paulwalker@gmail.com", "123 main.Main St");
        dao.createAttendant(attendant);
        dao.createAttendant(attendant2);
        assertEquals(attendantsFromJson.get("001"), attendant);
        assertEquals(attendantsFromJson.size(), 2);
    }

    @Test
    void testUpdateAttendant() throws IOException {
        Attendant attendant1 = new Attendant("001", "Paul Walker", "1234567890", "paulwalker@gmail.com", "123 main.Main St");
        dao.createAttendant(attendant1);
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        Reader reader = Files.newBufferedReader(Paths.get("attendantsTest.json"));
        Map<String, Attendant> attendantsFromJson = gson.fromJson(reader, Map.class);
        dao.updateAttendant(attendantsFromJson.get("001"), "name", "John Smith");
        assertEquals("John Smith", dao.getAttendantById(attendant1.getId()).getName());
    }

    @Test
    void testDeleteAttendant() throws IOException {
        Attendant attendant1 = new Attendant("001", "Paul Walker", "1234567890", "paulwalker@gmail.com", "123 main.Main St");
        dao.createAttendant(attendant1);
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        Reader reader = Files.newBufferedReader(Paths.get("attendantsTest.json"));
        Map<String, Attendant> attendantsFromJson = gson.fromJson(reader, Map.class);
        dao.deleteAttendant(attendantsFromJson.get("001"));
        assertNull(attendantsFromJson.get("001"));
    }

    @Test
    void testReadAttendants() throws IOException {
        Attendant attendant1 = new Attendant("001", "Paul Walker", "1234567890", "paulwalker@gmail.com", "123 main.Main St");
        dao.createAttendant(attendant1);
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        Reader reader = Files.newBufferedReader(Paths.get("attendantsTest.json"));
        Map<String, Attendant> attendantsFromJson = gson.fromJson(reader, Map.class);
        assertEquals(attendantsFromJson, dao.readAttendants());
    }

    @Test
    void testGetAttendantById() throws IOException {
        Attendant attendant1 = new Attendant("001", "Paul Walker", "1234567890", "paulwalker@gmail.com", "123 main.Main St");
        dao.createAttendant(attendant1);
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        Reader reader = Files.newBufferedReader(Paths.get("attendantsTest.json"));
        Map<String, Attendant> attendantsFromJson = gson.fromJson(reader, Map.class);
        assertEquals(attendant1, dao.getAttendantById(attendant1.getId()));
    }
}