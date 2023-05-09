
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import model.dao.*;
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
        Attendant attendant1 = new Attendant("001", "Paul Walker", "1234567890", "paulwalker@gmail.com", "123 main.Main St");
        Attendant attendant2 = new Attendant("002", "Jane", "555-5678", "jane@example.com", "456 Elm St", "mypassword");
        Manager manager1 = new Manager("001", "John Doe", "555-1234", "john.doe@example.com", "123 Main St", "password123");
        Technician technician = new Technician("001", "Jano", "555-1234", "jano@example.com", "123 Main St", "password123");
        Client client1 = new Client("001", "Jano", "555-1234", "jano@example.com", "123 Main St");

        Date startTime = new Date();
        Os os = new Os("002", "Repair PC", startTime, Payments.PIX, "001", "100");

        // Add os to technician
        AttendantDAOImp attendantDAOImp = new AttendantDAOImp();
        attendantDAOImp.createAttendant(attendant2);
        System.out.println("Criando arquivo attendants.json");

        ClientDAOImp clientDAOImp = new ClientDAOImp();
        clientDAOImp.createClient(client1);
        System.out.println("Criando arquivo clients.json");

        ManagerDAOImp managerDAOImp = new ManagerDAOImp();
        managerDAOImp.createManager(manager1);
        System.out.println("Criando arquivo managers.json");

        TechnicianDAOImp technicianDAOImp = new TechnicianDAOImp();
        technicianDAOImp.createTechnician(technician);
        System.out.println("Criando arquivo technicians.json");


//        OsDAOImp osDAOImp = new OsDAOImp();
//        osDAOImp.takeOs(technician);
//        osDAOImp.insertOsInQueue(os);


    }



}

