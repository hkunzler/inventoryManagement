package com.inventorymanagementsystem.hkunzler_software1_pa.models;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class PartInventory {
    public static final ObservableList<Part> parts = FXCollections.observableArrayList();
    public static final ObservableList<Part> modifiedParts = FXCollections.observableArrayList();
    public static final ObservableList<Part> addedProducts = FXCollections.observableArrayList();
    public static final ObservableList<Part> products = FXCollections.observableArrayList();
    public static final ObservableList<Part> modifiedProducts = FXCollections.observableArrayList();

    public static void addPart(Part part) {
        parts.add(part);
    }

    public static void deletePart(Part part) {
        parts.remove(part);
    }

    public static ObservableList<Part> getParts() {
        return parts;
    }

    public static ObservableList<Part> getModifiedParts() {
        return modifiedParts;
    }

    public static void addModifiedPart(Part part) {
        modifiedParts.add(part);
    }

    public static ObservableList<Part> getProductParts() {
        return addedProducts;
    }

    public static void addProductPart(Part part) {
        addedProducts.add(part);
    }

    public static void deleteProductPart(Part part) {
        addedProducts.remove(part);
    }

    public static void addProduct(Part part) {
        products.add(part);
    }

    public static void deleteProduct(Part part) {
        products.remove(part);
    }

    public static ObservableList<Part> getProducts() {
        return products;
    }

    public static ObservableList<Part> getModifiedProducts() {
        return modifiedProducts;
    }

    public static void addModifiedProducts(Part part) {
        modifiedProducts.add(part);
    }
}
