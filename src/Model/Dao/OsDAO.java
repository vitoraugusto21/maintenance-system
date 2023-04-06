package Model.Dao;

import Model.entities.Invoice;
import Model.entities.Os;
import Model.entities.Product;
import Model.entities.Technician;
import Model.entities.enums.OsStatus;

import java.util.ArrayList;
import java.util.Date;

public interface OsDAO {
    public void assignOs(Os os, ArrayList clientOs);

    public void deleteOs(Os os, ArrayList clientOs);

    public void assignEndTime(Os os, Date endTime);

    public void cleaning(Os os);

    public void addOperationalSystem(Os os);

    public void addPrograms(Os os, int quantity);

    public void addParts(Os os, Product part);

    public void updateStatus(Os os, OsStatus status);

    public void addDuration(Os os);

    public void addTechnician(Os os, Technician technician);
    public void viewOs(String osId);
    public void genReport(String osId);
    public void genInvoice(Invoice invoice);
}
