
package main.model.dao;

import main.model.entities.Technician;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


public class TechnicianDAOImp implements TechnicianDAO {

    public TechnicianDAOImp(){};
    private final Map<String, Technician> technicians = new HashMap<>();

    /**
     * Insere um objeto Technician no banco de dados.
     *
     * @param technician - O objeto Technician a ser inserido.
     */
    @Override
    public void insertTechnician(Technician technician) {
        technicians.put(technician.getId(), technician);
    }

    /**
     * Atualiza um objeto Technician no banco de dados.
     *
     * @param technician - O objeto Technician a ser atualizado.
     * @param attributeToChange - O atributo do objeto a ser modificado.
     * @param newAttribute - O novo valor do atributo modificado.
     */
    @Override
    public void updateTechnician(Technician technician, String attributeToChange, String newAttribute) {
        switch (attributeToChange.toLowerCase()) {
            case "name" -> technician.setName(newAttribute);
            case "email" -> technician.setEmail(newAttribute);
            case "phonenumber" -> technician.setPhoneNumber(newAttribute);
            case "address" -> technician.setAddress(newAttribute);
            case "password" -> technician.settPassword(newAttribute);
            default -> throw new IllegalArgumentException("Invalid attribute name");
        }
        technicians.put(technician.getId(), technician);
    }

    /**
     * Remove um objeto Technician do banco de dados.
     *
     * @param technician - O objeto Technician a ser removido.
     */
    @Override
    public void deleteTechnician(Technician technician) {
        technicians.remove(technician.getId());
    }

    /**
     * Método que retorna uma lista com todos os técnicos cadastrados no banco de dados.
     * @return -  Uma lista com todos os técnicos cadastrados no banco de dados.
     */
    @Override
    public ArrayList<Technician> getAllTechnicians() {
        return new ArrayList<>(technicians.values());
    }

    /**
     * Método que retorna um objeto Technician com base no seu ID.
     *
     * @param id - O ID do técnico desejado.
     * @return - O objeto Technician com o ID fornecido.
     */
    @Override
    public Technician getTechnicianById(String id) {
        return technicians.get(id);
    }


}