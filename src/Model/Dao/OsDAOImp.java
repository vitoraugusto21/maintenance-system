package Model.Dao;

import Model.entities.*;
import Model.entities.enums.OsStatus;

import java.util.*;

public class OsDAOImp implements OsDAO{

    public OsDAOImp(){};
    public void takeOs(Queue queue, Technician technician){ //Pega a primeira Os da fila e a define para o tecnico
        Os first = (Os) queue.peek();
        queue.remove();
        technician.setOs(first);
    };
    public void assignOs(Os os, ArrayList clientOs){ //adicionar os ao registro
        clientOs.add(os);
    };
     
    public void deleteOs(Os os, ArrayList clientOs){ //deletar os do registro
        clientOs.remove(os);
    };

    public void assignEndTime(Os os, Date endTime){
        os.setEndTime(endTime);
    }

    public void cleaning(Os os){ //adicionar limpeza a OS
        Double totalValue = os.getTotalValue() + os.getCleaning();
        os.setTotalValue(totalValue);
    }

    public void addOperationalSystem(Os os){
        Double totalValue = os.getTotalValue() + os.getOperationalSystem();
        os.setTotalValue(totalValue);
    }

    public void addPrograms(Os os, int quantity){ //adicionar os programas (e quantos) a os
        Double totalValue = os.getTotalValue() + (os.getPrograms() * quantity);
        os.setTotalValue(totalValue);
    }

    public void addParts(Os os, Product part){
        os.getUsedParts().add(part);
        Double totalValue = os.getTotalValue() + part.getProductPrice();
        os.setTotalValue(totalValue);
    }

    public void updateStatus(Os os, OsStatus status){} //Mudar o status da Os

    public void addDuration(Os os){}; //adicionar qual foi o tempo de duração da OS

    public void addTechnician(Os os, Technician technician){ //adicionar id do tecnico que pegou a os
        os.setTechnicianId(technician.getId());
    }

    public void viewOs(String osId){};
    public void genReport(String osId){};
    public void genInvoice(Invoice invoice){};

}
