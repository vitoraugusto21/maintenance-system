package test;

import main.model.dao.TechnicianDAO;
import main.model.dao.TechnicianDAOImp;
import main.model.entities.Technician;
import org.junit.jupiter.api.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;


class TechnicianDAOImpTest {

    private TechnicianDAO technicianDAO;
    private Map<String, Technician> technicians;

    @BeforeEach
    void setUp() {
        technicianDAO = new TechnicianDAOImp();
        technicians = new HashMap<>();
    }

    @Test
    void insertTechnician() {
        Technician technician = new Technician("1", "John", "john@test.com", "123456", "1234");
        technicianDAO.insertTechnician(technician);
        technicians.put(technician.getId(), technician);

        assertEquals(technicians, technicianDAO.getAllTechnicians().stream().collect(
                HashMap::new, (map, obj) -> map.put(obj.getId(), obj), HashMap::putAll)
        );
    }

    @Test
    void updateTechnician() {
        Technician technician = new Technician("1", "John", "john@test.com", "123456", "1234");
        technicianDAO.insertTechnician(technician);
        technicians.put(technician.getId(), technician);

        technician.setName("Mary");
        technicianDAO.updateTechnician(technician, "name", "Mary");
        technicians.put(technician.getId(), technician);

        assertEquals(technicians, technicianDAO.getAllTechnicians().stream().collect(
                HashMap::new, (map, obj) -> map.put(obj.getId(), obj), HashMap::putAll)
        );
    }

    @Test
    void deleteTechnician() {
        Technician technician = new Technician("1", "John", "john@test.com", "123456", "1234");
        technicianDAO.insertTechnician(technician);
        technicians.put(technician.getId(), technician);

        technicianDAO.deleteTechnician(technician);
        technicians.remove(technician.getId());

        assertEquals(technicians, technicianDAO.getAllTechnicians().stream().collect(
                HashMap::new, (map, obj) -> map.put(obj.getId(), obj), HashMap::putAll)
        );
    }

    @Test
    void getAllTechnicians() {
        Technician technician1 = new Technician("1", "John", "john@test.com", "123456", "1234");
        Technician technician2 = new Technician("2", "Mary", "mary@test.com", "654321", "5678");

        technicianDAO.insertTechnician(technician1);
        technicianDAO.insertTechnician(technician2);
        technicians.put(technician1.getId(), technician1);
        technicians.put(technician2.getId(), technician2);

        ArrayList<Technician> expected = new ArrayList<>(technicians.values());
        ArrayList<Technician> actual = technicianDAO.getAllTechnicians();

        assertEquals(expected, actual);
    }

    @Test
    void getTechnicianById() {
        Technician technician1 = new Technician("1", "John", "john@test.com", "123456", "1234");
        Technician technician2 = new Technician("2", "Mary", "mary@test.com", "654321", "5678");

        technicianDAO.insertTechnician(technician1);
        technicianDAO.insertTechnician(technician2);
        technicians.put(technician1.getId(), technician1);
        technicians.put(technician2.getId(), technician2);

        Technician expected = technician1;
        Technician actual = technicianDAO.getTechnicianById("1");

        assertEquals(expected, actual);
    }
}