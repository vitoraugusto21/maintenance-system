package Model.Dao;

import Model.entities.Client;
import Model.entities.Invoice;

import java.util.ArrayList;

public interface InvoiceDAO{
    public void insertInvoice(Invoice invoice);
    public void updateInvoiceClient(Invoice invoice, Client client);
    public void deleteInvoice(Invoice invoice);
    public Invoice viewInvoice(Invoice invoice);
    ArrayList<Invoice> getAllInvoices();
}
