package model.dao;

import model.entities.Manager;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


/**
 * Classe que implementa a interface ManagerDAO e realiza operações de CRUD (criação, leitura, atualização e exclusão)
 * em objetos da classe Manager utilizando uma estrutura de mapeamento em hash.
 */
public class ManagerDAOImp implements ManagerDAO{

    public ManagerDAOImp(){};
    private final Map<String, Manager> managers = new HashMap<>();

    /**
     * Método que realiza o gerenciamento de estoque.
     */
    @Override
    public void manageStock() {
        // Implementação do método para gerenciar estoque
    }

    /**
     * Método que realiza o gerenciamento de estoque.
     */
    @Override
    public void viewReports() {
        // Implementação do método para visualizar relatórios
    }

    /**
     * Método que realiza o gerenciamento de estoque.
     * @param manager - objeto da classe Manager a ser inserido
     */
    @Override
    public void insertManager(Manager manager) {
        managers.put(manager.getId(), manager);
    }

    /**
     *
     * Método que atualiza um objeto da classe Manager na estrutura de mapeamento em hash.
     * @param manager - objeto da classe Manager a ser atualizado.
     * @param attributeToChange - nome do atributo a ser alterado.
     * @param newAttribute - novo valor do atributo a ser alterado.
     * @throws IllegalArgumentException - se o nome do atributo fornecido não for válido.
     */
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

    /**
     * Método que exclui um objeto da classe Manager da estrutura de mapeamento em hash.
     * @param manager objeto da classe Manager a ser excluído.
     * @param manager
     */
    @Override
    public void deleteManager(Manager manager) {
        managers.remove(manager.getId());
    }

    /**
     * Método que retorna uma lista contendo todos os objetos da classe Manager presentes na estrutura de mapeamento em hash.
     * @return lista contendo todos os objetos da classe Manager presentes na estrutura de mapeamento em hash.
     *
     */
    @Override
    public ArrayList<Manager> getAllManagers() {
        return new ArrayList<>(managers.values());
    }

    /**
     * Método que retorna um objeto da classe Manager presente na estrutura de mapeamento em hash a partir do seu identificador.
     * @param id - identificador do objeto da classe Manager a ser retornado.
     * @return - objeto da classe Manager presente na estrutura de mapeamento em hash a partir do seu identificador.
     *
     */
    @Override
    public Manager getManagerById(String id) {
        return managers.get(id);
    }


}
