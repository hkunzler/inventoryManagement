package com.inventorymanagementsystem.hkunzler_software1_pa.models;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class PartInventory {
    public static final ObservableList<Part> parts = FXCollections.observableArrayList();
    public static final ObservableList<Part> modifiedParts = FXCollections.observableArrayList();

    public static void addPart(Part part) {
        parts.add(part);
    }

    public static void deletePart(Part part, ObservableList<Part> parts){
        parts.remove(part);
    }

    public static ObservableList<Part> getParts() {
        return parts;
    }
    public static ObservableList<Part> getModifiedParts() {
        return modifiedParts;
    }

    public static void addModifiedPart(Part part, ObservableList<Part>  modifiedParts) {
        modifiedParts.add(part);
    }
}
