package Model.Dao;

import Model.entities.Attendant;
import Model.entities.Os;

public interface AttendantDAO {
    public void createAttendant(Attendant attendant);
    public void updateAttendant(Attendant attendant);
    public void deleteAttendant(String id);
}
