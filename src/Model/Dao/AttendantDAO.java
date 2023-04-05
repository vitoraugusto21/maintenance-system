package Model.Dao;

import Model.entities.Attendant;
import Model.entities.Os;

public interface AttendantDAO {
    public void insertAttendant(Attendant attendant);
    public void updateAttendant(Attendant attendant, String attributeToChange, String newAttribute);
    public void deleteAttendant(String id);
}
