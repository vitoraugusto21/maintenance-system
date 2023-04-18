package test;

import model.dao.AttendantDAOImp;
import model.entities.Attendant;
import org.junit.jupiter.api.*;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class AttendantDAOImpTest {
    private AttendantDAOImp dao;
    private Attendant attendant1;
    private Attendant attendant2;

    @BeforeEach
    void setUp() {
        dao = new AttendantDAOImp();
        attendant1 = new Attendant("1", "Paul Walker", "1234567890", "paulwalker@gmail.com", "123 Main St");
        attendant2 = new Attendant("2", "Willen Dafoe", "1234567880", "willendafoe@gmail.com", "456 Elm St");
        dao.insertAttendant(attendant1);
        dao.insertAttendant(attendant2);
    }

    @AfterEach
    void tearDown() {
        dao = null;
        attendant1 = null;
        attendant2 = null;
    }

    @Test
    void testInsertAttendant() {
        Attendant attendant3 = new Attendant("3", "Bob Smith", "123456770", "bobsmith@gmail.com", "789 Oak St");
        dao.insertAttendant(attendant3);
        assertEquals(attendant3, dao.getAttendantById(attendant3.getId()));
    }

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
        assertEquals(expected, dao.getAllAttendants());
    }

    @Test
    void testGetAttendantById() {
        assertEquals(attendant1, dao.getAttendantById(attendant1.getId()));
    }

    @Test
    void testInvalidAttributeToChange() {
        assertThrows(IllegalArgumentException.class, () -> dao.updateAttendant(attendant1, "invalidAttribute", "newValue"));
    }
}