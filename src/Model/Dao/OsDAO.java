package Model.Dao;

import Model.entities.*;
import Model.entities.enums.OsStatus;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.Queue;

public interface OsDAO {

    public void takeOs(Queue queue, Technician technician);
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
