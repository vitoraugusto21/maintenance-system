package Model.entities;


/**
 * A classe Attendant representa um atendente que trabalha na empresa de manutenção de computadores.
 * Esta classe herda da classe Person e adiciona um campo de senha.
 */
public class Attendant extends Person{

    /**
     * A senha do atendente.
     */
    private String aPassword;


    /**
     * Constrói um objeto Attendant com os campos especificados.
     *
     * @param id o ID do atendente
     * @param name o nome do atendente
     * @param phoneNumber o número de telefone do atendente
     * @param email o e-mail do atendente
     * @param adress o endereço do atendente
     * @param aPassword a senha do atendente
     */
    public Attendant(String id, String name, String phoneNumber, String email, String adress, String aPassword) {
        super(id, name, phoneNumber, email, adress);
        this.aPassword = aPassword;
    }

    public String getaPassword() {
        return aPassword;
    }

    public void setaPassword(String aPassword) {
        this.aPassword = aPassword;
    }
}
