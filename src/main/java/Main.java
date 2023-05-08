
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import model.dao.AttendantDAOImp;
import model.dao.OsDAOImp;
import model.dao.ReportDAOImp;
import model.entities.*;
import model.entities.enums.Payments;
import model.entities.Attendant;

import java.io.Reader;
import java.lang.reflect.Type;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Date;
import java.util.Map;

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
        osDAO.insertOsInQueue(os);
        osDAO.takeOs(technician);
        osDAO.finishOs(technician);

        var report = new Report(os);
        var reportDAO = new ReportDAOImp();
        reportDAO.saveReport(report);
        AttendantDAOImp attendantDAOImp = new AttendantDAOImp();
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        Reader reader = Files.newBufferedReader(Paths.get("attendants.json"));
        Type type = new TypeToken<Map<String, Attendant>>(){}.getType();
        Map<String, Attendant> attendantsFromJson = gson.fromJson(reader, type);
        Attendant attendant= attendantsFromJson.get("003");
        attendantDAOImp.updateAttendant(attendant, "name", "Kousin");
    }



}

