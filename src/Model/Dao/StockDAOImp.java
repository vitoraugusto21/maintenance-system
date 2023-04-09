package Model.Dao;

import Model.entities.Client;
import Model.entities.Product;
import Model.Dao.

import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class StockDAOImp implements StockDAO{

    public StockDAOImp(){

    };

    private final Map<String, Product> stock = new HashMap<>();

    public List<Product> productList(){
        return productList();
    }
    public void addProduct(Product product){

    }

    @Override
    public void insertProduct(Product product) {
        stock.put(product.getProductCode(), Product);
    }
    public void removerProduto(Product product){

    }
}
