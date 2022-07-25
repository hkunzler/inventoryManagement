package com.inventorymanagementsystem.hkunzler_software1_pa.models;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class PartInventory {
    public static final ObservableList<Part> parts = FXCollections.observableArrayList();
    public static final ObservableList<Part> modifiedParts = FXCollections.observableArrayList();
    public static final ObservableList<Part> addedProducts = FXCollections.observableArrayList();
    public static final ObservableList<Part> products = FXCollections.observableArrayList();

    public static void addPart(Part part) {
        parts.add(part);
    }

    public static void deletePart(Part part, ObservableList<Part> parts) {
        parts.remove(part);
    }

    public static ObservableList<Part> getParts() {
        return parts;
    }

    public static ObservableList<Part> getModifiedParts() {
        return modifiedParts;
    }

    public static void addModifiedPart(Part part, ObservableList<Part> modifiedParts) {
        modifiedParts.add(part);
    }

    public static ObservableList<Part> getAddedProducts() {
        return addedProducts;
    }

    public static void addAddedProducts(Part part, ObservableList<Part> addedProducts) {
        addedProducts.add(part);
    }

    public static void deleteAddedProduct(Part part, ObservableList<Part> addedProducts) {
        addedProducts.remove(part);
    }

    public static void addProduct(Part part) {
        products.add(part);
    }

    public static void deleteProduct(Part part, ObservableList<Part> products) {
        products.remove(part);
    }

    public static ObservableList<Part> getProducts() {
        return products;
    }
}
