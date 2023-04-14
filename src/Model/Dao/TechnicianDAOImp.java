
package Model.Dao;

import Model.entities.Technician;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


public class TechnicianDAOImp implements TechnicianDAO {

    public TechnicianDAOImp(){};
    private final Map<String, Technician> technicians = new HashMap<>();

    @Override
    public void insertTechnician(Technician technician) {
        technicians.put(technician.getId(), technician);
    }

    @Override
    public void updateTechnician(Technician technician, String attributeToChange, String newAttribute) {
        switch (attributeToChange.toLowerCase()) {
            case "name" -> technician.setName(newAttribute);
            case "email" -> technician.setEmail(newAttribute);
            case "phonenumber" -> technician.setPhoneNumber(newAttribute);
            case "address" -> technician.setAdress(newAttribute);
            case "password" -> technician.settPassword(newAttribute);
            default -> throw new IllegalArgumentException("Invalid attribute name");
        }
        technicians.put(technician.getId(), technician);
    }

    @Override
    public void deleteTechnician(Technician technician) {
        technicians.remove(technician.getId());
    }

    @Override
    public ArrayList<Technician> getAllTechnicians() {
        return new ArrayList<>(technicians.values());
    }

    @Override
    public Technician getTechnicianById(String id) {
        return technicians.get(id);
    }


}