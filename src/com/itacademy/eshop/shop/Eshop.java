package com.itacademy.eshop.shop;

import com.itacademy.eshop.exceptions.ProductNotFoundException;
import com.itacademy.eshop.product.Product;
import com.itacademy.eshop.product.types.Category;

import java.util.ArrayList;

public class Eshop {
    private String name;
    private ArrayList<Product> products;

    public Eshop(String name, ArrayList<Product> products) {
        this.name = name;
        this.products = products;
    }

    public void printProducts() {
        /**
         * Prints all products in the shop. You have to implement displayProductInfo() method in each Product class.
         * Make Product class abstract and implement displayProductInfo() method in each child class.
         */
        for (Product product : products) {
//            product.displayProductInfo();
        }
    }

    public void addProduct(Product shirt) {
        products.add(shirt);
    }


    /** This is an example of method overloading
     * We have created two methods with the same name "removeProduct", but with different parameters
     * One method takes a String parameter and the other method takes a Category parameter
     * This allows us to remove a product either by name or by category, using the same method name
     * */
    public void removeProduct(String name) {
        for (int i = 0; i < products.size(); i++) {
            Product product = products.get(i);
            if (product.getName().equals(name)) {
                products.remove(product);
                break;
            }
        }
    }
    public void removeProduct(Category category) {
        for (int i = 0; i < products.size(); i++) {
            Product product = products.get(i);
            if (product.getCategory().equals(category)) {
                products.remove(i);
                break;
            }
        }
    }

    public void changePriceForProduct(String productName, int price) {
        for (Product product : products) {
            if (product.getName().equals(productName)) {
                product.setPrice(price);
                break;
            }
        }
    }

    public Product findProductByName(String name) throws ProductNotFoundException {
        for (Product product : products) {
            if (product.getName().equals(name)) {
                return product;
            }
        }
        throw new ProductNotFoundException("Product with name " + name + " not found.");

    }
}
