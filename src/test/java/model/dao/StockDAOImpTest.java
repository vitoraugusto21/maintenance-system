package model.dao;

import model.dao.StockDAOImp;
import model.entities.Product;
import model.entities.Stock;
import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class StockDAOImpTest {

    @Test
    public void insertProductTest() throws IOException {
        Product product = new Product();
        Stock stock = new Stock();
        StockDAOImp stockDAOImp = new StockDAOImp();
        ArrayList<Product> stockProducts = new ArrayList<>();
        stock.setListProducts(stockProducts);

        stockDAOImp.insertProduct(product);

        assertTrue(stock.getListProducts().contains(product));
    }

    @Test
    public void deleteProductTest() throws IOException {
        Product product = new Product();
        Stock stock = new Stock();
        StockDAOImp stockDAOImp = new StockDAOImp();
        ArrayList<Product> stockProducts = new ArrayList<>();
        stock.setListProducts(stockProducts);

        stockDAOImp.insertProduct(product);
        stockDAOImp.deleteProduct(product);
        assertFalse(stock.getListProducts().contains(product));
    }


}