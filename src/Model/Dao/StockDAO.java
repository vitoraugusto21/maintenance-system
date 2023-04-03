package Model.Dao;

import Model.entities.Product;

public interface StockDAO {
    public void addProduct(Product product);
    public void removerProduto(Product product);

}
