import model.dao.OsDAOImp;
import model.dao.ReportDAOImp;
import model.entities.*;
import model.entities.enums.Payments;
import model.entities.Attendant;

import java.util.Date;

public class Main {
    public static void main(String[] args) throws Exception {
        var client = new Client();
        Attendant attendant1 = new Attendant("001", "John", "555-1234", "john@example.com", "123 Main St", "password123");
        Attendant attendant2 = new Attendant("002", "Jane", "555-5678", "jane@example.com", "456 Elm St", "mypassword");
        Manager manager = new Manager("001", "John Doe", "555-1234", "john.doe@example.com", "123 Main St", "password123");
        Technician technician = new Technician("001", "Jano", "555-1234", "jano@example.com", "123 Main St", "password123");

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
        String curDir = System.getProperty("user.dir");
        System.out.println(curDir);
    }



}

