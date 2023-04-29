package model.dao;

import model.entities.Product;

import java.util.ArrayList;

/**
 * Interface que apresenta o CRUD dos itens no estoque
 */
public interface StockDAO {
    void insertProduct(Product product, ArrayList stock);

    void deleteProduct(Product product, ArrayList stock);


    ArrayList<Product> getAllProducts();

}
