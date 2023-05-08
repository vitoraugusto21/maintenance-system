package model.dao;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import model.entities.Attendant;
import model.entities.Client;
import model.entities.Os;
import model.entities.Technician;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

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
    public void insertOsInQueue(Os os) throws IOException { //adicionar os a fila
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        if (fileQueue.exists()){
            Reader reader = Files.newBufferedReader(Paths.get("osQueue.json"));
            Queue<Os> queueFromJson = gson.fromJson(reader, Queue.class);
            queueFromJson.add(os);
            String updateJson = gson.toJson(queueFromJson);
            FileWriter writer = new FileWriter(fileQueue);
            writer.write(updateJson);
            writer.flush();
            writer.close();
        }
        else{
            queue.add(os);
            String queueJson = gson.toJson(queue);
            FileWriter writer = new FileWriter(fileQueue);
            writer.write(queueJson);
            writer.flush();
            writer.close();
        }
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
    public Queue<Os> readOsQueue() throws IOException {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        Reader reader = Files.newBufferedReader(Paths.get("osQueue.json"));
        Queue<Os> queue1 = gson.fromJson(reader, new TypeToken<Queue<Os>>(){}.getType());
        return queue1;
        }

    public Queue<Os> readOsCanceled() throws IOException {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        Reader reader = Files.newBufferedReader(Paths.get("osCanceled.json"));
        Queue<Os> osCanceleds = gson.fromJson(reader, new TypeToken<ArrayList<Os>>(){}.getType());
        return osCanceleds;
    }

    public ArrayList<Os> readOsFinished() throws IOException {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        Reader reader = Files.newBufferedReader(Paths.get("osFinished.json"));
        ArrayList<Os> osFinisheds = gson.fromJson(reader, new TypeToken<ArrayList<Os>>(){}.getType());
        return osFinisheds;
    }

}

