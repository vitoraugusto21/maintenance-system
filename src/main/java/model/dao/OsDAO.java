package model.dao;

import model.entities.Os;
import model.entities.Technician;

import java.util.Queue;

/**
 * Interface para manipulação de ordens de serviço
 */
public interface OsDAO {

    void takeOs(Technician technician);

    void insertOs(Os os);

    void cancelOs(Technician technician);

    void finishOs(Technician technician);

    Os viewOs(String osId, Queue<Os> osQueue);
}