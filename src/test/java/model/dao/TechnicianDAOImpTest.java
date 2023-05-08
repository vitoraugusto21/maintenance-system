package model.dao;

import model.dao.TechnicianDAO;
import model.dao.TechnicianDAOImp;
import model.entities.Technician;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;


class TechnicianDAOImpTest {

    private TechnicianDAO technicianDAO;
    private Map<String, Technician> technicians;

    @BeforeEach
    void setUp() {
        technicianDAO = new TechnicianDAOImp();
        technicians = new HashMap<>();
    }

    @Test
    void insertTechnicianTest() throws IOException {
        Technician technician = new Technician("3", "Joao", "123456789", "123456joao@test.com", "Paraguai", "1323@23");
        technicianDAO.createTechnician(technician);
        technicians.put(technician.getId(), technician);

        assertEquals(technicians, technicianDAO.readTechnicians());
    }

    @Test
    void updateTechnicianTest() throws IOException {
        Technician technician = new Technician("4", "John", "123456789", "john@test.com", "Paraguai","sdfdsf");
        technicianDAO.createTechnician(technician);
        technicians.put(technician.getId(), technician);

        technician.setName("Mary");
        technicianDAO.updateTechnician(technician, "name", "Mary");
        technicians.put(technician.getId(), technician);

        assertEquals(technicians, technicianDAO.readTechnicians());
    }


    @Test
    void deleteTechnicianTest() throws IOException {
        Technician technician = new Technician("5", "Johnie", "123456789", "johnie@test.com", "Paraguai","sdfdsf");
        technicianDAO.createTechnician(technician);
        technicians.put(technician.getId(), technician);

        technicianDAO.deleteTechnician(technician);
        technicians.remove(technician.getId());

        assertEquals(technicians, technicianDAO.readTechnicians());
    }

    @Test
    void getAllTechnicians() throws IOException {
        Technician technician1 = new Technician("6", "Jo", "1234564789", "jo@test.com", "Paraguai","sdfdsf");
        Technician technician2 = new Technician("7", "Joie", "1234456789", "joie@test.com", "Paraguai","sdfdsf");

        technicianDAO.createTechnician(technician1);
        technicianDAO.createTechnician(technician2);
        technicians.put(technician1.getId(), technician1);
        technicians.put(technician2.getId(), technician2);

        assertEquals(technicians, technicianDAO.readTechnicians());
    }

    @Test
    void getTechnicianById() throws IOException {
        Technician technician1 = new Technician("1", "John", "john@test.com", "123456", "1234");
        Technician technician2 = new Technician("2", "Mary", "mary@test.com", "654321", "5678");

        technicianDAO.createTechnician(technician1);
        technicianDAO.createTechnician(technician2);
        technicians.put(technician1.getId(), technician1);
        technicians.put(technician2.getId(), technician2);

        Technician expected = technician1;
        Technician actual = technicianDAO.getTechnicianById("1");

        assertEquals(expected, actual);
    }
}