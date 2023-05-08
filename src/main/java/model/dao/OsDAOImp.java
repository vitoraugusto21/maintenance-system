package model.dao;

import model.entities.Os;
import model.entities.Technician;

import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.Queue;

import static model.entities.enums.OsStatus.*;

/**
 * Classe OsDAOImp representa a implementação da interface OsDAO, responsável por gerenciar as ordens de serviço (Os) do sistema.
 */
public class OsDAOImp implements OsDAO {

    public Queue<Os> queue = new LinkedList<>();
    public ArrayList<Os> osCanceledList = new ArrayList<>();
    public ArrayList<Os> osFinishedList = new ArrayList<>();
    File fileQueue = new File(System.getProperty("user.dir") + File.separator + "osQueue.json");
    File fileCanceled = new File(System.getProperty("user.dir") + File.separator + "osCanceled.json");
    File fileFinished = new File(System.getProperty("user.dir") + File.separator + "osFinished.json");

    public OsDAOImp() {
    }

    /**
     * Pega a primeira Os da fila e a define para o técnico.
     *
     * @param technician - Técnico que irá receber a Os.
     */
    public void takeOs(Technician technician) { //Pega a primeira Os da fila e a define para o tecnico
        if (technician.getOs() != null) {
            System.out.println("Finalize a Os atual antes de pegar outra");
        } else {
            Os first = queue.peek();
            queue.remove();
            technician.setOs(first);
            first.setStatus(IN_PROGRESS);
        }
    }

    /**
     * Adiciona uma Os à fila.
     *
     * @param os - Os a ser adicionada.
     */
    public void insertOsInQueue(Os os) { //adicionar os a fila
        queue.add(os);
    }

    /**
     * Cancela uma Os, deixando assim o técnico livre.
     *
     * @param technician Técnico que está com a Os a ser cancelada.
     */
    public void cancelOs(Technician technician) { //Cancelar a os, deixando assim o tecnico livre
        osCanceledList.add(technician.getOs());
        technician.getOs().setStatus(CANCELED);
        technician.setOs(null);
    }

    /**
     * Finaliza uma Os, adicionando-a à lista de Os finalizadas.
     *
     * @param technician Técnico que está com a Os a ser finalizada.
     */
    public void finishOs(Technician technician) {
        osFinishedList.add(technician.getOs());
        technician.getOs().setStatus(FINISH);
        technician.getOs().setEndTime(new Date()); // Adicionar dia de finalização da os
        technician.setOs(null);
    }

    /**
     * Mostra a OS
     *
     * @param osId    - id da os a ser mostrada
     * @param osQueue - fila que contem a os
     * @return - retorna a OS
     */
    public Os viewOs(String osId, Queue<Os> osQueue) {
        for (Os os : osQueue) {
            if (os.getOsId().equals(osId)) {
                System.out.println(os);

            }
        }
        System.out.println("Ordem de serviço não encontrada");
        return null;
    }
}
