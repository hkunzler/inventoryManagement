package com.inventorymanagementsystem.hkunzler_software1_pa.models;

import javafx.collections.ObservableList;

public class Product extends Part {

    // Part(s) in products
    public ObservableList<Part> productPartsTest;

    public Product(int id, String name, double price, int stock, int min, int max, ObservableList<Part> productPartsTest) {
        super(id, name, price, stock, min, max);
        this.productPartsTest = productPartsTest;
    }

    // In progress
    public ObservableList<Part> getProductPartsTest2() {
        return productPartsTest;
    }

    public void setProductParts(ObservableList<Part> productParts) {
        this.productPartsTest = productParts;
    }

    public void setProductPartTest(Part productPart) {
        productPartsTest.set(0, productPart);
    }

    public void addProductParts(ObservableList<Part> part) {
        productPartsTest.addAll(part);
    }


}
