package Model.Dao;

import Model.entities.Product;

import java.util.ArrayList;

public interface StockDAO {
    public void addProduct(Product product, ArrayList productList);
    public void removeProduct(Product product, ArrayList productList);

}
