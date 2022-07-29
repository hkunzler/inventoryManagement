package com.inventorymanagementsystem.hkunzler_software1_pa;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class ProductFormController {
    @FXML
    public Label productFormTitle;
    @FXML
    TableViewController partsTableController;

    @FXML
    TableViewController addedPartsController;

    @FXML
    InventoryFormController productFormController;

    public void setHeader(String productFormTitle) {
        this.productFormTitle.setText(productFormTitle + " Product");
    }
}
