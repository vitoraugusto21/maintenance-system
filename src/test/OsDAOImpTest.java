package test;

import static Model.entities.enums.OsStatus.*;
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
        Os os1 = new Os("1");
        Os os2 = new Os("2");
        osDao.queue.add(os1);
        osDao. queue.add(os2);
        osDao.queue.add(new Os("3"));
        osDao.queue.add(new Os("4"));
        osDao.takeOs(tec);
        System.out.println(tec.getOs());

        /* verificar se foi atrubuida ao tecnico corretamente */
        assertEquals(os1, tec.getOs());

        /* verificar se a os foi retirada da fila */
        assertEquals(os2, osDao.queue.peek());

        /* verificar se o status da os foi inserido */
        assertEquals(IN_PROGRESS, tec.getOs().getStatus());
    }

   @Test
    public void insertOsTest() {
        Os os = new Os("1");
        OsDAOImp osDAOImp = new OsDAOImp();
        osDAOImp.insertOs(os);

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
        osDAOImp.cancelOs(technician);

        /* verificar se a os saiu do tecnico */
        assertNull(technician.getOs());

        /* verificar se a foi inserida na lista de os cancelada*/
        assertTrue(osDAOImp.osFinishedList.contains(os));

        /* verificar se o status da os foi atualizado */
        assertEquals(FINISH, os.getStatus());
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
