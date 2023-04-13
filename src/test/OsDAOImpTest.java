package test;

import static org.junit.Assert.*;

import Model.Dao.AttendantDAOImp;
import Model.Dao.OsDAOImp;
import Model.entities.Attendant;
import Model.entities.Client;
import Model.entities.Os;
import Model.entities.Technician;
import org.junit.Before;
import org.junit.Test;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;


public class OsDAOImpTest {

    @Test
    public void takeOsTest(){
        OsDAOImp osDao = new OsDAOImp();
        Technician tec = new Technician();
        Queue<Os> queue = new LinkedList<>();
        Os os1 = new Os("1");
        Os os2 = new Os("2");
        queue.add(os1);
        queue.add(os2);
        queue.add(new Os("3"));
        queue.add(new Os("4"));
        osDao.takeOs(queue, tec);
        System.out.println(tec.getOs());

        /* verificar se foi atrubuida ao tecnico corretamente */
        assertEquals(os1, tec.getOs());

        /* verificar se a os foi retirada da fila */
        assertEquals(os2, queue.peek());
    }

    @Test
    public void assignOsTest(){
        Client client = new Client();
        Os os = new Os("1");
        OsDAOImp osDAOImp = new OsDAOImp();
        ArrayList<Os> clientOs = new ArrayList<>();
        client.setClientOs(clientOs);
        osDAOImp.assignOs(os, client.getClientOs());

        /* verificar se a os foi adicionada a lista de os do cliente */
        assertTrue(client.getClientOs().contains(os));
    }



}
