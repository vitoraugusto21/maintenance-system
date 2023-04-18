package main.model.dao;

import main.model.entities.Technician;

import java.util.ArrayList;

/**
 * Interface que define as operações básicas para o DAO de técnicos.
 */
public interface TechnicianDAO {

    void insertTechnician(Technician technician);

    void updateTechnician(Technician technician, String attributeToChange, String newAttribute);

    void deleteTechnician(Technician technician);

    ArrayList<Technician> getAllTechnicians();

    Technician getTechnicianById(String id);


}
