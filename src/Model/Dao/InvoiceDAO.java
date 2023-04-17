package Model.Dao;

import Model.entities.Client;
import Model.entities.Invoice;

import java.util.ArrayList;

public interface InvoiceDAO{
    public void insertInvoice(Invoice invoice);
    //public void updateInvoice(Invoice invoice, String attributteToChange, String newAttributte);
    public void deleteInvoice(Invoice invoice);
    public void viewInvoice(Invoice invoice);
    ArrayList<Invoice> getAllInvoices();
}
