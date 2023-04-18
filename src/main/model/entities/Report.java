package main.model.entities;

public class Report {
    private final Os os;

    public Report(Os os) {
        this.os = os;
    }

    public String generateAsString() {
        return "Relatório: \n" +
                "Ordem de Serviço: " + this.os.getOsId() +
                "Tempo médio de espera: " + this.os.calculateAverageAwait() +
                "Custo das peças: ";
    }

    public String getName() {
        return this.os.getOsId();
    }
}
