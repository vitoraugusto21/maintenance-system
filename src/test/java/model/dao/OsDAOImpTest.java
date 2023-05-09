package model.dao;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import model.entities.Os;
import model.entities.Technician;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.Queue;

import static model.entities.enums.OsStatus.*;
import static org.junit.Assert.*;


public class OsDAOImpTest {
    public Queue<Os> queue = new LinkedList<>();
    public ArrayList<Os> osCanceledList = new ArrayList<>();
    public ArrayList<Os> osFinishedList = new ArrayList<>();
    File fileQueue = new File(System.getProperty("user.dir") + File.separator + "osQueueTest.json");
    File fileCanceled = new File(System.getProperty("user.dir") + File.separator + "osCanceledTest.json");
    File fileFinished = new File(System.getProperty("user.dir") + File.separator + "osFinishedTest.json");

    @Test
    public void takeOsTest() throws IOException {
        OsDAOImp osDao = new OsDAOImp();
        Technician tec = new Technician("1", "John", "john@test.com", "123456", "1234");
        Os os1 = new Os("1");
        osDao.takeOs(tec);
        assertEquals(os1, tec.getOs());
    }

    @Test
    public void insertOsInQueueTest() throws IOException {
        OsDAOImp osDao = new OsDAOImp();
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        Reader reader = Files.newBufferedReader(Paths.get("osQueue.json"));
        Queue<Os> queueFromJson = osDao.readOsQueue();
        Os os = new Os("1");
        osDao.insertOsInQueue(os);
        assertTrue(osDao.readOsQueue().isEmpty());
    }

    @Test
    public void cancelOsTest() {
        OsDAOImp osDao = new OsDAOImp();
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        Reader reader = Files.newBufferedReader(Paths.get("osQueue.json"));
        Queue<Os> queueFromJson = osDao.readOsQueue();
        Os os = new Os("1");

        Os os = new Os("1");
        OsDAOImp osDAOImp = new OsDAOImp();
        Technician technician = new Technician("1", "John", "john@test.com", "123456", "1234");
        technician.setOs(os);
        osDAOImp.cancelOs(technician);
        Technician tec = new Technician("1", "John", "john@test.com", "123456", "1234");
        /* verificar se a os saiu do tecnico */
        assertNull(technician.getOs());

        /* verificar se a foi inserida na lista de os cancelada*/
        assertTrue(osDAOImp.osCanceledList.contains(os));

        /* verificar se o status da os foi atualizado */
        assertEquals(CANCELED, os.getStatus());
    }

    @Test
    public void finishOsTest() {
        Os os = new Os("1");
        OsDAOImp osDAOImp = new OsDAOImp();
        Technician technician = new Technician("1", "John", "john@test.com", "123456", "1234");
        technician.setOs(os);
        osDAOImp.finishOs(technician);

        /* verificar se a os saiu do tecnico */
        assertNull(technician.getOs());

        /* verificar se a foi inserida na lista de os cancelada*/
        assertTrue(osDAOImp.osFinishedList.contains(os));

        /* verificar se o status da os foi atualizado */
        assertEquals(FINISH, os.getStatus());

        /* verificar se o dia de finalização foi criado*/
        assertEquals(new Date(), os.getEndTime());
    }

}
