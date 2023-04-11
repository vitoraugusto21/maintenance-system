import Model.Dao.OsDAOImp;
import Model.entities.Os;
import Model.entities.Technician;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static void main(String[] args) {

        Queue<Os> queue = new LinkedList<>();
        OsDAOImp dao = new OsDAOImp();
        Technician tec = new Technician();

        queue.add(new Os("1"));
        queue.add(new Os("2"));
        queue.add(new Os("3"));
        queue.add(new Os("4"));

        dao.takeOs(queue,tec);

        System.out.println(queue);
    }
}

