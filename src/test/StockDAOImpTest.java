package test;

import static org.junit.Assert.*;

import Model.Dao.StockDAOImp;
import Model.entities.Product;
import Model.entities.Stock;
import org.junit.Before;
import org.junit.Test;
import java.util.ArrayList;

public class StockDAOImpTest {

    @Test
    public void insertProductTest(){
        Product product = new Product();
        Stock stock = new Stock();
        StockDAOImp stockDAOImp = new StockDAOImp();
        ArrayList<Product> stockProducts = new ArrayList<>();
        stock.setListProducts(stockProducts);

        stockDAOImp.insertProduct(product, stock.getListProducts());

        assertTrue(stock.getListProducts().contains(product));
    }


}