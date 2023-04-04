package test;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import java.util.ArrayList;

public class AttendantDAOImpTest {
    private AttendantDAOImp dao;
    private Attendant attendant1;
    private Attendant attendant2;
    private ArrayList<Attendant> attendantList;

    @Before
    public void setUp() {
        dao = new AttendantDAOImp();
        attendant1 = new Attendant("John Doe", "johndoe@gmail.com", "123456789", "123 Main St");
        attendant2 = new Attendant("Jane Smith", "janesmith@gmail.com", "987654321", "456 Oak St");
        attendantList = new ArrayList<Attendant>();
        attendantList.add(attendant1);
        attendantList.add(attendant2);
    }

    @Test
    public void testCreateAttendant() {
        Attendant newAttendant = new Attendant("Bob Johnson", "bjohnson@gmail.com", "555555555", "789 Elm St");
        dao.createAttendant(newAttendant);
        assertTrue(attendantList.contains(newAttendant));
    }

    @Test
    public void testUpdateAttendant() {
        String newName = "John Smith";
        dao.updateAttendant(attendant1, "name", newName);
        assertEquals(newName, attendant1.getName());
    }

    @Test
    public void testDeleteAttendant() {
        dao.deleteAttendant(attendant2, attendantList);
        assertFalse(attendantList.contains(attendant2));
    }
}