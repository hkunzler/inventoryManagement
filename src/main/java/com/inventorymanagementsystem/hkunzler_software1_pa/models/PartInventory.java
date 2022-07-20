package com.inventorymanagementsystem.hkunzler_software1_pa.models;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class PartInventory {
    public final ObservableList<Part> parts = FXCollections.observableArrayList();

    public void addPart(Part part) {
        parts.add(part);
    }

    public ObservableList<Part> getParts() {
        return parts;
    }
}
