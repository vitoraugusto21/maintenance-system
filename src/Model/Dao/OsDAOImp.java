package Model.Dao;

import Model.entities.*;
import Model.entities.enums.OsStatus;
import Model.Dao.ClientDAOImp;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.*;

public class OsDAOImp implements OsDAO{

    public OsDAOImp(){};
    public void takeOs(Queue queue, Technician technician){ //Pega a primeira Os da fila e a define para o tecnico
        if (technician.getOs() != null){
            System.out.println("Finalize a Os atual antes de pegar outra");
        }
        else {
            Os first = (Os) queue.peek();
            queue.remove();
            technician.setOs(first);
        }
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

    public void updateStatus(Os os, OsStatus status){
        os.setStatus(OsStatus.valueOf(String.valueOf(status)));
    } //Mudar o status da Os

    public void addDuration(Os os){
        LocalDate date1 = LocalDate.of(os.getStartTime().getYear(), os.getStartTime().getMonth(), os.getStartTime().getDay());
        LocalDate date2 = LocalDate.of(os.getEndTime().getYear(), os.getEndTime().getMonth(), os.getEndTime().getDay());

        long duration = ChronoUnit.DAYS.between(date1, date2);
        os.setDuration(duration);
    }; //adicionar qual foi o tempo de duração da OS

    public void addTechnician(Os os, Technician technician){ //adicionar id do tecnico que pegou a os
        os.setTechnicianId(technician.getId());
    }

    public Os viewOs(String osId, Queue<Os> osQueue){
        for (Os os : osQueue) {
            if (os.getOsId().equals(osId)) {
                System.out.println(os);

            }
        }
        System.out.println("Ordem de serviço não encontrada");
        return null;
    }

    //INCOMPLETO
    public void genReport(String osId, Queue<Os> osQueue) {
        Os os = viewOs(osId, osQueue);   //Encontrar ordem de serviço
        if (os == null) {
            System.out.println("Ordem de serviço não encontrada");
        }
        else {
            System.out.println("Ordem de serviço não encontrada");
            System.out.println("Relatório da Ordem de Serviço #" + " ");
            System.out.println("Cliente: " + ;
            System.out.println("Data de criação: " + " " );
            System.out.println("Status atual: " + " ");
            System.out.println("Tempo de duração: " + " " + " dias");
            System.out.println("Peças:");

        }
        
    };
    public void genInvoice(Invoice invoice){

    };

}
