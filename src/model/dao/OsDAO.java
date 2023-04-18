package model.dao;

import model.entities.*;

import java.util.Queue;

/**
 * Interface para manipulação de ordens de serviço
 */
public interface OsDAO {

    public void takeOs(Technician technician);
    public void insertOs(Os os);

    public void cancelOs(Technician technician);

    public  void finishOs(Technician technician);

    public void cleaning(Os os);

    public void addOperationalSystem(Os os);

    public void addPrograms(Os os, int quantity);

    public void addDuration(Os os);
    public Os viewOs(String osId, Queue<Os> osQueue);
}
