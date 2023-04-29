package model.dao;

import model.entities.Attendant;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Implementação da interface AttendantDAO responsável pelas operações de acesso aos dados de Atendente no banco de dados.
 *
 * @author Vitor Augusto, Gabriel Vitor
 */
public class AttendantDAOImp implements AttendantDAO {

    private final Map<String, Attendant> attendants = new HashMap<>();

    public AttendantDAOImp() {
    }

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







