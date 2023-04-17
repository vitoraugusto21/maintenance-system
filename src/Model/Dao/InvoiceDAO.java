package Model.Dao;

import Model.entities.Attendant;
import Model.entities.Client;
import Model.entities.Invoice;
import Model.entities.Technician;

import java.util.ArrayList;

public interface InvoiceDAO{
    public void insertInvoice(Invoice invoice);
    public void updateInvoiceClient(Invoice invoice, Client client);
    public void updateInvoiceAttendant(Invoice invoice, Attendant attendant);
    public void updateInvoiceClient(Invoice invoice, Technician technician);


    public void deleteInvoice(Invoice invoice);
    public Invoice viewInvoice(Invoice invoice);
    ArrayList<Invoice> getAllInvoices();
}
