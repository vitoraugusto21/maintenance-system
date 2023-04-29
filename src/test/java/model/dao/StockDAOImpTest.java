package test.model.dao;

import main.model.dao.StockDAOImp;
import main.model.entities.Product;
import main.model.entities.Stock;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class StockDAOImpTest {

    @Test
    public void insertProductTest() {
        Product product = new Product();
        Stock stock = new Stock();
        StockDAOImp stockDAOImp = new StockDAOImp();
        ArrayList<Product> stockProducts = new ArrayList<>();
        stock.setListProducts(stockProducts);

        stockDAOImp.insertProduct(product, stock.getListProducts());

        assertTrue(stock.getListProducts().contains(product));
    }

    @Test
    public void deleteProductTest() {
        Product product = new Product();
        Stock stock = new Stock();
        StockDAOImp stockDAOImp = new StockDAOImp();
        ArrayList<Product> stockProducts = new ArrayList<>();
        stock.setListProducts(stockProducts);

        stockDAOImp.insertProduct(product, stock.getListProducts());
        stockDAOImp.deleteProduct(product, stock.getListProducts());
        assertFalse(stock.getListProducts().contains(product));
    }


}