package Model.Dao;

import Model.entities.Attendant;
import Model.entities.Os;

import java.util.ArrayList;

public interface AttendantDAO {
    void insertAttendant(Attendant attendant);
    void updateAttendant(Attendant attendant, String attributeToChange, String newAttribute);
    void deleteAttendant(Attendant attendant);
    ArrayList<Attendant> getAllAttendants();
    Attendant getAttendantById(String id);

}
