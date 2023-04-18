package main.model.dao;

import main.model.entities.Os;

public class ReportDAOImp implements ReportDAO{
    @Override
    public String genReport(Os os) {
        return "Relatório: \n" +
                "Ordem de Serviço: " +
                "Tempo médio de espera: " +
                "Custo das peças: " ;
    }

}

/**
 * public String toString() {
 *         return "Fatura: " +
 *                 "Cliente: " + client.getName() +
 *                 ", Tecnico: " + technician.getName() +
 *                 ", Atendente: " + attendant.getName() +
 *                 ", Valor Total: " + os.getTotalValue() +
 *                 ", Forma de pagamento: " + payment +
 *                 os.getDescription();
 *     }
 */
