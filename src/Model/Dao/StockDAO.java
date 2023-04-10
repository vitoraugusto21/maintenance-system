package Model.Dao;

import Model.entities.Client;
import Model.entities.Product;

import java.util.ArrayList;

public interface StockDAO {
    public void insertProduct(Product product);
    public void deleteProduct(Product product);

    ArrayList<Product> getAllProducts();

}
