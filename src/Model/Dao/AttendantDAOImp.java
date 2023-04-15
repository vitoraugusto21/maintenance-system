package Model.Dao;

import Model.entities.Attendant;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AttendantDAOImp implements AttendantDAO{

    public AttendantDAOImp(){};

    private final Map<String, Attendant> attendants = new HashMap<>();

    @Override
    public void insertAttendant(Attendant attendant) {
        attendants.put(attendant.getId(), attendant);
    }

    @Override
    public void updateAttendant(Attendant attendant, String attributeToChange, String newAttribute) {
        switch (attributeToChange.toLowerCase()) {
            case "name" -> attendant.setName(newAttribute);
            case "email" -> attendant.setEmail(newAttribute);
            case "phonenumber" -> attendant.setPhoneNumber(newAttribute);
            case "address" -> attendant.setAddress(newAttribute);
            default -> throw new IllegalArgumentException("Invalid attribute name");
        }
        attendants.put(attendant.getId(), attendant);
    }

    @Override
    public void deleteAttendant(Attendant attendant) {
        attendants.remove(attendant.getId());
    }

    @Override
    public ArrayList<Attendant> getAllAttendants() {
        return new ArrayList<>(attendants.values());
    }

    @Override
    public Attendant getAttendantById(String id) {
        return attendants.get(id);
    }
}







