package main;

import main.model.dao.OsDAOImp;
import main.model.dao.ReportDAOImp;
import main.model.entities.*;
import main.model.entities.enums.Payments;

import java.util.Date;

public class Main {
    public static void main(String[] args) throws Exception {
        var client = new Client();
        Attendant attendant1 = new Attendant("001", "John Doe", "555-1234", "john.doe@example.com", "123 Main St", "password123");
        Attendant attendant2 = new Attendant("002", "Jane Smith", "555-5678", "jane.smith@example.com", "456 Elm St", "mypassword");
        Manager manager = new Manager("001", "John Doe", "555-1234", "john.doe@example.com", "123 Main St", "password123");
        Technician technician = new Technician("001", "Jane Doe", "555-1234", "jane.doe@example.com", "123 Main St", "password123");

        Date startTime = new Date();
        Os os = new Os("001", "Repair PC", startTime, Payments.PIX, "001", "100");

        // Add os to technician
        var osDAO = new OsDAOImp();
        osDAO.insertOs(os);
        osDAO.takeOs(technician);
        osDAO.finishOs(technician);

        var report = new Report(os);
        var reportDAO = new ReportDAOImp();
        reportDAO.saveReport(report);
    }
}

