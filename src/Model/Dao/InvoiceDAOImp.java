package Model.Dao;

import Model.entities.Client;
import Model.entities.Invoice;

import java.util.ArrayList;

public class InvoiceDAOImp implements InvoiceDAO{

    public ArrayList<Invoice> invoiceList = new ArrayList<>();

    public InvoiceDAOImp(){};

    @Override
    public void insertInvoice(Invoice invoice) {
        invoiceList.add(invoice);
    }

    @Override
    public void updateInvoiceClient(Invoice invoice, Client client) {
        invoice.setClient(client);
    }

    @Override
    public void deleteInvoice(Invoice invoice) {
        invoiceList.remove(invoice);
    }

    @Override
    public Invoice viewInvoice(Invoice invoice) {
        return invoice;
    }

    @Override
    public ArrayList<Invoice> getAllInvoices() {
        return invoiceList;
    }
}
