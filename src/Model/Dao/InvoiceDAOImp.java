package Model.Dao;

import Model.entities.Invoice;

import java.util.ArrayList;

public class InvoiceDAOImp implements InvoiceDAO{

    public ArrayList<Invoice> invoiceList = new ArrayList<>();

    public InvoiceDAOImp(){};

    @Override
    public void insertInvoice(Invoice invoice) {
        invoiceList.add(invoice);
    }

 /*   @Override
    public void updateInvoice(Invoice invoice, String attributteToChange, String newAttributte) {
        switch (attributteToChange.toLowerCase()) {
            case "client" -> invoice.setClient(newAttributte);
            case "technician" -> invoice.setTechnician(newAttributte);
            case "attendant" -> invoice.setAttendant(newAttributte);
            case "os" -> invoice.setOs(newAttributte);
            default -> throw new IllegalArgumentException("Invalid attribute name");
        }
    }*/

    @Override
    public void deleteInvoice(Invoice invoice) {

    }

    @Override
    public void getInvoice(Invoice invoice) {

    }

    @Override
    public ArrayList<Invoice> getAllInvoices() {
        return null;
    }
}
