package model.dao;

import model.dao.ManagerDAOImp;
import model.entities.Manager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class ManagerDAOImpTest {
    private ManagerDAOImp dao;
    private Manager manager1;
    private Manager manager2;

    @BeforeEach
    void setUp() throws IOException {
        dao = new ManagerDAOImp();
        manager1 = new Manager("1", "Anne Hathaway", "1234567890", "anne@gmail.com", "123 Groove St", "password1");
        manager2 = new Manager("2", "Michelle Rodriguez", "1234567880", "michellerodriguez@gmail.con", "456 El Chavo", "password2");
        dao.createManager(manager1);
        dao.createManager(manager2);
    }

    @AfterEach
    void tearDown() {
        dao = null;
        manager1 = null;
        manager2 = null;
    }

    @Test
    void testInsertManager() throws IOException {
        Manager manager3 = new Manager("3", "Bob Dilan", "123456770", "bobdilan@gmail.com", "789 Silicon V.", "password3");
        dao.createManager(manager3);
        assertEquals(manager3, dao.getManagerById(manager3.getId()));
    }

    @Test
    void testUpdateManager() throws IOException {
        dao.updateManager(manager1, "name", "Carlos Dilan");
        assertEquals("John Smith", dao.getManagerById(manager1.getId()).getName());
    }

    @Test
    void testDeleteManager() throws IOException {
        dao.deleteManager(manager2);
        assertNull(dao.getManagerById(manager2.getId()));
    }

    @Test
    void testGetAllManagers() throws IOException {
        ArrayList<Manager> expected = new ArrayList<>();
        expected.add(manager1);
        expected.add(manager2);
        assertEquals(expected, dao.readManagers());
    }

    @Test
    void testGetManagerById() throws IOException {
        assertEquals(manager1, dao.getManagerById(manager1.getId()));
    }

    @Test
    void testInvalidAttributeToChange() {
        assertThrows(IllegalArgumentException.class, () -> dao.updateManager(manager1, "invalidAttribute", "newValue"));
    }
}