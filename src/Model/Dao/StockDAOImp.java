package Model.Dao;

import Model.entities.Client;
import Model.entities.Product;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class StockDAOImp implements StockDAO{

    public StockDAOImp(){

    }

    private final Map<String, Product> stock = new HashMap<>();

    public void insertProduct(Product product) {
        stock.put(product.getProductCode(), product);
    }
    public void deleteProduct(Product product){
        stock.remove(product.getProductCode());
    }

    @Override
    public ArrayList<Product> getAllProducts() {
        return new ArrayList<>(stock.values());
    }
}
