package model.dao;

import model.entities.Os;
import model.entities.Technician;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
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
    public void insertOsInQueueTest() {
        Os os = new Os("1");
        OsDAOImp osDAOImp = new OsDAOImp();
        osDAOImp.insertOsInQueue(os);

        /* verificar se a os foi adicionada a lista de os do cliente */
        assertTrue(osDAOImp.queue.contains(os));
    }

    @Test
    public void cancelOsTest() {
        Os os = new Os("1");
        OsDAOImp osDAOImp = new OsDAOImp();
        Technician technician = new Technician("1", "John", "john@test.com", "123456", "1234");
        technician.setOs(os);
        osDAOImp.cancelOs(technician);

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
