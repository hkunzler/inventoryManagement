package com.inventorymanagementsystem.hkunzler_software1_pa.models;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Product extends Part {

    // Part(s) in products
    public ObservableList<Part> productPartsTest;

    public Product(int id, String name, double price, int stock, int min, int max, ObservableList<Part> productPartsTest) {
        super(id, name, price, stock, min, max);
        this.productPartsTest = productPartsTest;
        this.productPartsTest = FXCollections.observableArrayList(productPartsTest);

    }

    // TODO: In progress
    public ObservableList<Part> getProductParts() {
        return productPartsTest;
    }
}
