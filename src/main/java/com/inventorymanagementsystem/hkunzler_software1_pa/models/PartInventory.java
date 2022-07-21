package com.inventorymanagementsystem.hkunzler_software1_pa.models;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class PartInventory {
    public static final ObservableList<Part> parts = FXCollections.observableArrayList();

    public static void addPart(Part part) {
        parts.add(part);
    }

    public static ObservableList<Part> getParts() {
        return parts;
    }
}
