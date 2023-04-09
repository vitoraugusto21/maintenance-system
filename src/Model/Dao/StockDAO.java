package Model.Dao;

import Model.entities.Product;

public interface StockDAO {
    public void insertProduct(Product product);
    public void deleteProduct(Product product);


}
