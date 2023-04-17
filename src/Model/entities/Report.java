package Model.entities;

public class Report {
    private Os os;
    private Product product;
    private Client client;

    public Report(Os os, Product product, Client client) {
        this.os = os;
        this.product = product;
        this.client = client;
    }

    public Os getOs() {
        return os;
    }

    public void setOs(Os os) {
        this.os = os;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }
}
