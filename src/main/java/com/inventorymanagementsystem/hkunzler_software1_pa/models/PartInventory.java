package com.inventorymanagementsystem.hkunzler_software1_pa.models;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class PartInventory {

    // Lists
    public static final ObservableList<Part> parts = FXCollections.observableArrayList();
    public static final ObservableList<Part> modifiedParts = FXCollections.observableArrayList();
    public static final ObservableList<Part> products = FXCollections.observableArrayList();
    public static final ObservableList<Part> addedProducts = FXCollections.observableArrayList();
    public static final ObservableList<Part> modifiedProducts = FXCollections.observableArrayList();
    public static final ObservableList<Product> productsTest = FXCollections.observableArrayList();

    // Getting
    public static ObservableList<Part> getParts() {
        return parts;
    }

    public static ObservableList<Part> getModifiedParts() {
        return modifiedParts;
    }

    public static ObservableList<Part> getProducts() {
        return products;
    }

    public static ObservableList<Part> getModifiedProducts() {
        return modifiedProducts;
    }

    public static ObservableList<Part> getProductParts() {
        return addedProducts;
    }

    public static ObservableList<Product> getProductsTest() {
        return productsTest;
    }

    public static ObservableList<Part> getProductPartsTest(Product product) {
        return productsTest.get(productsTest.indexOf(product)).getProductPartsTest2();
    }


    // Adding
    public static void addPart(Part part) {
        parts.add(part);
    }

    public static void addModifiedPart(Part part) {
        modifiedParts.add(part);
    }

    public static void addProduct(Part part) {
        products.add(part);
    }

    public static void addModifiedProducts(Part part) {
        modifiedProducts.add(part);
    }

    public static void addProductPart(Part part) {
        addedProducts.add(part);
    }

    public static void addProductsTest(Product product) {
        productsTest.add(product);
    }

    public static void addProductsPartsTest(Product product, ObservableList<Part> part) {
        productsTest.get(productsTest.indexOf(product)).getProductPartsTest2().addAll(part);
    }


    // Deleting
    public static void deletePart(Part part) {
        parts.remove(part);
    }

    public static void deleteProduct(Part part) {
        products.remove(part);
    }

    public static void deleteProductPart(Part part) {
        addedProducts.remove(part);
    }
}
