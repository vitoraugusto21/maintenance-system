package Model.Dao;

import Model.entities.Invoice;
import Model.entities.Os;
import Model.entities.enums.OsStatus;

import java.util.Date;

public interface OsDAO {
    public void createOs(Os os);
    public void updateOs(Os os);
    public void deleteOs(Os os);
    public void viewOs(String osId);
    public void genReport(String osId);
    public void genInvoice(Invoice invoice);
}
