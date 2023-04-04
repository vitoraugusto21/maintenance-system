package Model.Dao;

import Model.entities.Attendant;
import Model.entities.Client;
import Model.entities.Os;

import java.util.ArrayList;

public class AttendantDAOImp {

    public AttendantDAOImp(){};

    public void insertAttendant(Attendant attendant, ArrayList attendantList){
        attendantList.add(attendant);
    };
    public void updateAttendant(Attendant attendant, String atributteToChange, String newAtributte){
        if (atributteToChange == attendant.getId()){
            attendant.setId(newAtributte);
        }

        else if (atributteToChange == attendant.getEmail()){
            attendant.setEmail(newAtributte);
        }

        else if (atributteToChange == attendant.getName()){
            attendant.setName(newAtributte);
        }

        else if (atributteToChange == attendant.getPhoneNumber()){
            attendant.setPhoneNumber(newAtributte);
        }

        else if (atributteToChange == attendant.getAdress()){
            attendant.setAdress(newAtributte);
        }
    };
    public void deleteAttendant(Attendant attendant, ArrayList attendantList){
        attendantList.remove(attendant);

        //delete attendant from database
    };
}
