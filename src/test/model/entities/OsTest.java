package test.model.entities;

import model.dao.OsDAOImp;
import model.entities.Os;
import model.entities.Product;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class OsTest {
    @Test
    public void addPartsTest() {
        Os os = new Os("1234");
        Product product = new Product("1234", "Memoria RAM", 40.00, 2, 20.00);
        os.addParts(product);

        /* verificar se o produto foi adicionado a lista de produtos utilizados na os*/
        assertTrue(os.getUsedParts().contains(product));

        /* verificar se a quantidade de produtos em estoque diminuiu*/
        Assert.assertEquals(1, product.getProductQuantity(), 0);

        /* verificar se foi adicionado o valor do produto na os*/
        Assert.assertEquals(40, os.getTotalValue(), 0);
    }
}
