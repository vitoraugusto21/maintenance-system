package model.dao;

import model.entities.Manager;

import java.util.ArrayList;

/**
 * Esta interface define os métodos que devem ser implementados para interagir com um objeto Manager em um banco de dados.
 */
public interface ManagerDAO {

    void insertManager(Manager manager);

    void updateManager(Manager manager, String attributeToChange, String newAttribute);

    void deleteManager(Manager manager);

    ArrayList<Manager> getAllManagers();

    Manager getManagerById(String id);

    public void manageStock();
    public void viewReports();
}
