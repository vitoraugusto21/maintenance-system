package test;

import main.model.dao.OsDAOImp;
import main.model.entities.Os;
import main.model.entities.Technician;
import org.junit.Test;

import java.util.Date;

import static main.model.entities.enums.OsStatus.*;
import static org.junit.Assert.*;


public class OsDAOImpTest {

    @Test
    public void takeOsTest() {
        OsDAOImp osDao = new OsDAOImp();
        Technician tec = new Technician("1", "John", "john@test.com", "123456", "1234");
        Os os1 = new Os("1");
        Os os2 = new Os("2");
        osDao.queue.add(os1);
        osDao.queue.add(os2);
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
