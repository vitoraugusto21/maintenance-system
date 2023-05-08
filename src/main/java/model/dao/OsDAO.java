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

    void takeOs(Technician technician) throws IOException;

    void insertOsInQueue(Os os) throws IOException;

    void cancelOs(Technician technician) throws IOException;

    void finishOs(Technician technician) throws IOException;

    Queue<Os> readOsQueue() throws IOException;
    ArrayList<Os> readOsCanceled() throws IOException;
    ArrayList<Os> readOsFinished() throws IOException;
}
