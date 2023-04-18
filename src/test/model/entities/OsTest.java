package test.model.entities;

import model.dao.OsDAOImp;
import model.entities.Os;
import model.entities.Product;
import org.junit.Assert;
import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static org.junit.Assert.assertEquals;
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

    @Test
    public void addDurationTest() throws ParseException {
        Os os = new Os("1234");
        String startTime = "20/11/2023";
        String endTime = "22/11/2023";
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        Date startDate = format.parse(startTime);
        Date endDate = format.parse(endTime);
        os.setStartTime(startDate);
        os.setEndTime(endDate);
        os.addDuration();
        assertEquals(2, os.getDuration());
    }


    @Test
    public void addProgramsTest() {
        Os os = new Os("1234");
        os.addPrograms(1);

        assertEquals(os.getPrograms() * 1, os.getTotalValue(), 0.0);
    }


    @Test
    public void cleaningTest() {
        Os os = new Os("1234");
        os.cleaning();

        assertEquals(os.getCleaning(), os.getTotalValue(), 0.0);
    }

    @Test
    public void addOperationalSystemTest() {
        Os os = new Os("1234");
        os.addOperationalSystem();

        assertEquals(os.getOperationalSystem(), os.getTotalValue(), 0.0);
    }

}
