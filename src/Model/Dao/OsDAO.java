package Model.Dao;

import Model.entities.*;
import Model.entities.enums.OsStatus;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.Queue;

public interface OsDAO {

    public void takeOs(Technician technician);
    public void insertOs(Os os);

    public void cancelOs(Technician technician);

    public  void finishOs(Technician technician);

    public void cleaning(Os os);

    public void addOperationalSystem(Os os);

    public void addPrograms(Os os, int quantity);

    public void addParts(Os os, Product part);

    public void addDuration(Os os);

    public void addTechnician(Os os, Technician technician);
    public Os viewOs(String osId, Queue<Os> osQueue);
    public void genReport(String osId, Queue<Os> osQueue);
    public void genInvoice(Invoice invoice);
}
