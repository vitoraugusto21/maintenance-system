package Model.Dao;

import Model.entities.Manager;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class ManagerDAOImp implements ManagerDAO{

    public ManagerDAOImp(){};
    private final Map<String, Manager> managers = new HashMap<>();

    @Override
    public void manageStock() {
        // Implementação do método para gerenciar estoque
    }

    @Override
    public void viewReports() {
        // Implementação do método para visualizar relatórios
    }

    @Override
    public void insertManager(Manager manager) {
        managers.put(manager.getId(), manager);
    }

    @Override
    public void updateManager(Manager manager, String attributeToChange, String newAttribute) {
        switch (attributeToChange.toLowerCase()) {
            case "name" -> manager.setName(newAttribute);
            case "email" -> manager.setEmail(newAttribute);
            case "phonenumber" -> manager.setPhoneNumber(newAttribute);
            case "address" -> manager.setAddress(newAttribute);
            case "password" -> manager.setPassword(newAttribute);
            default -> throw new IllegalArgumentException("Invalid attribute name");
        }
        managers.put(manager.getId(), manager);
    }

    @Override
    public void deleteManager(Manager manager) {
        managers.remove(manager.getId());
    }

    @Override
    public ArrayList<Manager> getAllManagers() {
        return new ArrayList<>(managers.values());
    }

    @Override
    public Manager getManagerById(String id) {
        return managers.get(id);
    }


}
