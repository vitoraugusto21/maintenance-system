package Model.Dao;

import Model.entities.Manager;

import java.util.ArrayList;

public interface ManagerDAO {

    void insertManager(Manager manager);

    void updateManager(Manager manager, String attributeToChange, String newAttribute);

    void deleteManager(Manager manager);

    ArrayList<Manager> getAllManagers();

    Manager getManagerById(String id);

    public void manageStock();
    public void viewReports();
}
