package Model.Dao;

import Model.entities.*;
import Model.entities.enums.Payments;

import java.util.ArrayList;

public interface InvoiceDAO{
    public void insertInvoice(Invoice invoice);
    public void updateInvoiceClient(Invoice invoice, Client client);
    public void updateInvoiceAttendant(Invoice invoice, Attendant attendant);
    public void updateInvoiceClient(Invoice invoice, Technician technician);
    public void updateInvoiceOs(Invoice invoice, Os os);
    public void updateInvoicePayment(Invoice invoice, Payments payment);
    public void deleteInvoice(Invoice invoice);
    public Invoice viewInvoice(Invoice invoice);
    ArrayList<Invoice> getAllInvoices();
}
