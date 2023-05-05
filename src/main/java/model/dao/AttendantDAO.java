package model.dao;

import model.entities.Attendant;

import java.io.IOException;

/**
 * Interface responsável por definir as operações de acesso aos dados de Atendente no banco de dados.
 *
 * @author Vitor Augusto, Gabriel Vitor
 */
public interface AttendantDAO {
    void createAttendant(Attendant attendant) throws IOException;

    void updateAttendant(Attendant attendant, String attributeToChange, String newAttribute) throws IOException;

    void deleteAttendant(Attendant attendant);

    String readAttendants() throws IOException;

    Attendant getAttendantById(String id);

}
