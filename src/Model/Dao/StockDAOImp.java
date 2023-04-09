package Model.Dao;

import Model.entities.Product;

import java.util.ArrayList;
import java.util.List;

public class StockDAOImp implements StockDAO{

    public StockDAOImp(){};
    public void addProduct(Product product, ArrayList productList){
        productList.add(product);
    };
    public void removeProduct(Product product,ArrayList productList){
        productList.remove(product);
    };
}
