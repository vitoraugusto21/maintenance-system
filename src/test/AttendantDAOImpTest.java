package test;

import static org.junit.Assert.*;

import Model.Dao.AttendantDAOImp;
import Model.entities.Attendant;
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
        attendant1 = new Attendant("12345","Neymar" , "123456789", "neymar@gmail.com","44034205","0123456");
        attendant2 = new Attendant("67890","Gabigol" , "987654321", "gabigol@gmail.com","44034200","0123456");
        attendantList = new ArrayList<Attendant>();
        attendantList.add(attendant1);
        attendantList.add(attendant2);
    }

    @Test
    public void testCreateAttendant() {
        Attendant newAttendant = new Attendant("67890","Gabigol" , "987654321", "gabigol@gmail.com",
                "44034200","0123456");
        dao.insertAttendant(newAttendant, attendantList);
        assertTrue(attendantList.contains(newAttendant));
    }

    @Test
    public void testUpdateAttendant() {
        String newName = "Jacson";
        dao.updateAttendant(attendant1, "name", newName);
        assertEquals(newName, attendant1.getName());
    }

    @Test
    public void testDeleteAttendant() {
        dao.deleteAttendant(attendant2, attendantList);
        assertFalse(attendantList.contains(attendant2));
    }
}