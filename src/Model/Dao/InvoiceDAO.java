package Model.Dao;

import Model.entities.Client;
import Model.entities.Invoice;

import java.util.ArrayList;

public interface InvoiceDAO{
    public void insertInvoice(Invoice invoice, ArrayList invoicesList);
    public void updateInvoice(Invoice invoice, String attributteToChange, String newAttributte);
    public void deleteInvoice(Invoice invoice);
    public void getInvoice(Invoice invoice);
    ArrayList<Invoice> getAllInvoices();
}
