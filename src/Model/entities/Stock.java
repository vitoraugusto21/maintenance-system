package Model.entities;

import java.util.ArrayList;

public class Stock extends Product{
    private ArrayList<Product> listProducts;

    public Stock() {
    }

    public ArrayList<Product> getListProducts() {
        return listProducts;
    }

    public void setListProducts(ArrayList<Product> listProducts) {
        this.listProducts = listProducts;
    }

    public Stock(String productCode, String productName, Double productPrice, Integer productQuantity, ArrayList<Product> listProducts) {
        super(productCode, productName, productPrice, productQuantity);
        this.listProducts = listProducts;


    }
}
