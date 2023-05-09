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
    private Attendant attendant1;
    private Attendant attendant2;

    private final Map<String, Attendant> attendants = new HashMap<>();
    File file = new File(System.getProperty("user.dir") + File.separator + "attendantsTest.json");

    @BeforeEach
    void setUp() throws IOException {
        AttendantDAOImp dao = new AttendantDAOImp();
        attendant1 = new Attendant("001", "Paul Walker", "1234567890", "paulwalker@gmail.com", "123 main.Main St");
        attendant2 = new Attendant("3", "Bob Smith", "123456770", "bobsmith@gmail.com", "789 Oak St");
        dao.createAttendant(attendant1);
        dao.createAttendant(attendant2);
    }

    @AfterEach
    void tearDown() throws IOException {
        dao.deleteAttendant(attendant1);
        dao.deleteAttendant(attendant2);
    }

    @Test
    void testCreateAttendant() throws IOException {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        Reader reader = Files.newBufferedReader(Paths.get("attendantsTest.json"));
        Map<String, Attendant> attendantsFromJson = gson.fromJson(reader, Map.class);
        assertTrue(attendantsFromJson.containsKey("3"));
        assertEquals("Bob Smith", attendantsFromJson.get("3").getName());
        assertEquals("123456770", attendantsFromJson.get("3").getPhoneNumber());
        assertEquals("bobsmith@gmail.com", attendantsFromJson.get("3").getEmail());
        assertEquals("789 Oak St", attendantsFromJson.get("3").getAddress());
    }
/*
    @Test
    void testUpdateAttendant() {
        dao.updateAttendant(attendant1, "name", "John Smith");
        assertEquals("John Smith", dao.getAttendantById(attendant1.getId()).getName());
    }

    @Test
    void testDeleteAttendant() {
        dao.deleteAttendant(attendant2);
        assertNull(dao.getAttendantById(attendant2.getId()));
    }

    @Test
    void testGetAllAttendants() {
        ArrayList<Attendant> expected = new ArrayList<>();
        expected.add(attendant1);
        expected.add(attendant2);
        assertEquals(expected, dao.readAttendants());
    }

    @Test
    void testGetAttendantById() {
        assertEquals(attendant1, dao.getAttendantById(attendant1.getId()));
    }

    @Test
    void testInvalidAttributeToChange() {
        assertThrows(IllegalArgumentException.class, () -> dao.updateAttendant(attendant1, "invalidAttribute", "newValue"));
    }*/
}