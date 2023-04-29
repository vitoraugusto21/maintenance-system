package model.dao;

import model.entities.Product;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


/**
 * Classe responsável pela implementação do estoque (Stock) de produtos.
 */
public class StockDAOImp implements StockDAO {

    private final Map<String, Product> stock = new HashMap<>();

    public StockDAOImp() {

    }

    /**
     * Insere um produto no estoque.
     *
     * @param product - O produto a ser inserido no estoque.
     * @param stock   - A lista que representa o estoque.
     */
    @Override
    public void insertProduct(Product product, ArrayList stock) {
        stock.add(product);
    }

    /**
     * Remove um produto do estoque.
     *
     * @param product - O produto a ser removido do estoque.
     * @param stock   - A lista que representa o estoque.
     */
    @Override
    public void deleteProduct(Product product, ArrayList stock) {
        stock.remove(product);
    }

    /**
     * Retorna uma lista com todos os produtos do estoque.
     *
     * @return - Uma lista com todos os produtos do estoque.
     */
    @Override
    public ArrayList<Product> getAllProducts() {
        return new ArrayList<>(stock.values());
    }
}
