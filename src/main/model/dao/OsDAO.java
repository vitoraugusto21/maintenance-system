package main.model.dao;

import main.model.entities.*;

import java.util.Queue;

/**
 * Interface para manipulação de ordens de serviço
 */
public interface OsDAO {

    public void takeOs(Technician technician);
    public void insertOs(Os os);

    public void cancelOs(Technician technician);

    public  void finishOs(Technician technician);

    public Os viewOs(String osId, Queue<Os> osQueue);
}
