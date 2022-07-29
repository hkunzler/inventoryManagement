package com.inventorymanagementsystem.hkunzler_software1_pa.models;

import javafx.collections.ObservableList;

public class Product extends Part {
    private ObservableList<Integer> productParts;

    public Product(int id, String name, double price, int stock, int min, int max, ObservableList<Integer> productParts) {
        super(id, name, price, stock, min, max);
        this.productParts = productParts;

    }

    public ObservableList<Integer> getProductParts() {
        return productParts;
    }

    public void setProductParts(ObservableList<Integer> productParts) {
        this.productParts = productParts;
    }
}
