package model.dao;

import model.entities.Os;
import model.entities.Technician;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Queue;

/**
 * Interface para manipulação de ordens de serviço
 */
public interface OsDAO {

    void takeOs(Technician technician);

    void insertOsInQueue(Os os) throws IOException;

    void cancelOs(Technician technician);

    void finishOs(Technician technician);

    Queue<Os> readOsQueue() throws IOException;
    Queue<Os> readOsCanceled() throws IOException;
    ArrayList<Os> readOsFinished() throws IOException;
}
