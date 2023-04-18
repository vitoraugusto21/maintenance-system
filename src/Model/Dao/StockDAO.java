package Model.Dao;

import Model.entities.Client;
import Model.entities.Product;
import Model.entities.Stock;

import java.util.ArrayList;

/**
 * Interface que apresenta o CRUD dos itens no estoque
 */
public interface StockDAO {
    public void insertProduct(Product product, ArrayList stock);
    public void deleteProduct(Product product, ArrayList stock);



    ArrayList<Product> getAllProducts();

}
