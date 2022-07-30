package com.inventorymanagementsystem.hkunzler_software1_pa;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class ProductFormController {
    @FXML
    public Label productFormTitle;

    // Nested fxml
    @FXML
    TableViewController partsTableController;

    @FXML
    TableViewController addedPartsController;

    @FXML
    InventoryFormController productFormController;

    // Set header for product (Add/Modify)
    public void setHeader(String productFormTitle) {
        this.productFormTitle.setText(productFormTitle + " Product");
    }
}
