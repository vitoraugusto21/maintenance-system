package Model.entities;

import java.util.Date;

/**
 * Classe que representa uma fatura emitida pela empresa para um cliente
 * com as informações dos produtos comprados e os valores
 * @author Vitor Augusto, Gabriel Vitor
 */
public class Invoice {
    private String idInvoice;
    private String nameCompany;
    private String cnpj;
    private String idClient;
    private String nameClient;
    //product list
    private Date issueDate;
    private Date vality;
}
