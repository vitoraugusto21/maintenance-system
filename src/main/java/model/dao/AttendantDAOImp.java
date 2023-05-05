package model.dao;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import model.entities.Attendant;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

/**
 * Implementação da interface AttendantDAO responsável pelas operações de acesso aos dados de Atendente no banco de dados.
 *
 * @author Vitor Augusto, Gabriel Vitor
 */
public class AttendantDAOImp implements AttendantDAO {

    private final Map<String, Attendant> attendants = new HashMap<>();

    File file = new File(System.getProperty("user.dir") + File.separator + "attendants.json");

    public AttendantDAOImp() {
    }

    @Override
    public void createAttendant(Attendant attendant) throws IOException {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        if (file.exists()){
            Reader reader = Files.newBufferedReader(Paths.get("attendants.json"));
            Map<String, Attendant> attendantsFromJson = gson.fromJson(reader, Map.class);
            attendantsFromJson.put(attendant.getId(), attendant);
            String updateJson = gson.toJson(attendantsFromJson);
            FileWriter writer = new FileWriter(file);
            writer.write(updateJson);
            writer.flush();
            writer.close();
        }
        else {
            attendants.put(attendant.getId(), attendant);
            String attedantsJson = gson.toJson(attendants);
            FileWriter writer = new FileWriter(file);
            writer.write(attedantsJson);
            writer.flush();
            writer.close();
        }

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
    public String readAttendants() throws IOException {
        return "";
    }

    @Override
    public Attendant getAttendantById(String id) {
        return attendants.get(id);
    }
}







