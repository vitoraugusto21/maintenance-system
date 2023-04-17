package test;

import static org.junit.Assert.*;

import Model.Dao.OsDAOImp;
import Model.entities.Client;
import Model.entities.Os;
import Model.entities.Technician;
import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;


public class OsDAOImpTest {

    @Test
    public void takeOsTest() {
        OsDAOImp osDao = new OsDAOImp();
        Technician tec = new Technician("1", "John", "john@test.com", "123456", "1234");
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
    public void assignOsTest() {
        Client client = new Client();
        Os os = new Os("1");
        OsDAOImp osDAOImp = new OsDAOImp();
        ArrayList<Os> clientOs = new ArrayList<>();
        client.setClientOs(clientOs);
        osDAOImp.assignOs(os, client.getClientOs());

        /* verificar se a os foi adicionada a lista de os do cliente */
        assertTrue(client.getClientOs().contains(os));
    }

    @Test
    public void deleteOsTest() {
        Client client = new Client();
        Os os = new Os("1");
        OsDAOImp osDAOImp = new OsDAOImp();
        ArrayList<Os> clientOs = new ArrayList<>();
        client.setClientOs(clientOs);
        osDAOImp.assignOs(os, client.getClientOs());

        /* verificar se a os foi adicionada a lista de os do cliente */
        assertTrue(client.getClientOs().contains(os));

        client.getClientOs().remove(os);

        /* verificar se a os foi removida da lista de os do cliente */
        assertEquals(0, client.getClientOs().size());
    }

    @Test
    public void addDurationTest() throws ParseException {
        OsDAOImp osDAOImp = new OsDAOImp();
        Os os = new Os("1234");
        String startTime = "20/11/2023";
        String endTime = "22/11/2023";
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        Date startDate = format.parse(startTime);
        Date endDate = format.parse(endTime);
        os.setStartTime(startDate);
        os.setEndTime(endDate);
        osDAOImp.addDuration(os);
        assertEquals(2, os.getDuration());
    }

    @Test
    public void cleaningTest() {
        OsDAOImp osDAOImp = new OsDAOImp();
        Os os = new Os("1234");
        osDAOImp.cleaning(os);

        assertEquals(os.getCleaning(), os.getTotalValue(), 0.0);
    }

    @Test
    public void addOperationalSystemTest() {
        OsDAOImp osDAOImp = new OsDAOImp();
        Os os = new Os("1234");
        osDAOImp.addOperationalSystem(os);

        assertEquals(os.getOperationalSystem(), os.getTotalValue(), 0.0);
    }


    @Test
    public void addProgramsTest() {

        OsDAOImp osDAOImp = new OsDAOImp();
        Os os = new Os("1234");
        osDAOImp.addPrograms(os, 1);

        assertEquals(os.getPrograms() * 1, os.getTotalValue(), 0.0);
    }

}
