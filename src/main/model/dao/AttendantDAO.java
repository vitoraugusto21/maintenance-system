package main.model.dao;

import main.model.entities.Attendant;

import java.util.ArrayList;

/**
 * Interface responsável por definir as operações de acesso aos dados de Atendente no banco de dados.
 * @author Vitor Augusto, Gabriel Vitor
 */
public interface AttendantDAO {
    void insertAttendant(Attendant attendant);
    void updateAttendant(Attendant attendant, String attributeToChange, String newAttribute);
    void deleteAttendant(Attendant attendant);
    ArrayList<Attendant> getAllAttendants();
    Attendant getAttendantById(String id);

}
