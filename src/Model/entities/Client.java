package Model.entities;

import Model.Dao.ClientDAO;

import java.util.ArrayList;
import java.util.List;

/**
 * A classe Client é responsável por representar um cliente e suas informações no sistema. É uma subclasse da classe Person.
 * @author Vitor Augusto, Gabriel Vitor
 */
public  class Client extends Person{

    private ArrayList<Os> clientOs; //lista de ordens de serviços dos clientes


    /**
     * Construtor padrão da classe Client.
     */
    public Client() {
    }


    /**
     * Construtor com argumentos da classe Client.
     *
     * @param id o id do cliente.
     * @param name o nome do cliente.
     * @param phoneNumber o número de telefone do cliente.
     * @param email o email do cliente.
     * @param address o endereço do cliente.
     */
    public Client(String id, String name, String phoneNumber, String email, String address) {
        super(id, name, phoneNumber, email, address);
    }

    public Client(String id, String name, String phoneNumber, String email, String address, ArrayList<Os> clientOs) {
        super(id, name, phoneNumber, email, address);
        this.clientOs = clientOs;
    }

    public ArrayList<Os> getClientOs() {
        return clientOs;
    }

    public void setClientOs(ArrayList<Os> clientOs) {
        this.clientOs = clientOs;
    }




}
